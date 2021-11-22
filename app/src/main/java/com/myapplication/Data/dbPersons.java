package com.myapplication.Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myapplication.Model.Person;

import java.util.ArrayList;

public class dbPersons {

    SQLiteDatabase db;
    private Person per;

    public dbPersons(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertPerson(Person p){
        ContentValues cv = new ContentValues();
        cv.put(Structure.ColumnPerson.documentP,p.getDocument());
        cv.put(Structure.ColumnPerson.nameP, p.getName());
        cv.put(Structure.ColumnPerson.edadP,p.getAge());
        cv.put(Structure.ColumnPerson.emailP,p.getEmail());
        cv.put(Structure.ColumnPerson.telefonoP,p.getTelephone());
        db.insert(DataBase.Tablas.Personas,null, cv);
    }

    public void deletePerson(String doc){
        db.delete(DataBase.Tablas.Personas, Structure.ColumnPerson.documentP+"=?", new String[]{doc});
        db.close();
    }


    public int conteoPersonas(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from personas", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }



    public ArrayList<Person> obtenerPersona(){
        ArrayList<Person> objArrayP = new ArrayList<>();
        Cursor c = db.rawQuery("select * from personas",null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Person per = new Person();
                per.setDocument(c.getString(c.getColumnIndex(Structure.ColumnPerson.documentP)));
                per.setName(c.getString(c.getColumnIndex(Structure.ColumnPerson.nameP)));
                per.setAge(c.getInt(c.getColumnIndex(Structure.ColumnPerson.edadP)));
                per.setEmail(c.getString(c.getColumnIndex(Structure.ColumnPerson.emailP)));
                per.setTelephone(c.getString(c.getColumnIndex(Structure.ColumnPerson.telefonoP)));
                objArrayP.add(per);
            }while (c.moveToNext());
        }
        c.close();
        return  objArrayP;
    }
}
