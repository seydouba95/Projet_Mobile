package com.example.projet_securite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;

public class AgenceActivity extends AppCompatActivity {
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agence);

        Intent i = this.getIntent();
        String email = i.getStringExtra("email");

        Utilitaire.agenceConnecte = email;

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