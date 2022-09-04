package com.ejemplo.despensa.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarritoDao {

    @Query("SELECt * FROM Carrito")
    List<Carrito> getAll();

    @Query("SELECt producto FROM Carrito")
    List<String> getAllByName();


    @Query("DELETE  FROM Carrito ")
    public void deleteAll();

    @Query("DELETE FROM Carrito WHERE producto LIKE :producto")
    public void deleteCarritoPro(String producto);

    @Delete
    public void delete(Carrito carrito);

    @Insert
    Long insert (Carrito carrito);
}

