package com.example.pokemon_aaron;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PokemonViewModel extends AndroidViewModel {
    private final Application app;
    private final PokemonDatabase pokemonDatabase;
    private final PokemonDao pokemonDao;
    private LiveData<List<Pokemon>> pokemons;

    public PokemonViewModel(Application application) {
        super(application);

        this.app = application;
        this.pokemonDatabase = PokemonDatabase.getDatabase(
                this.getApplication());
        this.pokemonDao = pokemonDatabase.getPokemonDao();
    }

    public LiveData<List<Pokemon>> getPokemons() {
        return pokemonDao.getPokemons();
    }

    void refresh() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            PokeAPI api = new PokeAPI();
            ArrayList<Pokemon> pokemonsApi = api.getPokemons();

            this.pokemonDao.deletePokemons();
            this.pokemonDao.addPokemons(pokemonsApi);
        });
    }
}
