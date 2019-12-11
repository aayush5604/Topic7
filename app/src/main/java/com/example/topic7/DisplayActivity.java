package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplayActivity extends AppCompatActivity {
    private ListView LstDictionary;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        LstDictionary = findViewById(R.id.lstdictinary);
        dictionary = new HashMap<>();
        // Read all the words from word.txt file
        readFromFile();
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        LstDictionary.setAdapter(adapter);
    }
    private void readFromFile(){
        try{
            FileInputStream fos = openFileInput("word.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine())!=null){
                String[] parts=line.split("->");
                dictionary.put(parts[0],parts[1]);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
