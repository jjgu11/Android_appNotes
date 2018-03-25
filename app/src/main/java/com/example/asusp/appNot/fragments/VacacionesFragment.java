package com.example.asusp.appNot.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asusp.appNot.R;

/**
 * Created by AsusP on 17/03/2018.
 */

public class VacacionesFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Creo y regreso una vista
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_vacaciones,container,false);
        //regreso la vista
        return rootView;
    }
}
