package com.ejemplo.despensa.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Productos.class, Carrito.class, Despensa.class,Recetas.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ProductosDao productosDao();
    public abstract CarritoDao carritoDao();
    public abstract DespensaDao despensaDao();
    public abstract  RecetasDao recetasDao();

}
