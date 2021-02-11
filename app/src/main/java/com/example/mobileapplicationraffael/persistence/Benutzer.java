package com.example.mobileapplicationraffael.persistence;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Benutzer {
    private static Context context = null;

    public static void setContext(Context context) {
        Benutzer.context = context;
    }

    public static void credWrite(String username, String password){
        File dir = new File(context.getFilesDir(), "mydir");
        if(!dir.exists()){
            //Erstellt ein File, indem der User gespeichert wird damit man sich später wieder einloggen kann nach Schliessen der Applikation
            dir.mkdir();
        }
        try {
            File gpxfile = new File(dir, "credentials");
            FileOutputStream writer = new FileOutputStream(gpxfile);
            ObjectOutputStream oos = new ObjectOutputStream(writer);

            com.example.mobileapplicationraffael.persistence.Credentials c = new com.example.mobileapplicationraffael.persistence.Credentials();
            c.username = username;
            c.password = password;

            oos.writeObject(c);
            oos.close();
            writer.close();
        } catch(Exception e) {
e.printStackTrace();
        }
    }
    public static Credentials readCredentials() {
        //Lesen der Credentials
        File dir = new File(context.getFilesDir(), "mydir");
        if(!dir.exists()){
            return null;
        }

        try {
            File gpxfile = new File(dir, "credentials");
            FileInputStream reader = new FileInputStream(gpxfile);
            ObjectInputStream ois = new ObjectInputStream(reader);

            Credentials c = (Credentials)ois.readObject();
            ois.close();
            reader.close();
            return c;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
