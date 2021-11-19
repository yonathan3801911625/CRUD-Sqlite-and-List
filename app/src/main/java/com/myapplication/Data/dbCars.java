package com.myapplication.Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myapplication.Model.Car;

import java.sql.Struct;
import java.util.ArrayList;

public class dbCars {

    SQLiteDatabase db;
    private Car car;

    public dbCars(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertCar(Car c){
        ContentValues cv = new ContentValues();
        cv.put(Structure.ColumnCar.idC,c.getId());
        cv.put(Structure.ColumnCar.nameC,c.getName());
        cv.put(Structure.ColumnCar.valueC,c.getValue());
        cv.put(Structure.ColumnCar.placaC,c.getPlaca());
        cv.put(Structure.ColumnCar.modelC,c.getModel());
        cv.put(Structure.ColumnCar.colorC,c.getColor());
        cv.put(Structure.ColumnCar.typeC, c.getType());
        cv.put(Structure.ColumnCar.documentC, c.getDocument());
        cv.put(Structure.ColumnCar.urlC, c.getUrl());
        db.insert(DataBase.Tablas.Carros,null, cv);
    }

    public void deleteCar(String id){
        db.delete(DataBase.Tablas.Carros, Structure.ColumnCar.idC+"=?", new String[]{id});
        db.close();
    }


    public int conteoCars(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from carros", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }



    public ArrayList<Car> obtenerVehiculo(){
        ArrayList<Car> objArrayC = new ArrayList<>();
        Cursor c = db.rawQuery("select * from carros",null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Car car = new Car();
                car.setId(c.getString(c.getColumnIndex(Structure.ColumnCar.idC)));
                car.setName(c.getString(c.getColumnIndex(Structure.ColumnCar.nameC)));
                car.setValue(c.getString(c.getColumnIndex(Structure.ColumnCar.valueC)));
                car.setPlaca(c.getString(c.getColumnIndex(Structure.ColumnCar.placaC)));
                car.setModel(c.getColumnIndex(Structure.ColumnCar.modelC));
                car.setColor(c.getString(c.getColumnIndex(Structure.ColumnCar.colorC)));
                car.setType(c.getString(c.getColumnIndex(Structure.ColumnCar.typeC)));
                car.setDocument(c.getString(c.getColumnIndex(Structure.ColumnCar.documentC)));
                car.setUrl(c.getString(c.getColumnIndex(Structure.ColumnCar.urlC)));
                objArrayC.add(car);
            }while (c.moveToNext());
        }
        c.close();
        return  objArrayC;
    }
}
