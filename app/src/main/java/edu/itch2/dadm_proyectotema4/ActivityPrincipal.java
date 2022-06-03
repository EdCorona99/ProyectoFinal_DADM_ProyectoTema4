package edu.itch2.dadm_proyectotema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityPrincipal extends AppCompatActivity {

    Button btnActSensor, btnActDb, btnActJsonXml, btnActSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Getting the buttons from the layout.
        btnActSensor = findViewById(R.id.btnActSensor);
        btnActDb = findViewById(R.id.btnActDb);
        btnActJsonXml = findViewById(R.id.btnActJsonXml);
        btnActSharedPreferences = findViewById(R.id.btnActSahredPreferences);

        // Creating a listener for the button btnActSensor.
        btnActSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSensorActivity = new Intent(ActivityPrincipal.this, MainActivity.class);
                startActivity(intentSensorActivity);
            }
        });

        // Creating a listener for the button btnActDb.
        btnActDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDbActivity = new Intent(ActivityPrincipal.this, ActivityDB.class);
                startActivity(intentDbActivity);
            }
        });

        // Creating a listener for the button btnActJsonXml.
        btnActJsonXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJsonXmlActivity = new Intent(ActivityPrincipal.this, ActivityJsonXml.class);
                startActivity(intentJsonXmlActivity);
            }
        });

        // Creating a listener for the button btnActSharedPreferences.
        btnActSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShredPreferencesActivity = new Intent(ActivityPrincipal.this, ActivitySharedPreferences.class);
                startActivity(intentShredPreferencesActivity);
            }
        });
    }
}