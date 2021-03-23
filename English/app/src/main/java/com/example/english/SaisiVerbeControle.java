package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SaisiVerbeControle extends AppCompatActivity {

    private ArrayList<VerbeQuestion> listeQuestions;
    private int currentVerbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisi_verbe_controle);
        this.listeQuestions = (ArrayList<VerbeQuestion>) getIntent().getExtras().get("liste");
        this.currentVerbe = getIntent().getExtras().getInt("id");
        this.displayVerb(currentVerbe, 0);

        ImageButton buttonPrevious = findViewById(R.id.imageButtonPrevious);
        buttonPrevious.setOnClickListener(e -> {
            if(currentVerbe > 0)
            {
                currentVerbe--;
                displayVerb(currentVerbe, currentVerbe+1);
            }
        });
        ImageButton buttonNext = findViewById(R.id.imageButtonNext);
        buttonNext.setOnClickListener(e -> {
            if(currentVerbe < 19)
            {
                currentVerbe++;
                displayVerb(currentVerbe, currentVerbe-1);
            }
        });
    }

    public void displayVerb(int pos, int previous)
    {
        TextView verbeFrancais = findViewById(R.id.textViewVerbeFrancais);
        verbeFrancais.setText(listeQuestions.get(pos).getVerbe().francais);

        EditText saisiPreterit = findViewById(R.id.editTextSaisiPreterit);
        listeQuestions.get(previous).setPreteritAnswer(saisiPreterit.getText().toString());
        saisiPreterit.setText(listeQuestions.get(pos).getPreteritAnswer());

        EditText saisiInfinitif = findViewById(R.id.editTextSaisiInfinitif);
        listeQuestions.get(previous).setInfinitifAnswer(saisiInfinitif.getText().toString());
        saisiInfinitif.setText(listeQuestions.get(pos).getInfinitifAnswer());

        EditText saisiParticipe = findViewById(R.id.editTextSaisiParticipe);
        listeQuestions.get(previous).setParticipeAnswer(saisiParticipe.getText().toString());
        saisiParticipe.setText(listeQuestions.get(pos).getParticipeAnswer());

        TextView idVerbe = findViewById(R.id.textViewIdVerbe);
        idVerbe.setText(pos+1+"/20");
    }

}