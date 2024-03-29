package com.example.projet_securite.Activities.Authentification;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projet_securite.Activities.ListGardiens.ListGardiensPourAgenceActivity;
import com.example.projet_securite.R;
import com.example.projet_securite.Utilitaire;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private Button btn_login;
    private EditText input_email, input_password;
    private TextView link_signup;
    private ProgressBar progressBar;
    private FirebaseAuth myauth;

    @Override
    protected void onStart() {
        super.onStart();

        if (Utilitaire.unAgenceEstConnecte()) {
            // S'il y a déja un agent qui est connecté,
            // passer à la page agenceActivity directement
            // sans demander d'entrer le login et mot de passe.
            Intent intent = new Intent(getApplicationContext(), ListGardiensPourAgenceActivity.class);
            startActivity(intent);

            // Détruire l'activité, nous ne voulons pas que l'utilisateur
            // en cliquant sur bouton retour revienne ici.
            this.finish();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administration);
        getSupportActionBar().setTitle("Connection ListGardiensPourAgenceActivity");

        btn_login = (Button) findViewById(R.id.btn_login);
        input_email = (EditText) findViewById(R.id.email1);
        input_password = (EditText) findViewById(R.id.password1);
        link_signup = (TextView) findViewById(R.id.link_signup);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        myauth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login();

            }
        });

        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

    }

    private void Login() {
        progressBar.setVisibility(View.VISIBLE);

        final String email, password;

        email = input_email.getText().toString().trim();
        password = input_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(LoginActivity.this, "Entrer l'Email SVP !!", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Entrer le Password  SVP !!", Toast.LENGTH_LONG).show();
            return;
        }

        myauth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Connection avec success !", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(getApplicationContext(), ListGardiensPourAgenceActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), " Login ou Mot de passe incorrrect ! ", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }


}
