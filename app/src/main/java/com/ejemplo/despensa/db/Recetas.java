package com.ejemplo.despensa.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recetas {
    @PrimaryKey
    @NonNull
    public String receta;
    @ColumnInfo(name = "ingredientes")
    public String ingredientes;
    @ColumnInfo(name = "pasos")
    public String pasos;
    @ColumnInfo(name = "tipo")
    public String tipo;


    public Recetas(String receta, String ingredientes, String pasos , String tipo) {
        this.receta = receta;
        this.ingredientes = ingredientes;
        this.pasos = pasos;
        this.tipo = tipo;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}