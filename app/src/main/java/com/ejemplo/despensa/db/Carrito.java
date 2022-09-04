package com.ejemplo.despensa.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Carrito {
    @PrimaryKey
    @NonNull
    public String producto;
    @ColumnInfo(name = "categoria")
    public String categoria;

    public Carrito(String producto, String categoria) {
        this.producto = producto;
        this.categoria = categoria;

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
}

