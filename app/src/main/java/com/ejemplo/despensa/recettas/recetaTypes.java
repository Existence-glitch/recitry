package com.ejemplo.despensa.recettas;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ejemplo.despensa.MainActivity;
import com.ejemplo.despensa.R;
import com.ejemplo.despensa.categorias.despensa;
import com.ejemplo.despensa.db.Recetas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class recetaTypes extends Fragment {

    String tipo;
    List<String> recetasNames;
    List<Recetas> recetasObj;
    ListView lv;
    ArrayAdapter adaptador;

    List finalList = new ArrayList();

    List<String> despensa = MainActivity.db.despensaDao().getAllByName();

    List<String> ing;



    public recetaTypes() {
        // Required empty public constructor
    }

    public recetaTypes(String tipo) {
        Log.e("TAG", "Este es el tipo" + tipo);
        this.tipo = tipo;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_despensa, container, false);
        recetasNames = MainActivity.db.recetasDao().getByCategory(this.tipo);
        recetasObj = MainActivity.db.recetasDao().getRecetaByReCategory(this.tipo);

        Log.e("TAG", "Este es el tipo" + String.valueOf( MainActivity.db.recetasDao().getNumero(tipo)));









        for (int i = 0; i < recetasObj.size(); i++) {

            ing = Arrays.asList(recetasObj.get(i).ingredientes.split(","));


            int cont = 0;

            for (int j = 0; j < ing.size(); j++) {



                for (int k = 0; k < despensa.size() ; k++){
                   Log.e("TAG", "aaa " + ing.get(j).length() +  " " + ing.get(j) + " " + despensa.get(k).replaceAll("\\s+","").length() + " " + despensa.get(k).replaceAll("\\s+","") + " " +ing.get(j).equals(despensa.get(k).replaceAll("\\s+","") ));


                    if (ing.get(j).replaceAll("\\s+","").equals(despensa.get(k).replaceAll("\\s+","")) ) {
                        cont = cont + 1;

                        break;
                    }



                }




            }

            Log.e("TAG", "asdasd "+ String.valueOf(cont));
            if (cont == ing.size()) {
                finalList.add(recetasObj.get(i).receta);
            }


        }


        lv = vista.findViewById(R.id.lvDespensa);
        adaptador = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.list_item, finalList);
        lv.setAdapter(adaptador);




        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.e("TAG", "asdasd "+ finalList.get(i));


                Fragment secondFrag = new Probar(finalList.get(i).toString());
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragment_l,secondFrag).commit();




                return false;
            }
        });









        return vista;
    }


}
