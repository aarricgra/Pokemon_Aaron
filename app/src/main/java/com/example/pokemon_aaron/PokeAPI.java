package com.example.pokemon_aaron;

import android.net.Uri;

import java.io.IOException;

public class PokeAPI {
    private final String BASE_URL = "https://pokeapi.co/api/v2/";

    String getPokemonsName() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("name")
                .appendQueryParameter("limit", "10")
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private String doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
