package com.ejemplo.despensa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.ejemplo.despensa.db.Carrito;
import com.ejemplo.despensa.db.Despensa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CarroFragment extends Fragment  {


    TextView buscar;
    Button agregar, adAll;

    ArrayAdapter adaptador;
    ArrayList<String> items;
    List<Carrito> carritosObj = MainActivity.db.carritoDao().getAll();
    List<String> carritoNames = MainActivity.db.carritoDao().getAllByName();
    List<String> despensaNames = MainActivity.db.despensaDao().getAllByName();
    List<String> productosName = MainActivity.db.productosDao().getAllProdByName();

    Dialog dialog;



    public CarroFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_carro, container, false);
        buscar = vista.findViewById(R.id.buscar);
        agregar = vista.findViewById(R.id.agregar);
        adAll = vista.findViewById(R.id.adAll);

        ListView lv = vista.findViewById(R.id.lvCarro);
        adaptador = new ArrayAdapter(getActivity().getApplicationContext() , R.layout.list_item, carritoNames);
        lv.setAdapter(adaptador);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {

                Carrito car = new Carrito(buscar.getText().toString(), MainActivity.db.productosDao().getCategoryByProduct(buscar.getText().toString()));
                Long reg = MainActivity.db.carritoDao().insert(car);

                Toast.makeText(getActivity().getApplicationContext(),"Añadido al Carro",Toast.LENGTH_LONG).show();

                adaptador.add(car.getProducto());

            }
        });

        adAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                boolean Flag = false;
                Log.e("aaa","fuera");
                for(int i = 0; i < carritoNames.size(); i++){
                    Log.e("asd","fuera");
                    if (despensaNames.contains(carritoNames.get(i))){
                        Flag = true;
                        Log.e("asd", "dentro");
                    }
                    else {
                        Despensa des = new Despensa(carritoNames.get(i),MainActivity.db.productosDao().getCategoryByProduct(carritoNames.get(i)), "FECHA");
                        MainActivity.db.despensaDao().insert(des);
                    }
                }
                Toast.makeText(getActivity().getApplicationContext(),"Añadido a la Despensa",Toast.LENGTH_LONG).show();
                if(Flag){Toast.makeText(getActivity().getApplicationContext(),"Algunos elementos ya se encontraban en Despensa",Toast.LENGTH_LONG).show();}
                MainActivity.db.carritoDao().deleteAll();
                adaptador.clear();

            }
        });


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                dialog = new Dialog(vista.getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(650,800);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

              EditText editText = dialog.findViewById(R.id.etSearch);
              ListView listView = dialog.findViewById(R.id.LVSearch);
              ArrayAdapter<String> adap = new ArrayAdapter<>(vista.getContext(), android.R.layout.simple_list_item_1, productosName);
              listView.setAdapter(adap);

              editText.addTextChangedListener(new TextWatcher() {
                  @Override
                  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                  }

                  @Override
                  public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adap.getFilter().filter(s);
                  }

                  @Override
                  public void afterTextChanged(Editable s) {

                  }
              });

              listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    buscar.setText(adap.getItem(position));
                    dialog.dismiss();
                  }
              });

            }




        });
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
                                MainActivity.db.carritoDao().deleteCarritoPro(carritoNames.get(i));

                                carritoNames = MainActivity.db.carritoDao().getAllByName();
                                adaptador = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.list_item, carritoNames);
                                lv.setAdapter(adaptador);

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();


                return false;
            }
        });
        return vista;
    }





}