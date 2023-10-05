package com.example.pokemon_aaron;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

public class PokeAPI {
    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    String getPokemonsName() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("pokemon")
                .build();
        String url = builtUri.toString();
        Log.d(null,url);
        return doCall(url);
    }

    private String doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            Log.d(null,JsonResponse);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
