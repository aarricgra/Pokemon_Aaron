package com.example.pokemon_aaron;

public class Pokemon {
    private String name;
    private int id;
    private int height;
    private int weight;
    private String image;

    public Pokemon() {
    }

    public Pokemon(String name, int id, int height, int weight,String image) {
        this.name = name;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", id='" + id + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", image=" + image +
                '}';
    }
}
