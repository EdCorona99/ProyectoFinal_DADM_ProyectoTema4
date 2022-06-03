package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import edu.itch2.dadm_proyectotema4.db.DbContactos;

public class ActivityRegistro extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico;
    Button btnGuardarRegistro;
    Switch btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        btnGuardarRegistro = findViewById(R.id.btnGuardarRegistro);
        btnSwitch = findViewById(R.id.btnSwitch);

        btnGuardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = 0;
                DbContactos dbContactos = new DbContactos(ActivityRegistro.this);
                if (btnSwitch.isChecked()){
                    id = dbContactos.insertMaestro(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreoElectronico.getText().toString());
                } else {
                    id = dbContactos.insertAlumno(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtCorreoElectronico.getText().toString());
                }
                if (id > 0){
                    Toast.makeText(ActivityRegistro.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(ActivityRegistro.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
    }
}