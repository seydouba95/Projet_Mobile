package com.example.projet_securite.Activities.PageDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.projet_securite.R;
import com.example.projet_securite.models.Agence;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailAgenceActivity extends AppCompatActivity {

    TextView textviewNomAgence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_agence);

        textviewNomAgence = this.findViewById(R.id.detail_agence_nom);

        String agenceId = getIntent().getStringExtra("agenceId");
        lireEtAfficherAgence(agenceId);
    }

    private void lireEtAfficherAgence(final String agenceId) {
        ValueEventListener agenceListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Récuper les informations de l'agence
                Agence agence = dataSnapshot.getValue(Agence.class);
                agence.id = agenceId;

                if (agence == null) {
                    Log.e("myApp", "Agence is null - -- -- - -- -- -- -");
                    return;
                }

                // Maintenant qu'on a l'agence, afficher les informations
                // dans les textview etc...
                textviewNomAgence.setText(agence.getNom());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Afficher l'erreur sur la console
                Log.w("myApp", "loadAgence:onCancelled", databaseError.toException());
                // ...
            }
        };

        DatabaseReference agenceRef = FirebaseDatabase.getInstance().getReference("Users")
                .child(agenceId);
        agenceRef.addValueEventListener(agenceListener);
    }
}
