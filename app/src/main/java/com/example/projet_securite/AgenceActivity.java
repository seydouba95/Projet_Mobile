package com.example.projet_securite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AgenceActivity extends AppCompatActivity {

     DatabaseReference myref;
     RecyclerView myrecycleview;
     ArrayList<Gardien> ListGardien ;
     MyadapterAgence myadapterAgence;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agence);

        //Intent i = this.getIntent();
        //String email = i.getStringExtra("email");

       // Utilitaire.agenceConnecte = email;

        // Tu peut accéder aux informations de l'utilisateur connecté
        // partout dans ton project avec le code suivant.

       // mAuth = FirebaseAuth.getInstance();
       // FirebaseUser user = mAuth.getCurrentUser();

        // user.getDisplayName();
        // user.getEmail();
        // user.getUid(); // get the object ID
        // user.getPhoneNumber()
        // etc...²

            myrecycleview = findViewById(R.id.myrecycleview1);
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
                    myadapterAgence = new MyadapterAgence(AgenceActivity.this, ListGardien);
                    myrecycleview.setAdapter(myadapterAgence);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        FloatingActionButton fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AgenceActivity.this, Deposer.class);
                startActivity(intent);
            }
        });

    }
}