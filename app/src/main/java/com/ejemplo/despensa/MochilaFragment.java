package com.ejemplo.despensa;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ejemplo.despensa.categorias.despensa;
import com.ejemplo.despensa.db.Despensa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class MochilaFragment extends Fragment {

    ImageButton vegetalesMostrar;
    ImageButton frutasMostrar;
    ImageButton pastasMostrar;
    ImageButton bebestiblesMostrar;
    ImageButton granosMostrar;
    ImageButton pastelesMostrar;
    ImageButton panesMostrar;
    ImageButton carnesMostrar;
    ImageButton ingredientesMostrar;
    ImageButton domesticosMostrar;
    ImageButton botiquinMostrar;





    FloatingActionButton fab;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mochila, container, false);


        vegetalesMostrar = view.findViewById(R.id.vegetalesMostrar);
        frutasMostrar = view.findViewById(R.id.frutasMostrar);
        pastasMostrar = view.findViewById(R.id.pastasMostrar);
        bebestiblesMostrar = view.findViewById(R.id.bebestiblesMostrar);
        granosMostrar = view.findViewById(R.id.granosMostrar);
        pastelesMostrar = view.findViewById(R.id.pastelesMostrar);
        panesMostrar = view.findViewById(R.id.panesMostrar);
        carnesMostrar = view.findViewById(R.id.carnesMostrar);
        ingredientesMostrar = view.findViewById(R.id.ingredientesMostrar);
        domesticosMostrar = view.findViewById(R.id.domesticosMostrar);
        botiquinMostrar = view.findViewById(R.id.botiquinMostrar);


        fab = view.findViewById(R.id.fab);


        vegetalesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Fragment secondFrag = new despensa("Vegetales");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);


            }



        });
        frutasMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Frutas");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);


            }



        });

        pastasMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Pastas");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        bebestiblesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Bebestibles");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);
            }



        });

        granosMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Granos");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        pastelesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Pasteles");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        panesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Panes");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        carnesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Carnes");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        ingredientesMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Ingredientes");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        domesticosMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Domésticos");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });

        botiquinMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new despensa("Botiquín");
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();

                vegetalesMostrar.setVisibility(View.GONE);
                frutasMostrar.setVisibility(View.GONE);
                pastasMostrar.setVisibility(View.GONE);
                bebestiblesMostrar.setVisibility(View.GONE);
                granosMostrar.setVisibility(View.GONE);
                pastelesMostrar.setVisibility(View.GONE);
                panesMostrar.setVisibility(View.GONE);
                carnesMostrar.setVisibility(View.GONE);
                ingredientesMostrar.setVisibility(View.GONE);
                domesticosMostrar.setVisibility(View.GONE);
                botiquinMostrar.setVisibility(View.GONE);

            }



        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MochilaFragment.this.getActivity(),Pop.class);
                startActivity(myIntent);


            }
        });




        return view;



    }
}