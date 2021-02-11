package com.example.mobileapplicationraffael;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mobileapplicationraffael.data.model.FachModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link noteEditieren#newInstance} factory method to
 * create an instance of this fragment.
 */
public class noteEditieren extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "editableNote";
    private static final String ARG_PARAM2 = "intDex";
    private View.OnClickListener listener;

    // TODO: Rename and change types of parameters
    private double mParam1;
    private int index;

    public noteEditieren() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment noteEditieren.
     */
    // TODO: Rename and change types and number of parameters
    public static noteEditieren newInstance(double param1, int index) {
        noteEditieren fragment = new noteEditieren();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM2, index);
        args.putDouble(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getDouble(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_editieren, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((EditText) view.findViewById(R.id.editTextTextPersonName)).setText(Double.toString(mParam1));
        view.findViewById(R.id.button5).setOnClickListener(view1 -> NavHostFragment.findNavController(noteEditieren.this)
                //Back Button
                .navigate(R.id.action_noteEditieren_to_fachEdit));
        view.findViewById(R.id.delNote).setOnClickListener(view1 -> {
            //Löscht Note.
            FachModel.getInstance().delNote(index);
            NavHostFragment.findNavController(  noteEditieren.this)
                .navigate(R.id.action_noteEditieren_to_fachEdit);

        });
        view.findViewById(R.id.noteEdited).setOnClickListener(view1 ->  {
            //Editiert eine bereits existierende Note und überschreibt deren Wert mit dem Neuen.
            EditText hall = (EditText) view.findViewById(R.id.editTextTextPersonName);
            double okay = 0;
            String halloa = hall.getText().toString();
            try {
                okay = Double.parseDouble(halloa);
            }
            catch (Exception e){
                EditText text = view.findViewById(R.id.editTextTextPersonName);
                text.setError("Bitte eine Zahl zwischen 1 und 6 eingeben");
                e.printStackTrace();
            }
            //Überprüft Eingabe des Users
            if (okay < 1 || okay > 6){
                EditText text = view.findViewById(R.id.editTextTextPersonName);
                text.setError("Bitte eine Zahl zwischen 1 und 6 eingeben");
                return;

            } else {

            }
            FachModel.getInstance().setNote(index, okay);
            NavHostFragment.findNavController(noteEditieren.this)
                .navigate(R.id.action_noteEditieren_to_fachEdit);

        });
    }
}