package com.example.projet_securite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PageGardienActivity extends AppCompatActivity {

    TextView textViewId;
    TextView textViewNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__gardien);

        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String nom = i.getStringExtra("nom");

        textViewId = this.findViewById(R.id.textView_id_gardien);
        textViewId.setText(id);
        textViewNom = this.findViewById(R.id.textView_nom_gardien);
        textViewNom.setText(nom);
    }
}
