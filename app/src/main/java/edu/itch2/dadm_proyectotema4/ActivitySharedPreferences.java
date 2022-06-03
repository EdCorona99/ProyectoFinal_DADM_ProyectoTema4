package edu.itch2.dadm_proyectotema4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySharedPreferences extends AppCompatActivity {

    TextView txtNombre;
    EditText editTextNombre;
    RadioButton radioButtonPlanta, radioButtonAnimal, radioButtonFigura;
    RadioGroup radioGroup;
    CalendarView calendario;
    String selectedDate;
    Button btnGuardar, btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        txtNombre = findViewById(R.id.textViewNombre);
        editTextNombre = findViewById(R.id.editTextNombre);
        radioButtonPlanta = findViewById(R.id.radioButtonPlanta);
        radioButtonAnimal = findViewById(R.id.radioButtonAnimal);
        radioButtonFigura = findViewById(R.id.radioButtonFigura);
        calendario = findViewById(R.id.calendarView);
        btnGuardar = findViewById(R.id.btnSave);
        btnVer = findViewById(R.id.btnVer);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating a file called "preferencias1" in the internal storage of the device.
                SharedPreferences sharedPref = getSharedPreferences("preferencias1", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                // Saving the value of the `editTextNombre` in the `preferencias1` file.
                editor.putString("nombre", editTextNombre.getText().toString());

                // Saving the value of the radio button that is checked.
                if (radioButtonPlanta.isChecked()){
                    editor.putString("tema","planta");
                }
                if (radioButtonAnimal.isChecked()){
                    editor.putString("tema","animal");
                }
                if (radioButtonFigura.isChecked()){
                    editor.putString("tema","figura");
                }
                // Saving the value of the variable `selectedDate` in the file `preferencias1` with the
                // key `fecha`.
                editor.putString("fecha", selectedDate);
                // Saving the data in the file.
                editor.commit();
                Toast mensaje = Toast.makeText(getApplicationContext(), "Datos guardados", Toast.LENGTH_LONG);
                mensaje.show();
            }
        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VerDatos.class);
                startActivity(intent);
            }
        });

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });
    }
}