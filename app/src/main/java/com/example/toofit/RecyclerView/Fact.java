package com.example.toofit.RecyclerView;

public class Fact {
    private String name;
    private String info;

    public Fact() {

    }

    public Fact(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }
}