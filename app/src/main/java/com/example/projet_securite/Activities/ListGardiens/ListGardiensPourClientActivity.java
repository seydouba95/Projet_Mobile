package com.example.projet_securite.Activities.ListGardiens;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.projet_securite.Myadapter;
import com.example.projet_securite.R;
import com.example.projet_securite.Utilitaire;
import com.example.projet_securite.models.Gardien;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListGardiensPourClientActivity extends AppCompatActivity {

    DatabaseReference myref;
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

                    // Filtrer les gardiens qui ont déja été recruté par un client.
                    if (gardien.getClientId() == null) {
                        ListGardien.add(gardien);
                    }
                }
                myadapter = new Myadapter(ListGardiensPourClientActivity.this, ListGardien);
                myrecycleview.setAdapter(myadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // Cette page est toujours consulté en tant que client même si
        // visité par un utilisateur connecté (agence).
        Utilitaire.profile = "client";
    }
}