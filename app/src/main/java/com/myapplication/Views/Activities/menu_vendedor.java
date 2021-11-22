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
import com.myapplication.Data.dbSellers;
import com.myapplication.Model.Seller;
import com.myapplication.R;
import com.myapplication.Views.Adapters.SellerAdapter;

import java.util.ArrayList;

public class menu_vendedor extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    private Button btnCreate;
    private ListView listSeller;
    dbSellers dbse;
    ArrayList<Seller> arraySeller;
    SellerAdapter selAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_vendedor);
        btnCreate = findViewById(R.id.btnAddVendedores);
        listSeller = findViewById(R.id.lstMenuVendedores);
        btnCreate.setOnClickListener(this);
        listSeller.setOnItemClickListener(this);
        listSeller.setOnItemLongClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElement();
    }



    public void updateElement(){
        DataBase dbHelper= new DataBase(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbse = new dbSellers(db);
        arraySeller =dbse.obtenerSeller();
        selAdapter = new SellerAdapter(this, dbse.obtenerSeller());
        listSeller.setAdapter(selAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnAddVendedores:
                Intent objIntent = new Intent(menu_vendedor.this, RegisterSeller.class);
                startActivity(objIntent);
                break;
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbse.deleteSeller(arraySeller.get(position).getDocument());
        updateElement();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Ha seleccionado el vendedor: ", Toast.LENGTH_SHORT).show();
    }
}