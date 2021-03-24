package com.example.english;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class IrregularVerbQuestionListAdapter extends BaseAdapter {

    private ArrayList<IrregularVerbQuestion> list;
    private LayoutInflater mInflater;
    private SummaryControlVerb activity;

    public IrregularVerbQuestionListAdapter(ArrayList<IrregularVerbQuestion> list, Context context, SummaryControlVerb act)
    {
        this.list = list;
        this.activity = act;
        this.mInflater = LayoutInflater.from(context);
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
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.question_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView question = layoutItem.findViewById(R.id.textViewQuestion);
        TextView idQuestion = layoutItem.findViewById(R.id.textViewIdQuestion);

        //(3) : Renseignement des valeurs
        question.setText(list.get(position).getVerbe().getFrancais());
        idQuestion.setText(String.valueOf(position+1));


        layoutItem.setOnClickListener(e -> {
            this.activity.startSaisiVerb(position, list);
        });
        //On retourne l'item créé.
        return layoutItem;
    }
}
