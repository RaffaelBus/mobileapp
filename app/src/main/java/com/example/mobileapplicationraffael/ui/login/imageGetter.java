package com.example.mobileapplicationraffael.ui.login;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class imageGetter {
    // Mithilfe einer Flask API wird ein zufälliges Bild vom Subreddit "r/redpandas" genommen und auf der LoginSeite dargestellt. Diese Methode holt die URL für das Bild
    public String getImageURL(){
        try {
            URL url = new URL("http://192.168.1.234:5000/");
            HttpURLConnection connector = (HttpURLConnection) url.openConnection();
            connector.setRequestMethod("GET");
            if (connector.getResponseCode() != 200){
                return null;
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader((connector.getInputStream())));
                StringBuilder sb = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    sb.append(output);
                }
                return sb.toString();

            }
        }
        catch (IOException e){

            e.printStackTrace();
        }
        return null;
    }
}
