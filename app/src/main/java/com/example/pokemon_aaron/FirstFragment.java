package com.example.pokemon_aaron;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pokemon_aaron.databinding.FragmentFirstBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {
    private PokemonAdapter adapter;
    private FragmentFirstBinding binding;
    private PokemonViewModel model;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PokemonAdapter(getContext(),R.layout.rows_pokemon,new ArrayList<Pokemon>());

        binding.listaPokemon.setAdapter(adapter);

        binding.listaPokemon.setOnItemClickListener((adapterView, view1, i, l) -> {
            Pokemon pokemon = (Pokemon) adapterView.getItemAtPosition(i);

            Bundle datos = new Bundle();
            datos.putSerializable("pokemon", pokemon);

            if (!esTablet()){
                NavHostFragment.findNavController(
                this
                ).navigate(R.id.action_FirstFragment_to_SecondFragment, datos);
            } else {
                NavHostFragment.findNavController(
                        this
                ).navigate(R.id.action_SecondFragment_to_Self, datos);

            }

        });

        model = new ViewModelProvider(this).get(PokemonViewModel.class);

        model.getPokemons().observe(
                getViewLifecycleOwner(),pokemons -> {
                    adapter.clear();
                    adapter.addAll(pokemons);
                }
        );

        //quitar al poner el puto menu



    }

    private boolean esTablet() {
        return getResources().getBoolean(R.bool.delao);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.botonRefresh) {
            model.refresh();
            Toast.makeText(getContext(), "Actualizado", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        hideNavigation();

    }

    private void hideNavigation() {
        int uiOptions= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getActivity().getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }
}