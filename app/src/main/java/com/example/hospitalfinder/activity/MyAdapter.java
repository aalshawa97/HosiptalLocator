package com.example.hospitalfinder.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hospitalfinder.room.HospitalR;
import com.example.hospitalfinder.Hospital;
import com.example.hospitalfinder.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContactHolder> {

    // List to store all the contact details
    private ArrayList<HospitalR> contactsList;

    // Counstructor for the Class
    public MyAdapter(ArrayList<HospitalR> contactsList, Context context) {
        this.contactsList = contactsList;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.contact_list_item, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView
    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, final int position) {
        final HospitalR contact = contactsList.get(position);

        // Set the data to the views here
        holder.setContactName(contact.getWord());
        holder.setContactNumber("503-574-7500 ID: "+contact.getWord().length());

        // You can set click listeners to individual items in the viewholder here
        // make sure you pass down the listener or make the Data members of the viewHolder public

    }

    // This is your ViewHolder class that helps to populate data to the view
    public class ContactHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtNumber;

        public ContactHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtNumber = itemView.findViewById(R.id.txt_number);
        }

        public void setContactName(String name) {
            txtName.setText(name);
        }

        public void setContactNumber(String number) {
            txtNumber.setText(number);
        }
    }
}