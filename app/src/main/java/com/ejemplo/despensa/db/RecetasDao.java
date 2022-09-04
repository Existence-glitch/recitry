package com.ejemplo.despensa.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface RecetasDao {
    @Query("SELECt * FROM Recetas")
    List<Recetas> getAll();

    @Query("SELECT ingredientes FROM Recetas WHERE receta LIKE :receta")
    String getIngredientes(String receta);

    @Query("SELECT receta FROM RECETAS WHERE tipo LIKE :tipo")
    List<String> getByCategory(String tipo);

    @Query("SELECT * FROM RECETAS WHERE tipo LIKE :tipo")
    List<Recetas> getRecetaByReCategory(String tipo);

    @Query("SELECT COUNT(*) FROM RECETAS WHERE tipo LIKE :tipo")
    int getNumero(String tipo);

    @Query("SELECT COUNT(*)  FROM Recetas")
    int getCount();

    @Query("SELECt * FROM Recetas WHERE receta LIKE :receta")
    Recetas getbyname(String receta);

    @Query("DELETE FROM Recetas")
    public void deleteAll();

    @Insert
    Long insert (Recetas receta);



}

