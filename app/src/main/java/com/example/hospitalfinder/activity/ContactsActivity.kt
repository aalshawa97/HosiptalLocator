package com.example.hospitalfinder.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.hospitalfinder.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contacts_list_item.*

class ContactsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contacts_list_item)
        Toast.makeText(this, "Contacts activity", Toast.LENGTH_LONG).show()
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