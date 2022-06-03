package edu.itch2.dadm_proyectotema4.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DBHelper {

    Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    /**
     * This function takes three parameters (nombre, telefono, correo_electronico) and inserts them
     * into the table "alumnos" in the database "db_alumnos"
     * 
     * @param nombre name of the student
     * @param telefono String
     * @param correo_electronico email
     * @return The id of the row that was inserted.
     */
    public long insertAlumno(String nombre, String telefono, String correo_electronico){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre_alumno", nombre);
        values.put("telefono_alumno", telefono);
        values.put("correo_electronico_alumno", correo_electronico);

        long id_alumnos = db.insert(TABLE_ALUMNOS, null, values);
        return id_alumnos;
    }

    /**
     * This function inserts a new row into the table "maestros" with the values of the parameters
     * passed to the function
     * 
     * @param nombre String
     * @param telefono String
     * @param correo_electronico email
     * @return The id of the row that was inserted.
     */
    public long insertMaestro(String nombre, String telefono, String correo_electronico){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre_maestro", nombre);
        values.put("telefono_maestro", telefono);
        values.put("correo_electronico_maestro", correo_electronico);

        long id_maestros = db.insert(TABLE_MAESTROS, null, values);
        return id_maestros;
    }
}
