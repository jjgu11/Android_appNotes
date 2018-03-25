package com.example.asusp.appNot.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asusp.appNot.Adapters.NotesAdapter;
import com.example.asusp.appNot.Pojos.Note;
import com.example.asusp.appNot.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AsusP on 11/03/2018.
 */

public class MainFragment extends Fragment {

    //creo elementos para la vista
    RecyclerView recyclerView;
    List<Note> noteList;
    NotesAdapter adapter;



    //permite crear la view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //regresa una vista
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_layout,container,false);

        return rootView;


    }

    // despues que se creo la view
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
       //super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //creo un linearLayout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);

        // paso al recycler
        recyclerView.setLayoutManager(linearLayoutManager);
        //inicializamos los datos (METODO)
        initializarNotas();

        //creamos el adapter y pasamos al Recycler
        adapter = new NotesAdapter(getActivity().getApplicationContext(),noteList);
        recyclerView.setAdapter(adapter);



    }

    //Elementos para la Lista
    public void initializarNotas(){

        noteList = new ArrayList<>();
        noteList.add(new Note(1,"Nota 1","Texto de la nota"));
        noteList.add(new Note(2,"Nota 2","Texto de la nota"));
        noteList.add(new Note(3,"Nota 3","Texto de la nota"));
        noteList.add(new Note(4,"Nota 4","Texto de la nota"));
        noteList.add(new Note(5,"Nota 5","Texto de la nota"));
        noteList.add(new Note(6,"Nota 6","Texto de la nota"));
        noteList.add(new Note(7,"Nota 7","Texto de la nota"));
        noteList.add(new Note(8,"Nota 8","Texto de la nota"));
        noteList.add(new Note(9,"Nota 9","Texto de la nota"));
        noteList.add(new Note(10,"Nota 10","Texto de la nota"));
        noteList.add(new Note(11,"Nota 11","Texto de la nota"));
        noteList.add(new Note(12,"Nota 12","Texto de la nota"));
        noteList.add(new Note(13,"Nota 13","Texto de la nota"));


    }


}
