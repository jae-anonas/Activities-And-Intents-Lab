package com.example.roosevelt.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_ARRAY = "words";

    Button btnSubmit;
    EditText txt_noun1;
    EditText txt_noun2;
    EditText txt_adj1;
    EditText txt_adj2;
    EditText txt_animals;
    EditText txt_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_noun1 = (EditText)findViewById(R.id.txt_noun1);
        txt_noun2 = (EditText)findViewById(R.id.txt_noun2);
        txt_adj1 = (EditText)findViewById(R.id.txt_adjective1);
        txt_adj2 = (EditText)findViewById(R.id.txt_adjective2);
        txt_animals = (EditText)findViewById(R.id.txt_animals);
        txt_game = (EditText)findViewById(R.id.txt_game);
        btnSubmit = (Button) findViewById(R.id.btn1);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] words = new String[6];

                Intent intent = new Intent(view.getContext(), Result.class);

                if(isComplete()){
                    words[0] = txt_adj1.getText().toString();
                    words[1] = txt_adj2.getText().toString();
                    words[2] = txt_noun1.getText().toString();
                    words[3] = txt_noun2.getText().toString();
                    words[4] = txt_animals.getText().toString();
                    words[5] = txt_game.getText().toString();
                    intent.putExtra(EXTRA_ARRAY, words);
                    startActivity(intent);
                }

//                intent.putExtra("myWords", words.t);
            }
        });
    }

    private boolean isComplete(){
        boolean valid = true;
        if (txt_adj1.getText().toString().trim().equals("")){
            txt_adj1.setError("Please fill out");
            valid = false;
        }
        if (txt_adj2.getText().toString().trim().equals("")){
            txt_adj2.setError("Please fill out");
            valid = false;
        }
        if (txt_noun1.getText().toString().trim().equals("")){
            txt_noun1.setError("Please fill out");
            valid = false;
        }
        if (txt_noun2.getText().toString().trim().equals("")){
            txt_noun2.setError("Please fill out");
            valid = false;
        }
        if (txt_animals.getText().toString().trim().equals("")){
            txt_animals.setError("Please fill out");
            valid = false;
        }
        if (txt_game.getText().toString().trim().equals("")){
            txt_game.setError("Please fill out");
            valid = false;
        }

        return valid;

    }


}
