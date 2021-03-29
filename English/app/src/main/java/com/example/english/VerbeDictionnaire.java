package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VerbeDictionnaire extends AppCompatActivity {

    TextView verbe, inf, pret, part;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbe_dictionnaire);

        verbe=findViewById(R.id.verbe);
        inf = findViewById(R.id.inf);
        pret = findViewById(R.id.pret);
        part = findViewById(R.id.part);

        String verbeS = getIntent().getStringExtra("verbe");
        ListeVerbes listeVerbes = new ListeVerbes();

        listeVerbes.construireListe(this);

        Verbe v = listeVerbes.get(verbeS);
        if (v!=null){
            verbe.setText(v.getFrancais());
            inf.setText(v.getInfintif());
pret.setText(v.getPreterit());
part.setText(v.getParticipe());
        }
        else verbe.setText("Verbe non trouvé :(");
        img = findViewById(R.id.imageView);
        img.setBackgroundResource(R.drawable.livre);
        AnimationDrawable anim= (AnimationDrawable)img.getBackground();
        anim.start();

    }

}