package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static ListeVerbes listeVerbes = null;


    Button controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controle = findViewById(R.id.controle);

        if(listeVerbes == null)
        {
            listeVerbes = new ListeVerbes();
            listeVerbes.construireListe(this);
        }
    }

    public void controle (View v){
        ArrayList<Integer> alreadyPick = new ArrayList<>();
        ArrayList<IrregularVerbQuestion> pickedVerbs = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0 ; i < 20 ; i++)
        {
            Integer r = rand.nextInt(listeVerbes.size());
            while(alreadyPick.contains(r))
            {
                r = rand.nextInt(listeVerbes.size());
            }
            alreadyPick.add(r);
            pickedVerbs.add(new IrregularVerbQuestion(listeVerbes.get(r)));
        }
        Intent intent = new Intent(MainActivity.this, IrregularVerbDisplay.class);
        intent.putExtra("list", pickedVerbs);
        startActivity(intent);
    }
}