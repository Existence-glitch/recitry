package com.ejemplo.despensa;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.room.Room;

import com.ejemplo.despensa.R;
import com.ejemplo.despensa.db.AppDataBase;
import com.ejemplo.despensa.db.Despensa;
import com.ejemplo.despensa.db.Productos;

import java.io.Console;
import java.util.List;

public class Pop extends Activity {

    EditText  etFecha  /*, etConsulta*/;
    Button btnGuardar /*, btnMostrar*/;
    Spinner etProducto, etCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        List<String> carritoNames = MainActivity.db.carritoDao().getAllByName();

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        List<String> cat = MainActivity.db.productosDao().getCategorias();



        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.spinner_item_test,cat);


        etProducto = (Spinner) findViewById(R.id.etProducto);
        etCategoria = (Spinner) findViewById(R.id.etCategoria);


        btnGuardar = findViewById(R.id.btnGuardar);

        etCategoria.setAdapter(adaptador);





        /*
        btnMostrar = findViewById(R.id.btnMostrar);
        etConsulta = findViewById(R.id.etConsulta); */






    etCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            List<String> prod = MainActivity.db.productosDao().getNameByCategoria(cat.get(position));
            ArrayAdapter<String> adaptador2 = new ArrayAdapter<>(getApplication().getApplicationContext(),R.layout.spinner_item_test,prod);
            etProducto.setAdapter(adaptador2);

            etProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent2, View view2, int position2, long id2) {
                    btnGuardar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(MainActivity.db.despensaDao().getAllByName().contains(prod.get(position2))){
                                Toast.makeText(getApplicationContext(),"Producto Ya se encuentra en Despensa",Toast.LENGTH_LONG).show();

                            } else{
                                Despensa des = new Despensa(prod.get(position2), cat.get(position) , "");
                                Long reg = MainActivity.db.despensaDao().insert(des);
                                Toast.makeText(getApplicationContext(),"Agregado Correctamente",Toast.LENGTH_LONG).show();

                            }










                        }



                    });





                }

                @Override
                public void onNothingSelected(AdapterView<?> parent2) {

                }
            });


        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    });





    }





}
