package com.example.mobileapplicationraffael.data.model;

import com.example.mobileapplicationraffael.persistence.fachPersistence;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FachModel {
    //Model für Fächer, Listen und Noten.
    private static int current;

    public static Fach getCurrent() {
        return Faecher.get(current);
    }

    public static void setCurrent(Fach current) {
        FachModel.current = Faecher.indexOf(current);
    }


    private static LinkedList<Fach> Faecher = new LinkedList<>();

    public static FachModel getInstance() {
        return new FachModel();

    }

    private FachModel() {

        Faecher = fachPersistence.read();
        if (Faecher == null) {
            //Erstellt eine neue LinkedList wenn Faecher null ist.
            Faecher = new LinkedList<>();
        }
    }
//Fügt Fach hinzu
    public void addFach(String fachName) {
        Faecher.add(new Fach(fachName));
        changes.firePropertyChange("adden", null, Faecher);
        fachPersistence.write(getFaecher());
    }
//Löscht das Fach
    public void delFach() {
        Faecher.remove(current);
        fachPersistence.write(getFaecher());
    }
    //Fügt Note hinzu
    public void addNote(double note) {
        Faecher.get(current).addNote(note);
        changes.firePropertyChange("Notadden", null, Faecher.get(current).getNoten());
        fachPersistence.write(getFaecher());
    }

    public List<Fach> getFaecher() {
        return Faecher;
    }
//Löscht Note
    public void delNote(int index) {
        try {
            Faecher.get(current).getNoten().remove(index);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void setNote (int index, double note){
        Faecher.get(current).getNoten().set(index, note);

    }

    private static PropertyChangeSupport changes = new PropertyChangeSupport(getInstance());
}
