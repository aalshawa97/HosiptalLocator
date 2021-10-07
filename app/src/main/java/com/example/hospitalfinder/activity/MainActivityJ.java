package com.example.hospitalfinder.activity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hospitalfinder.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityJ extends AppCompatActivity implements MainActivityJinterface {

    private static int SIGN_IN_REQUEST_CODE = 1;
    private FirebaseListAdapter<ChatMessage> adapter;
    String[] values = new String[] { "begin_button", "add_friend", "sign_out_button",
            };
    //Get reference to the database
    //private Firebase firebase = new Firebase("https://encryptedmessanger.firebaseio.com/");


    RelativeLayout activity_main;
    FloatingActionButton fab;
    Button DecryptButton;
    Toast decryptToast;
    Context context;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_sign_out )
        {
            AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Snackbar.make(findViewById(android.R.id.content),"You have been signed out.",Snackbar.LENGTH_SHORT).show();
                    finish();
                }
            });
        }


        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    /*
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try
        {
            String val = values[position];
            Class ourClass  = Class.forName("com.example.listview."+val);
            Intent intent = new Intent(MainActivity.this,ourClass);
            startActivity(intent);
        }catch(Exception e){
            e.prinStacktrace();
        }
    }*/



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Snackbar.make(findViewById(android.R.id.content),"Successfully signed in. Welcome ",Snackbar.LENGTH_SHORT).show();
                String aKey = null;
                displayChatMessage(aKey);
            }
            else
            {
                Snackbar.make(findViewById(android.R.id.content),"Unable to sign in, please try again",Snackbar.LENGTH_SHORT).show();
                finish();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);

        activity_main = (RelativeLayout)findViewById(R.id.activity_main);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        /*
        fab.setOnClickListener(v -> {
            EditText input = (EditText)findViewById(R.id.input);
            FirebaseDatabase.getInstance().getReference().push().setValue(new ChatMessage(input.getText().toString(),FirebaseAuth.getInstance().getCurrentUser().getEmail()));
            input.setText("");
        });
        */

        //Check if not sign-in then navigate Signin page
        if(FirebaseAuth.getInstance().getCurrentUser() == null)
        {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),SIGN_IN_REQUEST_CODE);
        }
        else
        {
            Snackbar.make(findViewById(android.R.id.content),"Welcome "+ FirebaseAuth.getInstance().getCurrentUser().getEmail(),Snackbar.LENGTH_SHORT).show();
            //Load content
            String aKey = null;
            displayChatMessage(aKey);
        }

    }

    public void sendMessage(final View view)
    {
        EditText input = (EditText)findViewById(R.id.input);
        FirebaseDatabase.getInstance().getReference().push().setValue(new ChatMessage(input.getText().toString(),FirebaseAuth.getInstance().getCurrentUser().getEmail()));
        input.setText("");
    }

    public void decryptMessage(final View view)
    {

        //Trying to see if I can detect button clicks on the decrypt button
        DecryptButton = (Button)view;

        if(DecryptButton != null)
        {
            DecryptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                //This method runs everytime the decrypt button is clicked
                public void onClick(View v) {
                    //Log statement to assure us that we have gotten here
                    Log.d("Ran","Decrypting");

                    //Now prompt the user for the key to use for decrypting the message
                    DecryptionPopup decryptionPopup = new DecryptionPopup();
                    startActivity(new Intent(MainActivityJ.this,DecryptionPopup.class));


                }


            });
        }
    }

    public void displayChatMessage(final String aKey)
    {

        ListView listOfMessage = (ListView)findViewById(R.id.list_of_message);
        adapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,R.layout.list_item,FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                //Get references to the views of list_item.xml
                TextView messageText,messageUser,messageTime;
                messageText = (TextView) v.findViewById(R.id.message_text);
                messageUser = (TextView) v.findViewById(R.id.message_user);
                messageTime = (TextView) v.findViewById(R.id.message_time);

                /*
                //Encrypt messages with caesar

                StringBuilder tempMessageText = new StringBuilder(model.getMessageText());
                int ascii = 0;

                    //Key for encryption
                    int key = 1;

                    for (int i = 0; i<tempMessageText.length(); i++)
                    {
                        tempMessageText.setCharAt(i,toUpperCase(tempMessageText.charAt(i)));
                        ascii = ((((int)tempMessageText.charAt(i)-65 + key) %26) + 65);
                        tempMessageText.setCharAt(i,(char)ascii);
                    }
                */

                //Here is where I am trying to convert a message to a number so that I can encrypt it with my RSA functions

                 long plainText = 100;

                //Get the plaintext from the textview
                StringBuilder tempPlainText = new StringBuilder(model.getMessageText());

                plainText = Long.parseLong(tempPlainText.toString());

                Log.d("Encrypting plaintext: ", String.valueOf(plainText));


                //Encrypt messages with RSA
                RSAencryption rsAencryption = new RSAencryption();
                plainText = rsAencryption.KeyGeneration(plainText);


                messageText.setText(String.valueOf(plainText));
                messageUser.setText(model.getMessageUser());
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",model.getMessageTime()));


            }
        };

        listOfMessage.setAdapter(adapter);
    }


    public void displayDecryptedChatMessage( String valueKey)
    {
        //Trying new method for decryption

        /*
        final TextView messageText,messageUser,messageTime;
        View v = new View(getApplicationContext());
        messageText = (TextView) v.findViewById(R.id.message_text);

        Log.d("Key: ", valueKey);

        //Decrypt the message
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String data = dataSnapshot.getValue(String.class);
                messageText.setText("cool");

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        */



        //Decrypt Message

        // ListView listOfMessage = (ListView)findViewById(R.id.list_of_message);



        /*
        adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {

                adapter.getRef(0).child("-KeVKcb1pqDchA75i-Jd").setValue("I can update this");

            }
        };
        */

        //Update the message with the decrypted text

                //Decrypt messages
                /*
                        StringBuilder decryptedMessage = new StringBuilder(messageText.toString());
                        int ascii = 0;

                        for (int i = 0; i<decryptedMessage.length(); i++)
                        {

                            decryptedMessage.setCharAt(i,toLowerCase(decryptedMessage.charAt(i)));

                            ascii = ((((int)decryptedMessage.charAt(i) - 97 - (int) valueKey.charAt(0) + 26) %26) + 97);
                            decryptedMessage.setCharAt(i,(char)ascii);



                        }
                        */


    }


}