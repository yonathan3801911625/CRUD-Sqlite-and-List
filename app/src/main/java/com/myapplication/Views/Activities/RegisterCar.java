package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myapplication.Data.DataBase;
import com.myapplication.Data.dbCars;
import com.myapplication.Model.Car;
import com.myapplication.R;

public class RegisterCar extends AppCompatActivity implements View.OnClickListener {

    TextView edtId;
    TextView edtName;
    TextView edtValue;
    TextView edtPlaca;
    TextView edtModel;
    TextView edtColor;
    TextView edtType;
    TextView edtDoc;
    TextView edtURL;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);
        edtId = findViewById(R.id.edtRegisCarID);
        edtName = findViewById(R.id.edtRegisCarName);
        edtValue = findViewById(R.id.edtRegisCarValue);
        edtPlaca = findViewById(R.id.edtRegisCarPlaca);
        edtModel = findViewById(R.id.edtRegisCarModel);
        edtColor = findViewById(R.id.edtRegisCarColor);
        edtType =findViewById(R.id.edtRegisCarType);
        edtDoc = findViewById(R.id.edtRegisCarDocument);
        edtURL = findViewById(R.id.edtRegisCarUrl);

        btnAdd = findViewById(R.id.btnRegisCar);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegisCar){
            Car c = new Car();
            c.setId(edtId.getText().toString());
            c.setName(edtName.getText().toString());
            c.setValue(edtValue.getText().toString());
            c.setPlaca(edtPlaca.getText().toString());
            c.setModel(Integer.parseInt(edtModel.getText().toString()));
            c.setColor(edtColor.getText().toString());
            c.setType(edtType.getText().toString());
            //c.setDocument(edtDoc.getText().toString());
            c.setUrl(edtURL.getText().toString());

            DataBase dbHelper= new DataBase(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbCars dbc = new dbCars(db);
            dbc.insertCar(c);
            finish();

        }
    }

}