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
                .build();
            String url = builtUri.toString();
            return doCall(url);
    }

    private ArrayList<Pokemon> doCall(String url) {
        try {
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
                pokemon.setName(jsonPokemon.getString("name"));


                pokemons.add(pokemon);
            }
        } catch (JSONException e) {

        }
        return pokemons;
    }

}
