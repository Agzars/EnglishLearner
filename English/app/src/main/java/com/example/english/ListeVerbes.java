package com.example.english;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListeVerbes {

    List<Verbe> list;

    public ListeVerbes() {
        list = new ArrayList<Verbe>();
    }

    public int size() {
        return list.size();
    }

    public Verbe get(int pos) {
        return list.get(pos);
    }

    public Verbe get(String verbe){
        for (Verbe v:list
             ) {
            if (v.getInfintif().equals(verbe)||v.getFrancais().equals(verbe)) return v;
        }
        return null;
    }
    public void construireListe(Context context) {


        // Création de la liste des recettes


        try {
            // Récupération du fichier json

            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            // Récupération des recettes
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(getVerbeFromJSONObject(jsonArray.getJSONObject(i), context));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private Verbe getVerbeFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {

        //nom recette
        String infinitif = jsonObject.getString("infinitif");


        // duree
        String preterit = jsonObject.getString("preterit");


        //recupération du nom de la photo
        String participe = (jsonObject.getString("participe"));


        //conversion du nom de la photo en une ressource int
        String francais = jsonObject.getString("francais");

        Verbe v = new Verbe(infinitif, preterit, participe, francais);


        return v;
    }


    //lecture du fichier en string
    private String getJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("verbes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }
}