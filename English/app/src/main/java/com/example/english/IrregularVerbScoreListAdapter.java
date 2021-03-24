package com.example.english;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class IrregularVerbScoreListAdapter extends BaseAdapter {

    private ArrayList<IrregularVerbQuestion> list;
    private LayoutInflater mInflater;
    private IrregularVerbScore activity;

    public IrregularVerbScoreListAdapter(ArrayList<IrregularVerbQuestion> list, IrregularVerbScore act)
    {
        this.list = list;
        this.activity = act;
        this.mInflater = LayoutInflater.from(act);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.score_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView question = layoutItem.findViewById(R.id.textViewQuestion);
        TextView idQuestion = layoutItem.findViewById(R.id.textViewIdQuestion);
        TextView score = layoutItem.findViewById(R.id.textViewScore);

        //(3) : Renseignement des valeurs
        question.setText(list.get(position).getVerbe().getFrancais());
        idQuestion.setText(String.valueOf(position+1));
        score.setText(list.get(position).getScore() + " / 3");

        switch(list.get(position).getScore()){
            case 0:
                layoutItem.setBackgroundResource(R.color.red);
                break;
            case 1:
                layoutItem.setBackgroundResource(R.color.orange);
                break;
            case 2:
                layoutItem.setBackgroundResource(R.color.yellow);
                break;
            case 3:
                layoutItem.setBackgroundResource(R.color.green);
                break;
        }



        layoutItem.setOnClickListener(e -> {
            this.activity.displayCorrection(position, list);
        });
        //On retourne l'item créé.
        return layoutItem;
    }
}
