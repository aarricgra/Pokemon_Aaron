package com.example.pokemon_aaron;

public class Pokemon {
    private String name;
    private String specie;
    private int height;
    private int weight;
    private String image;

    public Pokemon() {
    }

    public Pokemon(String name, String specie, int height, int weight,String image) {
        this.name = name;
        this.specie = specie;
        this.height = height;
        this.weight = weight;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImage() {return image;}

    public void setImage(String image) {this.image = image;}

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", specie='" + specie + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
