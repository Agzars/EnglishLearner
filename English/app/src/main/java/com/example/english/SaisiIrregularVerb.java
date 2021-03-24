package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SaisiIrregularVerb extends AppCompatActivity {

    private ArrayList<IrregularVerbQuestion> listQuestions;
    private int currentVerb;
    private boolean isCorrection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisi_irregular_verb);
        this.listQuestions = (ArrayList<IrregularVerbQuestion>) getIntent().getExtras().get("list");
        this.currentVerb = getIntent().getExtras().getInt("id", 0);
        this.isCorrection = getIntent().getExtras().getBoolean("correction", false);
        this.displayVerb(currentVerb);

        ImageButton buttonPrevious = findViewById(R.id.imageButtonPrevious);
        buttonPrevious.setOnClickListener(e -> {
            if(currentVerb > 0)
            {
                saveSaisi();
                currentVerb--;
                displayVerb(currentVerb);
            }
        });
        ImageButton buttonNext = findViewById(R.id.imageButtonNext);
        buttonNext.setOnClickListener(e -> {
            if(currentVerb < 19)
            {
                saveSaisi();
                currentVerb++;
                displayVerb(currentVerb);
            }
        });

        Button finish = findViewById(R.id.buttonFinish);
        finish.setOnClickListener(e -> {
            saveSaisi();
            Intent intent = new Intent(SaisiIrregularVerb.this, SummaryControlVerb.class);
            intent.putExtra("list", this.listQuestions);
            startActivity(intent);
        });
    }

    public void displayVerb(int pos)
    {
        TextView verbeFrancais = findViewById(R.id.textViewVerbeFrancais);
        verbeFrancais.setText(listQuestions.get(pos).getVerbe().francais);

        EditText saisiPreterit = findViewById(R.id.editTextSaisiPreterit);
        saisiPreterit.setText(listQuestions.get(pos).getPreteritAnswer());

        EditText saisiInfinitif = findViewById(R.id.editTextSaisiInfinitif);
        saisiInfinitif.setText(listQuestions.get(pos).getInfinitifAnswer());

        EditText saisiParticipe = findViewById(R.id.editTextSaisiParticipe);
        saisiParticipe.setText(listQuestions.get(pos).getParticipeAnswer());

        TextView idVerbe = findViewById(R.id.textViewIdVerbe);
        idVerbe.setText(pos+1+"/20");

        if(isCorrection)
        {
            TextView correctionPreterit = findViewById(R.id.textViewCorrectionPreterit);
            correctionPreterit.setText(listQuestions.get(pos).getVerbe().getPreterit());
            TextView correctionInfinitif = findViewById(R.id.textViewCorrectionInfinitif);
            correctionInfinitif.setText(listQuestions.get(pos).getVerbe().getInfintif());
            TextView correctionParticipe = findViewById(R.id.textViewCorrectionParticipe);
            correctionParticipe.setText(listQuestions.get(pos).getVerbe().getParticipe());
        }
    }

    public void saveSaisi()
    {
        EditText saisiPreterit = findViewById(R.id.editTextSaisiPreterit);
        listQuestions.get(currentVerb).setPreteritAnswer(saisiPreterit.getText().toString());
        EditText saisiInfinitif = findViewById(R.id.editTextSaisiInfinitif);
        listQuestions.get(currentVerb).setInfinitifAnswer(saisiInfinitif.getText().toString());
        EditText saisiParticipe = findViewById(R.id.editTextSaisiParticipe);
        listQuestions.get(currentVerb).setParticipeAnswer(saisiParticipe.getText().toString());
    }

}