package com.example.mobileapplicationraffael;

import android.content.Context;
import android.os.Vibrator;

import static androidx.core.content.ContextCompat.getSystemService;

public class Vibe {
    //Wird gebraucht um die VibrateFunktion des Geräts bei einem ungenügenden Schnitt zu verwenden.
    private static Vibrator vib1;

    public static Vibrator getVib1() {
        return vib1;
    }

    public void setVib1(Vibrator vib){
        this.vib1 = vib;
    }
    public void vibrate(){
        vib1.vibrate(500);
    }
}
