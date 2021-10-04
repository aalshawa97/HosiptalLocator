package com.example.hospitalfinder.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

import com.example.hospitalfinder.R;

/**
 * Created by abdul on 2/28/2017.
 */

public class DecryptionPopup extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.decryption_input);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height));
    }
        //Decrypt the text now
        int key = 0;
        Button SubmitButton;

        //When the submit button is pressed for getting the decryption key from the user

        public void getKey(View view)
        {

            //Comment this code all out if it is causing errors

            //Trying to see if I can detect button clicks on the submit button


            if(view!= null)
            {

                SubmitButton = (Button)view;

                SubmitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //This method runs everytime the decrypt button is clicked
                    public void onClick(View v) {


                        EditText decryptionEditText = (EditText)findViewById(R.id.editText_inputKey);
                        String valueKey = decryptionEditText.getText().toString();


                       //Log.d("Test: ", valueKey);


                        //Now decrypt the message for the user
                        MainActivity mainActivity = new MainActivity();
                        //Need to get this method to work for decryption

                        mainActivity.displayDecryptedChatMessage(valueKey);




                    }


                });

            }


        }

    }
