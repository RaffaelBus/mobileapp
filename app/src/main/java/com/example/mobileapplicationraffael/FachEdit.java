package com.example.mobileapplicationraffael;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.mobileapplicationraffael.MainActivity;
import com.example.mobileapplicationraffael.data.model.FachModel;

import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FachEdit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FachEdit extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View.OnClickListener listener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FachEdit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FachEdit.
     */
    // TODO: Rename and change types and number of parameters
    public static FachEdit newInstance(String param1, String param2) {
        FachEdit fragment = new FachEdit();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fach_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Basic Button mapping.
        super.onViewCreated(view, savedInstanceState);
        //Back Button
        view.findViewById(R.id.back).setOnClickListener(view1 -> NavHostFragment.findNavController(  FachEdit.this)
                .navigate(R.id.action_fachEdit_to_FirstFragment));
        view.findViewById(R.id.delFach).setOnClickListener(view1 ->
        {   FachModel.getInstance().delFach();
        //Löscht Fach
            NavHostFragment.findNavController(  FachEdit.this)
                .navigate(R.id.action_fachEdit_to_FirstFragment);
        });
        //Geht zur addNote Seite
        view.findViewById(R.id.addNote).setOnClickListener(view1 ->
                {NavHostFragment.findNavController(  FachEdit.this)
                .navigate(R.id.action_fachEdit_to_addNoteUI);}
                );
            //Einsetzen der Note in die VISUELLE Liste.
        for (Double note : FachModel.getCurrent().getNoten()){
            LinearLayout Liste =  view.findViewById(R.id.notenList);
            noteUIButton b = noteUIButton.newInstance(note);
            b.setOnClickListener(v -> {NavHostFragment.findNavController(FachEdit.this)
                            .navigate(R.id.action_fachEdit_to_noteEditieren);
                    }

            );

            getChildFragmentManager().beginTransaction().add(Liste.getId(), b, "NoteButton"+Liste.getChildCount()).commit();
        }

        view.findViewById(R.id.schnittCheckButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alle Noten werden genommen und zusammengerechnet. Ist der Schnitt unter 4, vibriert das Gerät.
                double Schnitt = 0;
                int divider = 0;
                if (FachModel.getCurrent().getNoten() != null) {
                    for (double note : FachModel.getCurrent().getNoten()) {
                        Schnitt = note + Schnitt;
                        divider++;
                    }
                    Schnitt = Schnitt / divider;
                    TextView hall = view.findViewById(R.id.noteSchnitt);
                    hall.setText(Double.toString(Schnitt));
                    if (Schnitt < 4) {
                        new Vibe().vibrate();
                    } else {

                    }
                } else {

                    
                }
            }
        });
    }
}