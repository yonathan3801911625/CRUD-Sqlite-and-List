package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myapplication.Data.DataBase;
import com.myapplication.Data.dbSellers;
import com.myapplication.Model.Seller;
import com.myapplication.R;

public class RegisterSeller extends AppCompatActivity implements View.OnClickListener {
    TextView edtDoc;
    TextView edtName;
    TextView edtType;
    TextView edtArea;
    TextView edtSucursal;
    TextView edtTel;
    TextView edtMail;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);
        edtDoc = findViewById(R.id.edtRegisSellerDoc);
        edtName = findViewById(R.id.edtRegisSellerName);
        edtType = findViewById(R.id.edtRegisSellerType);
        edtArea = findViewById(R.id.edtRegisSellerArea);
        edtSucursal = findViewById(R.id.edtRegisSellerSucursal);
        edtTel = findViewById(R.id.edtRegisSellerTel);
        edtMail = findViewById(R.id.edtRegisSellerMail);

        btnAdd = findViewById(R.id.btnRegisSellerAdd);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegisSellerAdd){
            Seller s = new Seller();
            s.setDocument(edtDoc.getText().toString());
            s.setName(edtName.getText().toString());
            s.setType(Integer.parseInt(edtType.getText().toString()));
            s.setArea(edtArea.getText().toString());
            s.setSucursal(edtSucursal.getText().toString());
            s.setTelephone(edtTel.getText().toString());
            s.setEmail(edtMail.getText().toString());

            DataBase dbHelper= new DataBase(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbSellers dbse = new dbSellers(db);
            dbse.insertSeller(s);
            finish();

        }
    }
}