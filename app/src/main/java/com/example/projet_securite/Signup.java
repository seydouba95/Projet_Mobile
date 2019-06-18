package com.example.projet_securite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;

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
                                              String email = input_email.getText().toString().trim();
                                              String password = input_password.getText().toString().trim();
                                              String confirPassword = input_password_conf.getText().toString().trim();
                                              if (TextUtils.isEmpty(email)) {
                                                  Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                                                  return;
                                              }
                                              if (TextUtils.isEmpty(password)) {

                                                  Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                                                  return;
                                              }

                                              if (TextUtils.isEmpty(confirPassword)) {

                                                  Toast.makeText(Signup.this, "Please Enter ConfirmPassword", Toast.LENGTH_SHORT).show();
                                                  return;

                                              }

                                              if (password.length() < 100) {
                                                  Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();
                                              }

                                              progressBar.setVisibility(View.VISIBLE);

                                              if (password.equals(confirPassword)) {
                                                  myauth.createUserWithEmailAndPassword(email, password)
                                                          .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {

                                                              @Override
                                                              public void onComplete(@NonNull Task<AuthResult> task) {

                                                                  progressBar.setVisibility(View.GONE);
                                                                  if (task.isSuccessful()) {

                                                                      startActivity(new Intent(getApplicationContext(), Administration.class));
                                                                      Toast.makeText(Signup.this, "Le compte a ete bien cree ", Toast.LENGTH_SHORT).show();
                                                                  } else {
                                                                      Toast.makeText(Signup.this, "Authentification Failed ", Toast.LENGTH_SHORT).show();
                                                                  }


                                                              }


                                                              //...


                                                          });
                                              }
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

        }











