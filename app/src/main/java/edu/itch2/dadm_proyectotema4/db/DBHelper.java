package edu.itch2.dadm_proyectotema4.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "escuela.db";
    public static final String TABLE_ALUMNOS = "t_alumnos";
    public static final String TABLE_MAESTROS = "t_maestros";

    // Creating a database.
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * The onCreate() method is called when the database is created for the first time
     * 
     * @param sqLiteDatabase The database.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ALUMNOS + "(" +
                "id_alumno INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_alumno TEXT NOT NULL," +
                "telefono_alumno TEXT NOT NULL," +
                "correo_electronico_alumno TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MAESTROS + "(" +
                "id_maestro INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_maestro TEXT NOT NULL," +
                "telefono_maestro TEXT NOT NULL," +
                "correo_electronico_maestro TEXT)");
    }

    /**
     * The onUpgrade() method is called when the database needs to be upgraded. This method executes
     * within a transaction. If an exception is thrown, all changes will automatically be rolled back
     * 
     * @param sqLiteDatabase The database.
     * @param i The old database version.
     * @param i1 The new version number for this database.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_ALUMNOS);
        onCreate(sqLiteDatabase);

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_MAESTROS);
        onCreate(sqLiteDatabase);
    }
}
