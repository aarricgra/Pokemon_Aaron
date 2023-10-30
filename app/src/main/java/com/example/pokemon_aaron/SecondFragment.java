package com.example.pokemon_aaron;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pokemon_aaron.databinding.FragmentFirstBinding;
import com.example.pokemon_aaron.databinding.FragmentSecondBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    private PokemonAdapter adapter;
    private FragmentSecondBinding binding;
    private PokemonViewModel model;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            Pokemon pokemon = (Pokemon)args.getSerializable("pokemon");

            if (pokemon != null) {
                updateUi(pokemon);
            }
        }
    }

    private void updateUi(Pokemon pokemon) {

            binding.INombre.setText(pokemon.getName());
            Picasso.get().load(pokemon.getImage()).into(binding.IFoto);
            binding.IPeso.setText(""+pokemon.getWeight());
            binding.IAltura.setText(""+pokemon.getHeight());




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}