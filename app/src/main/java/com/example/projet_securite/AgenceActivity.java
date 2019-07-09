package com.example.projet_securite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class AgenceActivity extends AppCompatActivity {
    DatabaseReference myRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agence);

        Intent i = this.getIntent();
        String email = i.getStringExtra("email");

        Utilitaire.agenceConnecte = email;

        // Tu peut accéder aux informations de l'utilisateur connecté
        // partout dans ton project avec le code suivant.

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        // user.getDisplayName();
        // user.getEmail();
        // user.getUid(); // get the object ID
        // user.getPhoneNumber()
        // etc...²

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