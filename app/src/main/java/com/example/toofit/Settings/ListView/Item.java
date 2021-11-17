package com.example.toofit.Settings.ListView;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {return this.name;}
}
