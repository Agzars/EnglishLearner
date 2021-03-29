package com.example.english;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IrregularVerbScore extends AppCompatActivity {
    public static int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irregular_verb_score);
        ArrayList<IrregularVerbQuestion> list = (ArrayList<IrregularVerbQuestion>) getIntent().getExtras().get("list");
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
        Intent intent = new Intent(IrregularVerbScore.this, IrregularVerbDisplay.class);
        intent.putExtra("list", list);
        intent.putExtra("id", pos);
        intent.putExtra("correction", true);
        startActivity(intent);
    }

    public void share(View v){
        Intent intent = new Intent(IrregularVerbScore.this, SendSMS.class);
        startActivity(intent);
    }

    public void exit(View v){
        Intent intent = new Intent(IrregularVerbScore.this, MainActivity.class);
        startActivity(intent);

    }
}