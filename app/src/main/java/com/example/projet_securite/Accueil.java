package com.example.projet_securite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    Button buttonRecrutement;
    Button buttonEngagement;
    Button buttonGestionAgence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.accueil);
        buttonRecrutement = (Button) findViewById(R.id.button_recrutement);
        buttonEngagement = (Button) findViewById(R.id.button_engagement);
        buttonGestionAgence = (Button) findViewById(R.id.button_gestion_agence);

        buttonEngagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent engagement = new Intent(getApplication(), Engagement.class);
                startActivity(engagement);
            }
        });
        buttonRecrutement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), com.example.projet_securite.Deposer.class);
                startActivity(intent);

            }
        });

        buttonGestionAgence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), com.example.projet_securite.Administration.class);
                startActivity(intent);

            }
        });
    }

}
