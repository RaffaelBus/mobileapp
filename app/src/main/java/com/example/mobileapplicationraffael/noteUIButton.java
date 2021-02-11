package com.example.mobileapplicationraffael;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link noteUIButton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class noteUIButton extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "FachNote";



    private View.OnClickListener listener;
    private double note;

    public noteUIButton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment noteUIButton.
     */

    public static noteUIButton newInstance(double param1) {
        noteUIButton fragment = new noteUIButton();
        Bundle args = new Bundle();
        args.putDouble(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getDouble(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_u_i_button, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Gebraucht für die Darstellung der Noten in einer Liste.
        super.onViewCreated(view, savedInstanceState);
        ((TextView)view.findViewById(R.id.noteZahlxd)).setText(Double.toString(note));
        view.findViewById(R.id.fachButtonUI).setOnClickListener(listener);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

    }

}