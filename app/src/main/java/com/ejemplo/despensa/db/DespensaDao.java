
package com.ejemplo.despensa.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.DeleteTable;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DespensaDao {
    @Query("SELECt * FROM Despensa")
    List<Despensa> getAll();

    @Query("SELECt producto FROM Despensa")
    List<String> getAllByName();

    @Query("SELECT producto FROM Despensa WHERE categoria LIKE :categoria")
    List<String> getNameByCategory(String categoria);

    @Query("DELETE FROM Despensa")
    public void deleteAll();

    @Query("DELETE FROM Despensa WHERE producto LIKE :producto")
    public void deleteProducto(String producto);

    @Delete
    public void delete(Despensa despensa);

    @Insert
    Long insert (Despensa despensa);
}

