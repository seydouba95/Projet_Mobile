package com.example.projet_securite.Activities.PageDetails;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.projet_securite.R;
import com.example.projet_securite.models.Client;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailClientActivity extends AppCompatActivity {
    TextView textviewNomClient,textviewAdresseClient,textviewTelephoneClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_client);

        textviewNomClient = this.findViewById(R.id.detail_client_nom);
        textviewAdresseClient = this.findViewById(R.id.details_client_adresse);
        textviewTelephoneClient = this.findViewById(R.id.details_client_telephone);

        String clientId = getIntent().getStringExtra("clientId");
        lireEtAfficherClient(clientId);
    }

    private void lireEtAfficherClient(@NonNull final String clientId) {
        ValueEventListener clientListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Récuper les informations du client
                Client client = dataSnapshot.getValue(Client.class);
                client.id = clientId;

                if (client == null) {
                    Log.e("myApp", "Client is null - -- -- - -- -- -- -");
                    return;
                }

                // Maintenant qu'on le client, afficher les informations
                // dans les textview etc...
                textviewNomClient.setText(client.getNom());
                textviewAdresseClient.setText(client.getAddresse());
                textviewTelephoneClient.setText(client.getTelephone());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Afficher l'erreur sur la console
                Log.w("myApp", "loadClient:onCancelled", databaseError.toException());
                // ...
            }
        };

        DatabaseReference clientRef = FirebaseDatabase.getInstance().getReference("Clients")
                .child(clientId);
        clientRef.addValueEventListener(clientListener);
    }
}
