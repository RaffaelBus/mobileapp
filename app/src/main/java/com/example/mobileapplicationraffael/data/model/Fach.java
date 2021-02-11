package com.example.mobileapplicationraffael.data.model;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fach implements Serializable {
    //FachKlasse
    String name;
    ArrayList<Double> noten = new ArrayList<>();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getNoten() {
        return noten;
    }
    //Fügt eine Note hinzu in ein Fach
    public void addNote(double note){
        noten.add(note);

    }
    public void setNoten(ArrayList<Double> noten) {
        this.noten = noten;
    }

    public Fach(String name) {
        this.name = name;
    }


}
