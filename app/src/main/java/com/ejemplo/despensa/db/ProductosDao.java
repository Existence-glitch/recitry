package com.ejemplo.despensa.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductosDao {

    @Query("SELECt * FROM Productos")
    List<Productos> getAll();

    @Query("SELECT * FROM Productos WHERE producto LIKE :producto LIMIT 1")
    Productos getByName(String producto);

    @Query("SELECT categoria FROM Productos")
    List<String> getAllByName();

    @Query("SELECT producto FROM Productos")
    List<String> getAllProdByName();

    @Query("SELECT * FROM Productos WHERE categoria LIKE :categoria")
    Productos getByCategory(String categoria);

    @Query("SELECT producto FROM Productos WHERE categoria LIKE :categoria")
    List<String> getNameByCategoria(String categoria);


    @Query("SELECT categoria from Productos WHERE producto LIKE :producto")
    String getCategoryByProduct(String producto);

    @Query("DELETE FROM Productos")
    public void deleteAll();

    @Query("SELECT DISTINCT categoria from Productos")
    List<String> getCategorias();

    @Query("SELECT COUNT(*)  FROM Productos")
    int getCount();

    @Insert
    Long insert (Productos producto);



}
