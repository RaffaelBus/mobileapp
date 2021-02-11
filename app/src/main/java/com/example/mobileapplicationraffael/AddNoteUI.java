package com.example.mobileapplicationraffael;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.mobileapplicationraffael.data.model.Fach;
import com.example.mobileapplicationraffael.data.model.FachModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddNoteUI#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNoteUI extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View.OnClickListener listener;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddNoteUI() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNoteUI.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNoteUI newInstance(String param1, String param2) {
        AddNoteUI fragment = new AddNoteUI();
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
        return inflater.inflate(R.layout.fragment_add_note_u_i, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.floatingActionButton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Text der Box umcasten und überprüft, ob sie einsatzbar ist. Wenn ja wird sie in die Liste eingesetzt
                EditText hall = (EditText) view.findViewById(R.id.noteHinzufuegen);
                String halloa = hall.getText().toString();
                double okay = 0;
                try {
                     okay = Double.parseDouble(halloa);
                } catch (Exception e){
                    EditText text = view.findViewById(R.id.noteHinzufuegen);
                    text.setError("Bitte eine Zahl zwischen 1 und 6 eingeben");
                    e.printStackTrace();
                }
            //Checkt, ob die Eingabe "legal" ist
                if (okay < 1 || okay > 6){
                    EditText text = view.findViewById(R.id.noteHinzufuegen);
                    text.setError("Bitte eine Zahl zwischen 1 und 6 eingeben");
                    return;

                } else {

                }
                FachModel.getInstance().addNote(okay);

                NavHostFragment.findNavController(AddNoteUI.this)
                        .navigate(R.id.action_addNoteUI_to_fachEdit);
            }

        });
        EditText text = view.findViewById(R.id.noteHinzufuegen);
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            //back Button
            public void onClick(View view) {
                NavHostFragment.findNavController(AddNoteUI.this)

                        .navigate(R.id.action_addNoteUI_to_fachEdit);
            }
        });

    }

}