package com.example.pokemon_aaron;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
