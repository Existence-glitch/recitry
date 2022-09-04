package com.ejemplo.despensa.categorias;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import com.ejemplo.despensa.MainActivity;
import com.ejemplo.despensa.R;
import com.ejemplo.despensa.db.AppDataBase;
import com.ejemplo.despensa.db.Despensa;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


public class despensa extends Fragment {
    ListView lv;
    String tipo;
    ArrayAdapter adaptador;
    List<String> despensaName;


    public despensa() {
        // Required empty public constructor
    }
    public despensa(String tipo) {
        // Required empty public constructor
        this.tipo = tipo;
        Log.e("TAG", "Este es el tipo "+ tipo);


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "a");



        View vista = inflater.inflate(R.layout.fragment_despensa, container, false);
        despensaName = MainActivity.db.despensaDao().getNameByCategory(this.tipo);




        lv = vista.findViewById(R.id.lvDespensa);
        adaptador = new ArrayAdapter(getActivity().getApplicationContext() , R.layout.list_item, despensaName);
        lv.setAdapter(adaptador);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Log.e("TAG", "TOCO" + despensaName.get(i));

                new AlertDialog.Builder(getActivity())
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this item")
                        .setPositiveButton("Yes ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int u) {
                                MainActivity.db.despensaDao().deleteProducto(despensaName.get(i));
                                despensaName = MainActivity.db.despensaDao().getNameByCategory(tipo);
                                adaptador = new ArrayAdapter(getActivity(), R.layout.list_item, despensaName);
                                lv.setAdapter(adaptador);

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();




                return false;
            }
        });




        // Inflate the layout for this fragment
        return vista;
    }



}