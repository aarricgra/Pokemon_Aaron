package com.example.pokemon_aaron;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PokeAPI {
    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    // Método para obtener el nombre de los Pokémon en un hilo separado
    ArrayList<Pokemon> getPokemons() {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("pokemon")
                .appendQueryParameter("limit", "10")
                .build();
            String url = builtUri.toString();
            return doCall(url);
    }

    private ArrayList<Pokemon> doCall(String url) {
        try {
            Log.d("aaa",url);
            return processJson(HttpUtils.get(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Pokemon> processJson(String json) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        try {
            JSONObject datos = new JSONObject(json);
            JSONArray jsonPokemons = datos.getJSONArray("results");
            for(int i=0;i<jsonPokemons.length();i++){
                JSONObject jsonPokemon = jsonPokemons.getJSONObject(i);

                Pokemon pokemon = new Pokemon();
                String name1 = jsonPokemon.getString("name");
                String name2= name1.toUpperCase().charAt(0)+name1.substring(1,name1.length());
                pokemon.setName(name2);

                String info = HttpUtils.get(jsonPokemon.getString("url"));
                JSONObject infoextra = new JSONObject(info);
                pokemon.setHeight(infoextra.getInt("height"));
                pokemon.setWeight(infoextra.getInt("weight"));

                pokemon.setImage(infoextra.getJSONObject("sprites").getString("front_default"));

                pokemons.add(pokemon);
            }
        } catch (Exception e) {

        }
        return pokemons;
    }

}
