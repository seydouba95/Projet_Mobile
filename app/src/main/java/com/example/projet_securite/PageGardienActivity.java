package com.example.projet_securite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageGardienActivity extends AppCompatActivity {

    TextView textViewId;
    TextView textViewAdresse;
    TextView textViewTelephone;
    TextView textViewTaille;
    TextView textViewPoids;
    TextView textViewDate;
    LinearLayout linearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__gardien);
        getSupportActionBar().setTitle("Details Gardiens");


        Intent i = getIntent();
        String id = i.getStringExtra("id");
        String adresse= i.getStringExtra("adresse");
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

        textViewPoids= this.findViewById(R.id.textView_poids_gardien);
        textViewPoids.setText(poids);

        textViewDate = this.findViewById(R.id.textView_naiss_gardien);
        textViewDate.setText(date);

        linearLayout = (LinearLayout)findViewById(R.id.linearlayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gardientId = getIntent().getStringExtra("id");
                Intent intent = new Intent(PageGardienActivity.this, ClientActivity.class);
                intent.putExtra("gardienId", gardientId);
                startActivity(intent);
            }
        });


    }
}
