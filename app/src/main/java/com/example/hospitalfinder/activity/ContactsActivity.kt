package com.example.hospitalfinder.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.hospitalfinder.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contacts_list_item.*
import android.provider.ContactsContract

import android.content.ContentProviderResult

import android.provider.ContactsContract.CommonDataKinds.Email

import android.content.ContentProviderOperation
import android.media.tv.TvContract.Channels.CONTENT_URI
import android.os.Build

import android.provider.ContactsContract.CommonDataKinds.Phone

import android.provider.ContactsContract.CommonDataKinds.StructuredName
import androidx.annotation.RequiresApi
import java.lang.Exception
import android.content.ContentValues
import android.media.tv.TvContract.Channels.Logo.CONTENT_DIRECTORY
import android.net.Uri
import android.provider.ContactsContract.Contacts
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*


class ContactsActivity: AppCompatActivity() {
    /*
    var aName = findViewById<EditText>(R.id.etName)
    var aEmail = findViewById<EditText>(R.id.etEmail)
    var aPhone = findViewById<EditText>(R.id.etPhone)
    var anAddContact = findViewById<Button>(R.id.btnAdd)
    */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts_list_item)
        val myIntent = Intent(this@ContactsActivity, ChatActivity::class.java)
        //this@ContactsActivity.startActivity(myIntent)
        button.setOnClickListener(){
            val inputValue: String = editText.text.toString()
            if (inputValue == null || inputValue.trim()==""){
                Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            }else{
                textView4.setText(inputValue).toString()
            }
        }
        textView5.setOnClickListener(){
            if (textView4.text.toString() == null || textView4.text.toString().trim()==""){
                Toast.makeText(this,"clicked on reset textView,\n output textView already reset",Toast.LENGTH_LONG).show()
            }else{
                textView4.setText("").toString()
            }
        }
        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed before making any change over EditText",Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed while making any change over EditText",Toast.LENGTH_SHORT).show()
            }
            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"executed after change made over EditText",Toast.LENGTH_SHORT).show()
            }
        })
        Toast.makeText(this, "Contacts activity", Toast.LENGTH_LONG).show()
        addContact()
        //addContact("Shahid Mohmammed", "2134368227")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = "Contacts"
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser != null) {
            val fromUid = firebaseUser.uid
            val rootRef = FirebaseFirestore.getInstance()
            val uidRef = rootRef.collection("users").document(fromUid)
            uidRef.get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val document = task.result
                    if (document.exists()) {
                        val fromUser = document.toObject(User::class.java)
                        val userContactsRef = rootRef.collection("contacts").document(fromUid).collection("userContacts")
                        //First user
                        //rootRef.collection("contacts").document(fromUid).collection("userContacts").add("John Smith")
                        userContactsRef.get().addOnCompleteListener{ t ->
                            if (t.isSuccessful) {
                                val listOfToUserNames = ArrayList<String>()
                                val listOfToUsers = ArrayList<User>()
                                val listOfRooms = ArrayList<String>()
                                for (d in t.result) {
                                    val toUser = d.toObject(User::class.java)
                                    listOfToUserNames.add(toUser.userName)
                                    listOfToUsers.add(toUser)
                                    listOfRooms.add(d.id)
                                }

                                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfToUserNames)
                                list_viw.adapter = arrayAdapter
                                list_viw.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
                                    val intent = Intent(this, ChatActivity::class.java)
                                    intent.putExtra("fromUser", fromUser)
                                    intent.putExtra("toUser", listOfToUsers[position])
                                    intent.putExtra("roomId", "noRoomId")
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addContact() {
        val op_list = ArrayList<ContentProviderOperation>()
        op_list.add(
            ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(
                    ContactsContract.RawContacts.ACCOUNT_NAME,
                    null
                ) //.withValue(RawContacts.AGGREGATION_MODE, RawContacts.AGGREGATION_MODE_DEFAULT)
                .build()
        )

        //First and last names
        op_list.add(
            ContentProviderOperation.newInsert(CONTENT_URI)
                .withValueBackReference(Contacts.Data.RAW_CONTACT_ID, 0)
                .withValue(Contacts.Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE)
                .withValue(StructuredName.GIVEN_NAME, "Second Name")
                .withValue(StructuredName.FAMILY_NAME, "First Name")
                .build()
        )
        op_list.add(
            ContentProviderOperation.newInsert(CONTENT_URI)
                .withValueBackReference(Contacts.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
                .withValue(Phone.NUMBER, "09876543210")
                .withValue(Phone.TYPE, Phone.TYPE_HOME)
                .build()
        )
        op_list.add(
            ContentProviderOperation.newInsert(CONTENT_URI)
                .withValueBackReference(Contacts.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE, Email.CONTENT_ITEM_TYPE)
                .withValue(Email.DATA, "abdullahalshawa@gmail.com")
                .withValue(Email.TYPE, Email.TYPE_WORK)
                .build()
        )
        try {
            val results = contentResolver.applyBatch(ContactsContract.AUTHORITY, op_list)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun addContacts(name: String, phone: String) {
        /*
        val values = ContentValues()
        values.put(Contacts.People.NUMBER, phone)
        values.put(Contacts.People.TYPE, Phone.TYPE_CUSTOM)
        values.put(Contacts.People.LABEL, name)
        values.put(Contacts.People.NAME, name)
        val dataUri = contentResolver.insert(Contacts.People.CONTENT_URI, values)
        var updateUri = Uri.withAppendedPath(dataUri, Contacts.People.Phones.CONTENT_DIRECTORY)
        values.clear()
        values.put(Contacts.Phones.TYPE, Contacts.People.TYPE_MOBILE)
        values.put(Contacts.People.NUMBER, phone)
        updateUri = contentResolver.insert(updateUri!!, values)
        Log.d("CONTACT", "" + updateUri)
        */
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addContact(name: String, phone: String) {
        val values = ContentValues()
        values.put(Phone.CONTENT_ITEM_TYPE, phone)
        values.put(Contacts.CONTENT_TYPE, Phone.TYPE_CUSTOM)
        values.put(Contacts.CONTACT_STATUS_LABEL, name)
        values.put(Contacts.DISPLAY_NAME, name)
        val dataUri: Uri? = contentResolver.insert(CONTENT_URI, values)
        var updateUri: Uri? =
            Uri.withAppendedPath(dataUri, Phone.IN_DEFAULT_DIRECTORY)
        values.clear()
        values.put(Phone.CONTENT_ITEM_TYPE, Phone.TYPE_MOBILE)
        values.put(Phone.CONTENT_ITEM_TYPE, phone)
        updateUri = updateUri?.let { contentResolver.insert(it, values) }
        Log.d("CONTACT", "" + updateUri)
    }
    /*
    public fun fragment_transaction(fragment : Fragment)
    {
        //setContentView(R.layout.contacts_list_item)
        /*
        FragmentTransaction transaction = getSupportFragmentManager ()
            .beginTransaction()
            .replace(R.id.drawer_layout, mFragment);   // < - first problem ( see ad. 1)
        .commit()  // <-  third problem (see ad. 3)

        // second problem ( see ad. 2)
        mFragment = new AnnouncementFragment ();
        Bundle args = new Bundle();
        args.putInt(null, position);
        */
    }
    */

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(menuItem)
        }
    }
}