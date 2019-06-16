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

public class SignupActivity  extends AppCompatActivity{

    private static final String TAG = "SignupActivity";
    private EditText input_email,input_password,input_password_conf;
    private Button btn_signup;
    private TextView link_login;
    private ProgressBar progressBar2;
    private FirebaseAuth myauth;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupactivity);
        getSupportActionBar().setTitle("Inscription");

        btn_signup = (Button)findViewById(R.id.btn_login);
        input_email = (EditText)findViewById(R.id.input_email);
        input_password = (EditText)findViewById(R.id.input_password);
        input_password_conf= (EditText)findViewById(R.id.input_password_conf);
        link_login = (TextView)findViewById(R.id.link_signup);
        progressBar2 = (ProgressBar)findViewById(R.id.progressBar2);
       myauth = FirebaseAuth.getInstance();


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String email = input_email.getText().toString().trim();
                  String password = input_password.getText().toString().trim();
                  String confirmPwd = input_password_conf.getText().toString().trim();


                  if (TextUtils.isEmpty(email)){
                      Toast.makeText(SignupActivity.this,"Entrer l'Email SVP !!",Toast.LENGTH_LONG).show();
                      return;
                  }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(SignupActivity.this,"Entrer le Password  SVP !!",Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(confirmPwd)){
                    Toast.makeText(SignupActivity.this,"Entrer la Confirmation du Password  SVP !!",Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length()<6){
                    Toast.makeText(SignupActivity.this,"Password  trop court  !!",Toast.LENGTH_LONG).show();

                }

                progressBar2.setVisibility(View.VISIBLE);

                if (password.equals(confirmPwd)){
                    myauth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    progressBar2.setVisibility(View.GONE);

                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), Administration.class));
                                        Toast.makeText(SignupActivity.this, "create account complete", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(SignupActivity.this, "Authentification failed", Toast.LENGTH_LONG).show();

                                    }

                                }

                            });
                }


            }
        });

    }



}


