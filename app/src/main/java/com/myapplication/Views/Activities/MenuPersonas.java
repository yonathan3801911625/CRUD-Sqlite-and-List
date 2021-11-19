package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.Data.DataBase;
import com.myapplication.Data.dbPersons;
import com.myapplication.Model.Person;
import com.myapplication.R;
import com.myapplication.Views.Adapters.PersonAdapter;

import java.util.ArrayList;

public class MenuPersonas extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnCreate;
    private ListView listPerson;
    dbPersons dbp;
    ArrayList<Person> arrayPerson;
    PersonAdapter perAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_personas);
        btnCreate = findViewById(R.id.btnAddPersonas);
        listPerson = findViewById(R.id.lstViewPerson);
        btnCreate.setOnClickListener(this);
        listPerson.setOnItemClickListener(this);
        listPerson.setOnItemLongClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        updateElement();
    }



    public void updateElement(){
        DataBase dbHelper= new DataBase(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbp = new dbPersons(db);
        arrayPerson =dbp.obtenerPersona();
        perAdapter = new PersonAdapter(this, dbp.obtenerPersona());
        listPerson.setAdapter(perAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnAddPersonas:
                Intent objIntent = new Intent(MenuPersonas.this, RegisterPerson.class);
                startActivity(objIntent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Ha seleccionado la persona: ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        dbp.deletePerson(arrayPerson.get(position).getDocument());
        updateElement();
        return false;
    }
}