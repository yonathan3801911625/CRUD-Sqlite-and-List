package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.myapplication.Data.DataBase;
import com.myapplication.Data.dbCars;
import com.myapplication.Model.Car;
import com.myapplication.R;
import com.myapplication.Views.Adapters.CarAdapter;

import java.util.ArrayList;


public class MenuVehiculos extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCreate;
    private ListView listCar;
    dbCars dbc;
    ArrayList<Car> arrayCar;
    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_vehiculos);
        btnCreate = findViewById(R.id.btnAddVehiculos);
        listCar = findViewById(R.id.lstViewVehicle);
        btnCreate.setOnClickListener(this);
        listCar.setOnItemClickListener(this);
        listCar.setOnItemLongClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        updateElement();
    }


    public void updateElement(){
        DataBase dbHelper= new DataBase(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbc = new dbCars(db);
        arrayCar =dbc.obtenerVehiculo();
        carAdapter = new CarAdapter(this, dbc.obtenerVehiculo());
        listCar.setAdapter(carAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnAddVehiculos:
                Intent objIntent = new Intent(MenuVehiculos.this, RegisterCar.class);
                startActivity(objIntent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Ha seleccionado el vehiculo: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbc.deleteCar(arrayCar.get(position).getId());
        updateElement();
        return false;
    }
}