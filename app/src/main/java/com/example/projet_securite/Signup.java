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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {


    private static final int REQUEST_SIGNUP = 0;
    private Button btn_signup;
    private EditText input_email, input_password,input_password_conf,nom,addresse,telephone;
    private TextView link_login;
    private ProgressBar progressBar;


    FirebaseDatabase database ;
    DatabaseReference myRef;
    private FirebaseAuth myauth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        getSupportActionBar().setTitle("Creation Compte");

        btn_signup = (Button) findViewById(R.id.btn_signup);
        input_email = (EditText)findViewById(R.id.email2);
        input_password_conf = (EditText) findViewById(R.id.input_password_conf);
        input_password = (EditText) findViewById(R.id.password2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        link_login =(TextView)findViewById(R.id.link_login);
        nom = (EditText)findViewById(R.id.agence);
        addresse = (EditText)findViewById(R.id.adresse);
        telephone = (EditText)findViewById(R.id.tel);
        database = FirebaseDatabase.getInstance();
         myRef = database.getReference("Users");
        myauth = FirebaseAuth.getInstance();


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  final String email = input_email.getText().toString();
                 String password = input_password.getText().toString();
                String confirPassword = input_password_conf.getText().toString();
                  final String address = addresse.getText().toString();
                 final String name = nom.getText().toString();
                final String phone = telephone.getText().toString();


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

                if (TextUtils.isEmpty(address)){
                    Toast.makeText(Signup.this, "Please Enter Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(Signup.this, "Please Enter name ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(Signup.this, "Please Enter Number Phone", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() > 30) {
                    Toast.makeText(Signup.this, "Password too long ", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.VISIBLE);

                if (password.equals(confirPassword)) {
                    myauth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {

                                        User  info = new User(
                                                  email,
                                                  name,
                                                  address,
                                                  phone
                                          );

                                          FirebaseDatabase.getInstance().getReference("Users")
                                                  .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                  .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                              @Override
                                              public void onComplete(@NonNull Task<Void> task) {
                                                  Toast.makeText(Signup.this, "Le compte a ete bien cree ", Toast.LENGTH_SHORT).show();
                                                  startActivity(new Intent(getApplicationContext(),Administration.class));
                                              }
                                          });


                                    }



                                }


                                //...


                            });
                }else{
                    Toast.makeText(Signup.this, "les deux mots de passe ne sont pas identiques ", Toast.LENGTH_SHORT).show();
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











