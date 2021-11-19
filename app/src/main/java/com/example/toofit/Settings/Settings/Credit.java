package com.example.toofit.Settings.Settings;

public class Credit {
    private String creditFor;
    private String to;

    public Credit(String creditFor, String to) {
        this.creditFor = creditFor;
        this.to = to;
    }

    public String getCreditFor() {return creditFor;}
    public void setCreditFor(String name) {this.creditFor = creditFor;}

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }

    @Override
    public String toString() {return this.creditFor;}
}