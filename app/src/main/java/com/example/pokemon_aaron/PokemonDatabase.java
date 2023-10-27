package com.example.pokemon_aaron;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class}, version = 1)
public abstract class PokemonDatabase extends RoomDatabase {
    private static PokemonDatabase INSTANCE;

    public static PokemonDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            PokemonDatabase.class,"db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract PokemonDao getPokemonDao();
}
