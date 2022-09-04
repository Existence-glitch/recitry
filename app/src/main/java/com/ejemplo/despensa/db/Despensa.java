package com.ejemplo.despensa.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Despensa {
    @PrimaryKey
    @NonNull
    public String producto;
    @ColumnInfo(name = "categoria")
    public  String categoria;
    @ColumnInfo(name = "fecha")
    public String fecha;

    public Despensa(String producto, String categoria, String fecha) {
        this.producto = producto;
        this.categoria = categoria;
        this.fecha = fecha;

    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

