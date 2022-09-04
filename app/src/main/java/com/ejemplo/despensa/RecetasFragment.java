package com.ejemplo.despensa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ejemplo.despensa.recettas.recetaTypes;


public class RecetasFragment extends Fragment {

    ImageButton desayunosMostrar;
    ImageButton almuerzoMostrar;
    ImageButton onceMostrar;
    ImageButton cenaMostrar;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_recetas, container, false);

        desayunosMostrar = view.findViewById(R.id.desayunosMostrar);
        almuerzoMostrar = view.findViewById(R.id.almuerzosMostrar);
        onceMostrar = view.findViewById(R.id.onceMostrar);
        cenaMostrar = view.findViewById(R.id.cenaMostrar);

        Log.e("TAG", "onCreateView: " );

        desayunosMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new recetaTypes("Desayuno");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l ,secondFrag).commit();

                desayunosMostrar.setVisibility(View.GONE);
                almuerzoMostrar.setVisibility(View.GONE);
                onceMostrar.setVisibility(View.GONE);
                cenaMostrar.setVisibility(View.GONE);

            }



        });
        almuerzoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new recetaTypes("Almuerzo");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                desayunosMostrar.setVisibility(View.GONE);
                almuerzoMostrar.setVisibility(View.GONE);
                onceMostrar.setVisibility(View.GONE);
                cenaMostrar.setVisibility(View.GONE);

            }



        });

        cenaMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new recetaTypes("Cena");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                desayunosMostrar.setVisibility(View.GONE);
                almuerzoMostrar.setVisibility(View.GONE);
                onceMostrar.setVisibility(View.GONE);
                cenaMostrar.setVisibility(View.GONE);

            }



        });

       onceMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new recetaTypes("Once");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                desayunosMostrar.setVisibility(View.GONE);
                almuerzoMostrar.setVisibility(View.GONE);
                onceMostrar.setVisibility(View.GONE);
                cenaMostrar.setVisibility(View.GONE);

            }



        });





        return view;



    }
}