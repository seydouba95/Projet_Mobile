package com.example.projet_securite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposer extends AppCompatActivity {


    EditText txt_nom, txt_prenom, txt_date, addresse1,txt_taille, txt_poids, tel;
    Button btn_envoi;

    FirebaseDatabase database;
    DatabaseReference myRef;
    Gardien gardien;
    private FirebaseAuth mAuth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.deposer);
        getSupportActionBar().setTitle("Demande de Recrutement");

        txt_nom = (EditText) findViewById(R.id.txt_nom);
        txt_prenom = (EditText) findViewById(R.id.txt_prenom);
        txt_date = (EditText) findViewById(R.id.txt_date);
        addresse1 = (EditText) findViewById(R.id.addresse1);
        txt_taille = (EditText) findViewById(R.id.txt_taille);
        txt_poids = (EditText) findViewById(R.id.txt_poids);
        btn_envoi = (Button) findViewById(R.id.btn_envoi);
        tel = (EditText) findViewById(R.id.tel1);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Gardiens");
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        btn_envoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  recruter();
                  txt_nom.setText("");
                  txt_prenom.setText("");
                  txt_date.setText("");
                  addresse1.setText("");
                  txt_taille.setText("");
                  txt_poids.setText("");
                  tel.setText("");
            }
        });
    }

    private void recruter() {


            String prenom = txt_prenom.getText().toString().trim();
            String nom = txt_nom.getText().toString().trim();
            String date = txt_date.getText().toString();
            String address = addresse1.getText().toString().trim();
            String taille = txt_taille.getText().toString().trim();
            String poids = txt_poids.getText().toString().trim();
            String phone = tel.getText().toString().trim();



            if (!TextUtils.isEmpty(prenom) && !TextUtils.isEmpty(nom) && !TextUtils.isEmpty(date) && !TextUtils.isEmpty(address) &&
                     !TextUtils.isEmpty(taille) && !TextUtils.isEmpty(poids) && !TextUtils.isEmpty(phone)){

                String id = myRef.push().getKey();

                String userId = user.getUid();
                gardien = new Gardien(id,prenom,nom,date,address,taille,poids,phone,null, userId);
                myRef.child(id).setValue(gardien);
                Toast.makeText(Deposer.this,"recrutement reussi",Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(Deposer.this,"please entrer les informations requises  ",Toast.LENGTH_LONG).show();
            }


        }
    }
