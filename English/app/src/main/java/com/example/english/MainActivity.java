package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        ListeVerbes listeVerbes = new ListeVerbes();

        listeVerbes.construireListe(this);



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
        Intent intent = new Intent(MainActivity.this, VerbeControle.class);
        startActivity(intent);
    }

}