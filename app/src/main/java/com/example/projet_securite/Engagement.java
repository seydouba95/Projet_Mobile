package com.example.projet_securite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Engagement extends AppCompatActivity {

    DatabaseReference myref;
    FirebaseDatabase database;

    RecyclerView myrecycleview;
    ArrayList<Gardien> ListGardien ;


    Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.engagement);

        myrecycleview = findViewById(R.id.myrecycleview);
        myrecycleview.setLayoutManager(new LinearLayoutManager(this));

        ListGardien = new ArrayList<Gardien>();
        myref = FirebaseDatabase.getInstance().getReference().child("Gardiens");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Gardien gardien = dataSnapshot1.getValue(Gardien.class);
                    ListGardien.add(gardien);
                }
                myadapter = new Myadapter(Engagement.this,ListGardien);
                myrecycleview.setAdapter(myadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}