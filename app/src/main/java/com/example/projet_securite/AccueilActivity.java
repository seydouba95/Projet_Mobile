package com.example.projet_securite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.grpc.okhttp.internal.Util;

public class AccueilActivity extends AppCompatActivity {


    Button buttonEngagement;
    Button buttonGestionAgence;
    Button buttonDeconnexion;
    TextView textviewAgenceConnecte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.accueil);

        mettreAjourUI();
    }



    @Override
    protected void onResume() {
        super.onResume();

        mettreAjourUI();
    }

    private void mettreAjourUI() {
        buttonEngagement = (Button) findViewById(R.id.button_engagement);
        buttonGestionAgence = (Button) findViewById(R.id.button_gestion_agence);
        buttonDeconnexion = (Button) this.findViewById(R.id.accueil_button_deconnexion);
        textviewAgenceConnecte = (TextView) this.findViewById(R.id.accueil_textview_agence);

        buttonEngagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent engagement = new Intent(getApplication(), EngagementActivity.class);
                startActivity(engagement);
            }
        });


        buttonGestionAgence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);
            }
        });

        if (!Utilitaire.unAgenceEstConnecte()) {
            buttonDeconnexion.setVisibility(View.GONE);
            textviewAgenceConnecte.setVisibility(View.GONE);
        } else {
            buttonDeconnexion.setVisibility(View.VISIBLE);
            textviewAgenceConnecte.setVisibility(View.VISIBLE);

            buttonDeconnexion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();

                    // Redémarer l'activity après déconnexion.
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            ValueEventListener agenceListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Récuper les informations de l'agence
                    Agence agence = dataSnapshot.getValue(Agence.class);
                    agence.id = Utilitaire.getAgenceConnecteId();

                    if (agence == null) {
                        Log.e("myApp", "Agence is null - -- -- - -- -- -- -");
                        return;
                    }

                    // Maintenant qu'on a l'agence, afficher les informations
                    // dans les textview etc...
                    textviewAgenceConnecte.setText(agence.getEmail());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Afficher l'erreur sur la console
                    Log.w("myApp", "loadAgence:onCancelled", databaseError.toException());
                    // ...
                }
            };

            DatabaseReference agenceRef = FirebaseDatabase.getInstance().getReference("Users")
                    .child(Utilitaire.getAgenceConnecteId());
            agenceRef.addValueEventListener(agenceListener);
        }
    }
}
