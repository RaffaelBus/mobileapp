package com.example.mobileapplicationraffael.persistence;

import android.content.Context;

import com.example.mobileapplicationraffael.data.model.Fach;
import com.example.mobileapplicationraffael.data.model.FachList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class fachPersistence {
    private static Context context = null;

    public static void setContext(Context context) {
        fachPersistence.context = context;
    }

    public static void write(List<Fach> Faecher){
        File dir = new File(context.getFilesDir(), "mydir");
        if(!dir.exists()){
            //Erstellt ein File, indem die Noten gespeichert werden damit man sie später wieder ansehen kann nach Schliessen der Applikation
            dir.mkdir();
        }
        try {
            //Speichert die Datei Faecher ab in der die Faecher und deren Noten enthalten sind.
            File gpxfile = new File(dir, "faecher");
            FileOutputStream writer = new FileOutputStream(gpxfile);
            ObjectOutputStream oos = new ObjectOutputStream(writer);

            FachList fachlist= new FachList();
            fachlist.setFachList(Faecher);


            oos.writeObject(fachlist);
            oos.close();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static LinkedList<Fach> read() {
        //Lesen der File
        File dir = new File(context.getFilesDir(), "mydir");
        if(!dir.exists()){
            return null;
        }

        try {
            File gpxfile = new File(dir, "faecher");
            FileInputStream reader = new FileInputStream(gpxfile);
            ObjectInputStream ois = new ObjectInputStream(reader);

            FachList fachlist = (FachList) ois.readObject();
            ois.close();
            reader.close();
            return fachlist.getFachList();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
