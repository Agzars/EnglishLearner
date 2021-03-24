package com.example.english;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class IrregularVerbScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irregular_verb_score);
        ArrayList<IrregularVerbQuestion> list = (ArrayList<IrregularVerbQuestion>) getIntent().getExtras().get("list");
        int totalScore = 0;
        for(IrregularVerbQuestion i : list)
        {
            totalScore += i.getScore();
        }
        TextView scoreDisplay = findViewById(R.id.textViewScore);
        scoreDisplay.setText(totalScore + " / 60");

        IrregularVerbScoreListAdapter adapter = new IrregularVerbScoreListAdapter(list,this);
        ListView listView = findViewById(R.id.listScore);
        listView.setAdapter(adapter);

    }

    public void displayCorrection(int pos, ArrayList<IrregularVerbQuestion> list)
    {

    }
}