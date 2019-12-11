package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {
    EditText etWord, etDefination;
    Button btnAddword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        etWord = findViewById(R.id.etWord);
        etDefination = findViewById(R.id.etMeaining);
        btnAddword = findViewById(R.id.btnAddWord);

        btnAddword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save(){
        try{
            PrintStream printStream=new PrintStream(openFileOutput("word.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println((etWord.getText().toString()+ "->" + etDefination.getText().toString()));
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();

        } catch (IOException e){
            Log.d("Dictionary app","Error:"+ e.toString());
            e.printStackTrace();
        }
}}
