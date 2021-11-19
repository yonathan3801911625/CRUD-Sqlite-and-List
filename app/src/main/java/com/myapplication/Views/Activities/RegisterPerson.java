package com.myapplication.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.myapplication.Data.DataBase;
import com.myapplication.Data.dbPersons;
import com.myapplication.Model.Person;
import com.myapplication.R;

public class RegisterPerson extends AppCompatActivity implements View.OnClickListener {
    TextView edtDoc;
    TextView edtName;
    TextView edtAge;
    TextView edtMail;
    TextView edtTel;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_person);
        edtDoc.findViewById(R.id.edtRegisPersonDocument);
        edtName.findViewById(R.id.edtRegisPersonName);
        edtAge.findViewById(R.id.edtRegisPersonAge);
        edtMail.findViewById(R.id.edtRegisPersonEmail);
        edtTel.findViewById(R.id.edtRegisPersonTelephone);

        btnAdd.findViewById(R.id.btnRegisPerson);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegisPerson){
            Person p = new Person();
            p.setDocument(edtDoc.getText().toString());
            p.setName(edtName.getText().toString());
            p.setAge(Integer.parseInt(edtAge.getText().toString()));
            p.setTelephone(edtTel.getText().toString());
            p.setEmail(edtMail.getText().toString());

            DataBase dbHelper= new DataBase(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbPersons dbp = new dbPersons(db);
            dbp.insertPerson(p);
            finish();

        }
    }

}