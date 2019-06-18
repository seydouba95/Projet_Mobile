package com.example.projet_securite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {


    private static final int REQUEST_SIGNUP = 0;
    private Button btn_signup;
    private EditText input_email, input_password,input_password_conf;
    private TextView link_login;
    private ProgressBar progressBar;
    private FirebaseAuth myauth;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        getSupportActionBar().setTitle("Creation Compte");

        btn_signup = (Button) findViewById(R.id.btn_signup);
        input_email = (EditText)findViewById(R.id.input_password);
        input_password_conf = (EditText) findViewById(R.id.input_password_conf);
        input_password = (EditText) findViewById(R.id.input_password);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        link_login =(TextView)findViewById(R.id.link_login);
        myauth = FirebaseAuth.getInstance();
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        link_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Administration.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

    }
    private void Login() {
        progressBar.setVisibility(View.VISIBLE);

        String email,password;

        email = input_email.getText().toString().trim();
        password = input_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(Signup.this,"Entrer l'Email SVP !!",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(Signup.this,"Entrer le Password  SVP !!",Toast.LENGTH_LONG).show();
            return;
        }

        myauth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Connection avec success !", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(Signup.this, Agence.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), " Echec de la Connection ! " , Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }


}


