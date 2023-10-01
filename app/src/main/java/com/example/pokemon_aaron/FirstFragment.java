package com.example.pokemon_aaron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon_aaron.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ArrayList<String> pokemons = new ArrayList<>();
        pokemons.add("Pikachu");
        pokemons.add("Charmander");
        pokemons.add("Chimpchar");
        pokemons.add("Piplup");
        pokemons.add("Bidoof");

        ArrayAdapter adapter = new ArrayAdapter<>(
                getContext(), // Context de l'Activity
                R.layout.rows_pokemon, // Layout per a cadascun dels ítems del ListView
                R.id.textNombre, // ID del TextView que contindrà el títol de la pel·lícula
                pokemons
        );

        binding.listaPokemon.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}