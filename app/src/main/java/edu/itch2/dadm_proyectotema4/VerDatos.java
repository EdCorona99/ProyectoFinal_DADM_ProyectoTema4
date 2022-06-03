package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VerDatos extends AppCompatActivity {

    TextView txtNombre, txtFecha;
    ImageView tema;
    Button btnRegresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        txtNombre = findViewById(R.id.textViewNombreVD);
        txtFecha = findViewById(R.id.textViewFechaVD);
        tema = findViewById(R.id.imageViewVD);
        btnRegresa = findViewById(R.id.btnRegresar);

        SharedPreferences pref = getSharedPreferences("preferencias1", Context.MODE_PRIVATE);
        // Getting the data from the shared preferences and setting it to the textviews.
        txtNombre.setText("Nombre: " + pref.getString("nombre",""));
        txtFecha.setText("Fecha: " + pref.getString("fecha",""));
        String figura = "";
        figura = pref.getString("tema", "");

        // Setting the image to the imageview depending on the value of the string figura.
        if (figura.equals("planta")) {
            tema.setImageResource(R.drawable.planta);
        }
        if (figura.equals("animal")) {
            tema.setImageResource(R.drawable.animal);
        }
        if (figura.equals("figura")) {
            tema.setImageResource(R.drawable.figura);
        }

        btnRegresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }
}