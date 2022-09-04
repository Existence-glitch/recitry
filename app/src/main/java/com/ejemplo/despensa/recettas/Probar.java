package com.ejemplo.despensa.recettas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ejemplo.despensa.MainActivity;
import com.ejemplo.despensa.R;
import com.ejemplo.despensa.db.Recetas;

import java.util.Arrays;
import java.util.List;


public class Probar extends Fragment {


    String tipo;

    TextView titulo, pasos;

    ListView lv;
    ArrayAdapter adaptador;




    public Probar() {
        // Required empty public constructor
    }

    public Probar(String tipo) {
        this.tipo = tipo;
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_probar, container, false);
        Recetas res = MainActivity.db.recetasDao().getbyname(this.tipo);

        titulo = vista.findViewById(R.id.titulo);
        pasos = vista.findViewById(R.id.pasos);

        titulo.setText(res.getReceta());
        pasos.setText(res.getPasos());






       List<String> ing = Arrays.asList(res.getIngredientes().split(","));

        ListView lv = vista.findViewById(R.id.ingre);
        adaptador = new ArrayAdapter(getActivity().getApplicationContext() , R.layout.list_item, ing);
        lv.setAdapter(adaptador);







        return vista;


    }
}