package com.example.pokemon_aaron;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(Context context, int resource, List<Pokemon> object) {
        super(context, resource, object);
    }
}
