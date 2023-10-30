package com.example.pokemon_aaron;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(Context context, int resource, List<Pokemon> object) {
        super(context, resource, object);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pokemon pokemon = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rows_pokemon, parent, false);
        }

        TextView name = convertView.findViewById(R.id.name);

        ImageView image = convertView.findViewById(R.id.image);

        name.setText(pokemon.getName());
        Picasso.get().load(pokemon.getImage()).into(image);

        return convertView;
    }
}
