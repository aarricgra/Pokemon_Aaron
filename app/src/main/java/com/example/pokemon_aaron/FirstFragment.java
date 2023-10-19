package com.example.pokemon_aaron;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon_aaron.databinding.FragmentFirstBinding;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {
    private PokemonAdapter adapter;
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

        adapter = new PokemonAdapter(getContext(),R.layout.rows_pokemon,new ArrayList<Pokemon>());

        refresh();

        binding.listaPokemon.setAdapter(adapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            PokeAPI api = new PokeAPI();
            ArrayList<Pokemon> lista = api.getPokemons();

            handler.post(() -> {
                // Aquest codi s'executa en primer pla.
                adapter.clear();
                for (Pokemon pokemon : lista) {
                    adapter.add(pokemon);
                }
            });

        });
    }

}