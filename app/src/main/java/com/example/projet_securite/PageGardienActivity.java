package com.example.projet_securite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PageGardienActivity extends AppCompatActivity {

    TextView textViewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__gardien);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        textViewId = this.findViewById(R.id.textView_id_gardien);
        textViewId.setText(id);
    }
}
