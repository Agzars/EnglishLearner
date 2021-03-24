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

    SearchView sv;
    Button controle;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv = findViewById(R.id.search);
        controle = findViewById(R.id.controle);
        lv=findViewById(R.id.lv);

        if(listeVerbes == null)
        {
            listeVerbes = new ListeVerbes();
            listeVerbes.construireListe(this);
        }



        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, VerbeDictionnaire.class);
                intent.putExtra("verbe", query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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
        Intent intent = new Intent(MainActivity.this, SaisiIrregularVerb.class);
        intent.putExtra("list", pickedVerbs);
        startActivity(intent);
    }
}