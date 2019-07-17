package com.example.projet_securite.Activities.ListGardiens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.projet_securite.Activities.Formulaires.AjouterGardienActivity;
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

public class ListGardiensPourAgenceActivity extends AppCompatActivity {

     DatabaseReference myref;
     RecyclerView myrecycleview;
     ArrayList<Gardien> listGardiens;
     Myadapter myAdapter;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agence);

        myrecycleview = findViewById(R.id.myrecycleview1);
        myrecycleview.setLayoutManager(new LinearLayoutManager(this));

        listGardiens = new ArrayList<Gardien>();
        myref = FirebaseDatabase.getInstance().getReference().child("Gardiens");

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Gardien gardien = dataSnapshot1.getValue(Gardien.class);

                    if (gardien.getAgenceId().equals(Utilitaire.getAgenceConnecteId())) {
                        // Filtrer les gardiens qui ne sont pas de cette agence.
                        listGardiens.add(gardien);
                    }
                }
                String profile = "agence";
                myAdapter = new Myadapter(ListGardiensPourAgenceActivity.this, listGardiens);
                myrecycleview.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListGardiensPourAgenceActivity.this, AjouterGardienActivity.class);
                startActivity(intent);
            }
        });

        // Arrivé à ce niveau, le profile doit changer à "agence".
         Utilitaire.profile = "agence";
    }
}