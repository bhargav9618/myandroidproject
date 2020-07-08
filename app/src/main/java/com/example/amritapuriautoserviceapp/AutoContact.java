package com.example.amritapuriautoserviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AutoContact extends AppCompatActivity {
    private ArrayList<String> mContactNames = new ArrayList<>();
    private ArrayList<String> mContactNumbers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_contact);
        Intent intent = getIntent();
        String wheels = intent.getStringExtra(MainActivity.WHEELS);

        Log.v("wheels: ", wheels);
        if(wheels.equals("three")){
            mContactNames.add("Mahesh Babu");
            mContactNumbers.add("9848022338");
            mContactNames.add("Pawan Kalyan");
            mContactNumbers.add("9848022339");
            mContactNames.add("Tarak");
            mContactNumbers.add("9848022340");
            mContactNames.add("Ram Charan");
            mContactNumbers.add("9848022341");
            mContactNames.add("Chiru");
            mContactNumbers.add("9848022342");
            mContactNames.add("Balu");
            mContactNumbers.add("9848022343");
            mContactNames.add("Nani");
            mContactNumbers.add("9848022344");
            mContactNames.add("Vijay");
            mContactNumbers.add("9848022345");

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            AutoContactListAdapter contactListAdapter = new AutoContactListAdapter(this, mContactNames, mContactNumbers);
            recyclerView.setAdapter(contactListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else if(wheels.equals("four")){
            mContactNames.add("Mahesh Babu");
            mContactNumbers.add("9848022338");
            mContactNames.add("Pawan Kalyan");
            mContactNumbers.add("9848022339");
            mContactNames.add("Tarak");
            mContactNumbers.add("9848022340");
            mContactNames.add("Ram Charan");
            mContactNumbers.add("9848022341");
            mContactNames.add("Chiru");
            mContactNumbers.add("9848022342");
            mContactNames.add("Balu");
            mContactNumbers.add("9848022343");
            mContactNames.add("Nani");
            mContactNumbers.add("9848022344");
            mContactNames.add("Vijay");
            mContactNumbers.add("9848022345");
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            AutoContactListAdapter contactListAdapter = new AutoContactListAdapter(this, mContactNames, mContactNumbers);
            recyclerView.setAdapter(contactListAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

    }

}
