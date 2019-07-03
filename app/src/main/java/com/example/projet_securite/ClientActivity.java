package com.example.projet_securite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClientActivity extends AppCompatActivity {
    EditText txt_client_nom, txt_client_prenom, txt_client_adresse,txt_client_email,txt_client_tel;
    Button btn_envoi_client;

    FirebaseDatabase database;
    DatabaseReference myRef;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.formulaire_client);
        getSupportActionBar().setTitle("Formulaire Client");

        txt_client_prenom = (EditText)findViewById(R.id.txt_client_prenom);
        txt_client_nom = (EditText)findViewById(R.id.txt_client_nom);
        txt_client_adresse = (EditText)findViewById(R.id.txt_client_address);
        txt_client_tel = (EditText)findViewById(R.id.txt_client_tel);
        txt_client_email= (EditText)findViewById(R.id.txt_client_email);
        btn_envoi_client = (Button)findViewById(R.id.btn_envoi_client);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Clients");

        btn_envoi_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engager();
                txt_client_prenom.setText("");
                txt_client_nom.setText("");
                txt_client_adresse.setText("");
                txt_client_tel.setText("");
                txt_client_email.setText("");
            }
        });

    }

    private void engager(){

        String prenom_client = txt_client_prenom.getText().toString().trim();
        String nom_client = txt_client_nom.getText().toString().trim();
        String adresse_client = txt_client_adresse.getText().toString().trim();
        String telephone_client = txt_client_tel.getText().toString().trim();
        String email_client = txt_client_email.getText().toString().trim();

        if (!TextUtils.isEmpty(prenom_client) && !TextUtils.isEmpty(nom_client) && !TextUtils.isEmpty(adresse_client) &&
                !TextUtils.isEmpty(telephone_client) && !TextUtils.isEmpty(email_client)){

           String id = myRef.push().getKey();
            client = new Client(id,prenom_client,nom_client,adresse_client,telephone_client,email_client);
            myRef.child(id).setValue(client);
            Toast.makeText(ClientActivity.this," envoie reussi",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Veuillez entrer  les informations requises SVP !!", Toast.LENGTH_SHORT).show();
        }

    }

}