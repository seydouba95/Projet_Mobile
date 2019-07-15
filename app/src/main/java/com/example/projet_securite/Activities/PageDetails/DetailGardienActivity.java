package com.example.projet_securite.Activities.PageDetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet_securite.Activities.Formulaires.FormEngagementPourClientActivity;
import com.example.projet_securite.R;
import com.example.projet_securite.Utilitaire;

public class DetailGardienActivity extends AppCompatActivity {

    TextView textViewId;
    TextView textViewAdresse;
    TextView textViewTelephone;
    TextView textViewTaille;
    TextView textViewPoids;
    TextView textViewDate;
    Button buttonEngager;
    Button buttonDetailClient;
    Button buttonDetailAgence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__gardien);
        getSupportActionBar().setTitle("Details Gardiens");

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String adresse = i.getStringExtra("adresse");
        String telephone = i.getStringExtra("telephone");

        String taille = i.getStringExtra("taille");
        String poids = i.getStringExtra("poids");
        String date = i.getStringExtra("date");

        textViewAdresse = this.findViewById(R.id.textView_adresse_gardien);
        textViewAdresse.setText(adresse);

        textViewTelephone = this.findViewById(R.id.textView_tel_gardien);
        textViewTelephone.setText(telephone);

        textViewTaille = this.findViewById(R.id.textView_taille_gardien);
        textViewTaille.setText(taille);

        textViewPoids = this.findViewById(R.id.textView_poids_gardien);
        textViewPoids.setText(poids);

        textViewDate = this.findViewById(R.id.textView_naiss_gardien);
        textViewDate.setText(date);

        buttonEngager = (Button) findViewById(R.id.page_gardien_button_engager);

        buttonDetailAgence = this.findViewById(R.id.page_gardien_button_detail_agence);

        buttonDetailClient = this.findViewById(R.id.page_gardien_button_detail_client);

        if (Utilitaire.profile == "client") {
            // Cacher le button que seul l'agence doit voir
            buttonDetailClient.setVisibility(View.GONE);

            buttonEngager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String gardientId = getIntent().getStringExtra("id");
                    Intent intent = new Intent(DetailGardienActivity.this, FormEngagementPourClientActivity.class);
                    intent.putExtra("gardienId", gardientId);
                    startActivity(intent);
                }
            });

            buttonDetailAgence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String agenceId = getIntent().getStringExtra("agenceId");

                    Intent intent = new Intent(DetailGardienActivity.this, DetailAgenceActivity.class);
                    intent.putExtra("agenceId", agenceId);
                    startActivity(intent);
                }
            });
        } else {
            // Profile = "agence"
            // Cacher les buttons que seul le client doit voir
            buttonDetailAgence.setVisibility(View.GONE);
            buttonEngager.setVisibility(View.GONE);

            String clientId = getIntent().getStringExtra("clientId");

            if (clientId == null) {
                // Au cas ou le ce gardien n'a pas encore été pris par un client,
                // on désactive le button qui méne au détail du client
                buttonDetailClient.setEnabled(false);
            } else {
                // le gardien est lié à un client
                buttonDetailClient.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String clientId = getIntent().getStringExtra("clientId");

                        Intent intent = new Intent(DetailGardienActivity.this, FormEngagementPourClientActivity.class);
                        intent.putExtra("agenceId", clientId);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
