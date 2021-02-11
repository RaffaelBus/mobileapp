package com.example.mobileapplicationraffael.data.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FachList implements Serializable {
    private Fach[] FachList;

    public LinkedList<Fach> getFachList() {
        return new LinkedList<>(Arrays.asList(FachList));
    }

    //Setzt fachlist in ein Array um.
    public void setFachList(List<Fach> fachList) {
        FachList = new Fach[fachList.size()];
        FachList = fachList.toArray(FachList);
    }
}
