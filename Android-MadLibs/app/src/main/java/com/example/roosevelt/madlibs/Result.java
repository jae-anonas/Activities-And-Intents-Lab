package com.example.roosevelt.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    Button btnBack;
    TextView txt_madlibs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnBack = (Button) findViewById(R.id.btn_back);
        txt_madlibs = (TextView) findViewById(R.id.txt_madlibs);

        Intent intent = getIntent();

        String[] words = intent.getStringArrayExtra("words");

        String madlib = String.format("A vacation is when you take a trip to some %s place with your %s family. Usually, you go to some place that is near a %s or up on a %s. A good vacation place is one where you can ride %s or play %s.", words[0], words[1], words[2], words[3], words[4], words[5]);

        txt_madlibs.setText(madlib);
//        Toast.makeText(getApplicationContext(), madlib,Toast.LENGTH_SHORT).show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goBack = new Intent(view.getContext(), MainActivity.class);
                startActivity(goBack);
            }
        });
    }

}
