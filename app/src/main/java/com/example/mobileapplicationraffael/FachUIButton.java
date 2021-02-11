package com.example.mobileapplicationraffael;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobileapplicationraffael.data.model.FachModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FachUIButton#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FachUIButton extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "FachName";
    private View.OnClickListener listener;


    private String FachName;


    public FachUIButton() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FachUIButton.
     */
    public static FachUIButton newInstance(String param1) {
        FachUIButton fragment = new FachUIButton();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            FachName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fach_u_i_button, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Erstellt die Liste der Fächer, die dann in Android dargestellt werden.
        super.onViewCreated(view, savedInstanceState);
        ((TextView)view.findViewById(R.id.fachnamexd)).setText(FachName);
        view.findViewById(R.id.fachButtonUI).setOnClickListener(listener);
    }
public void setOnClickListener(View.OnClickListener listener){
this.listener = listener;

}

}