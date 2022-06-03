package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.itch2.dadm_proyectotema4.db.DBHelper;

public class ActivityDB extends AppCompatActivity {

    private Button btnCrearDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        btnCrearDB = findViewById(R.id.btnCrearDB);

        btnCrearDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating a new instance of the DBHelper class.
                DBHelper dbHelper = new DBHelper(ActivityDB.this);
                // Creating a new instance of the database.
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // Checking if the database was created successfully.
                if (db != null) {
                    Toast.makeText(ActivityDB.this, "BASES DE DATOS DE MAESTROS Y ALUMNOS CREADAS", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityDB.this, "ERROR AL CREAR LAS BASES DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * This function is called when the user clicks the menu button.
     * 
     * @param menu The menu object that you want to inflate.
     * @return True
     */
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_registro, menu);
        return true;
    }

    /**
     * When the user clicks on the menu item, call the nuevoRegistro() function.
     * 
     * @param item The menu item that was selected.
     * @return The superclass method is being returned.
     */
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_nuevo:
                nuevoRegistro();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * It creates a new activity.
     */
    private void nuevoRegistro(){
        Intent intent = new Intent(ActivityDB.this, ActivityRegistro.class);
        startActivity(intent);
    }
}