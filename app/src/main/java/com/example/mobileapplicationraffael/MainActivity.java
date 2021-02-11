package com.example.mobileapplicationraffael;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.mobileapplicationraffael.persistence.Benutzer;
import com.example.mobileapplicationraffael.persistence.Credentials;
import com.example.mobileapplicationraffael.persistence.fachPersistence;
import com.example.mobileapplicationraffael.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Vibrator;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.InputStream;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity {
/*
    Datum: 02.01.2021
    Version: 1.0
    Autor:Raffael Busslinger
    Letze Änderung: 03.01.2021
    Dateiname: MobileApplicationRaffael
    Funktion: Eintragen, speichern und bearbeiten von Schulnoten

           WICHTIG: MOMENTAN EXISTIERT NUR DER USER "test12" MIT PASSWORT "test12"
            */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fachPersistence.setContext(getApplicationContext());
        Benutzer.setContext(getApplicationContext());
        //WICHTIG: EINZIGE LOGINDATEN DIE FUNKTIONIEREN ATM. BENUTZEN FÜR LOGIN
        Benutzer.credWrite("test12", "test12");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Vibrationsfunktion für später erstellen und für die Vibe Klasse.
        new Vibe().setVib1((Vibrator) getSystemService(Context.VIBRATOR_SERVICE));
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}