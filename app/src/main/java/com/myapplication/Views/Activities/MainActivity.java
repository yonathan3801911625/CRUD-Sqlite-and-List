package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPersona;
    Button btnVehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPersona = findViewById(R.id.btnPersonasPrincipal);
        btnPersona.setOnClickListener(this);
        btnVehiculo = findViewById(R.id.btnVehiculosPrincipal);
        btnVehiculo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnPersonasPrincipal){
            Intent objIntent = new Intent(MainActivity.this, MenuPersonas.class);
            startActivity(objIntent);
        }
        if (v.getId() == R.id.btnVehiculosPrincipal){
            Intent objIntent = new Intent(MainActivity.this, MenuVehiculos.class);
            startActivity(objIntent);
        }


    }
}