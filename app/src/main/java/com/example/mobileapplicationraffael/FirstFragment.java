package com.example.mobileapplicationraffael;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mobileapplicationraffael.data.model.Fach;
import com.example.mobileapplicationraffael.data.model.FachModel;
import com.example.mobileapplicationraffael.ui.login.LoginActivity;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        //Fächer werden genommen und in eine VISUELLE Liste eingeführt, auf die der User klicken kann.
        for (Fach fach : FachModel.getInstance().getFaecher()){
           LinearLayout Liste =  view.findViewById(R.id.FacherList);
            FachUIButton b = FachUIButton.newInstance(fach.getName());
            b.setOnClickListener(v -> {NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_fachEdit);
            FachModel.setCurrent(fach);
            //Setzt das aktuelle fach auf das gedrückte des Users und leitet auf die FachEdit seite weiter.
            }

                    );

            getChildFragmentManager().beginTransaction().add(Liste.getId(), b, "FachButton"+Liste.getChildCount()).commit();
        }

        view.findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Loggt den user raus aus der Applikation
                Intent loginIntent = new Intent(getContext(), LoginActivity.class);
                startActivity(loginIntent);
            }
        });


    }
}