package com.ejemplo.despensa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ejemplo.despensa.databinding.ActivityMainBinding;
import com.ejemplo.despensa.db.AppDataBase;
import com.ejemplo.despensa.db.Despensa;
import com.ejemplo.despensa.db.Productos;
import com.ejemplo.despensa.db.Recetas;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static AppDataBase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(this, AppDataBase.class, "dbase").allowMainThreadQueries().build();

        db.despensaDao().deleteAll();
        db.productosDao().deleteAll();
        db.recetasDao().deleteAll();

        replaceFragment(new MochilaFragment());
        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        InicializarProductos();
        InicializarRecetas();




    }


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.carro:
                    replaceFragment(new CarroFragment());

                    break;
                case R.id.mochila:
                    replaceFragment(new MochilaFragment());
                    break;
                case R.id.receta:
                    replaceFragment(new RecetasFragment());
                    break;


            }
            return true;
        }
    };








    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_l,fragment);
        fragmentTransaction.commit();

    }


    private void InicializarProductos(){
        if (db.productosDao().getCount() == 0){
            String[] texto = readFileProductos();
            for (int i = 0; i < texto.length; i++){
                String[] linea = texto[i].split("\\;");
                Productos pro = new Productos(linea[1], linea[0]);
                db.productosDao().insert(pro);
            }

        }

    }

    private void InicializarRecetas(){
        if (db.recetasDao().getCount() == 0){
            String[] texto = readFileRecetas();
            for (int i = 0; i < texto.length; i++){
                String[] linea = texto[i].split(";");
                Log.e("asdsa", linea[0]+ " "+ linea[1] + " " + linea[2] + " " + linea[3]);
                Recetas rec = new Recetas(linea[0], linea[2], linea[3], linea[1]);
                db.recetasDao().insert(rec);
            }

        }

    }




    private String[] readFileProductos(){
        InputStream inputStream = getResources().openRawResource(R.raw.productos);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            int i = inputStream.read();
            while(i != -1){
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString().split("\n");
    }

    private String[] readFileRecetas(){
        InputStream inputStream = getResources().openRawResource(R.raw.recetas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            int i = inputStream.read();
            while(i != -1){
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString().split("\n");
    }









}