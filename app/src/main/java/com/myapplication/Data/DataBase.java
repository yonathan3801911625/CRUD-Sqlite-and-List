package com.myapplication.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "CarPer.db";
    private static final int ACTUAL_VERSION = 2;
    private final Context context;

    public DataBase(Context context) {
        super(context, DATA_BASE_NAME,null,ACTUAL_VERSION);
        this.context = context;
    }

    interface Tablas{
        String Carros = "carros";
        String Personas = "personas";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s " +
                        "(%s TEXT PRIMARY KEY," + //documento
                        "%s TEXT NOT NULL," + //nombre
                        "%s INTEGER NOT NULL," + //edad
                        "%s TEXT NOT NULL," + //email
                        "%s TEXT NOT NULL)", //telefono
                Tablas.Personas, Structure.ColumnPerson.documentP,
                Structure.ColumnPerson.nameP, Structure.ColumnPerson.edadP,
                Structure.ColumnPerson.emailP, Structure.ColumnPerson.telefonoP));


        db.execSQL(String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY AUTOINCREMENT," + //id
                        "%s TEXT NOT NULL," +  //nombre
                        "%s TEXT NOT NULL," + //valor
                        "%s TEXT NOT NULL," + //placa
                        "%s INTEGER NOT NULL," + //modelo
                        "%s TEXT NOT NULL," + //color
                        "%s TEXT NOT NULL," + //tipo
                        "%s TEXT NOT NULL," + //url
                        "%s TEXT NOT NULL," + //documento
                        "foreign key(%s) references %s (%s))" //declaracion llave foranea
                ,Tablas.Carros, Structure.ColumnCar.idC,
                Structure.ColumnCar.nameC,Structure.ColumnCar.valueC,
                Structure.ColumnCar.placaC,Structure.ColumnCar.modelC,
                Structure.ColumnCar.colorC, Structure.ColumnCar.typeC, Structure.ColumnCar.urlC,
                Structure.ColumnCar.documentC,/*Structure.ColumnCar.documentC,*/
                Tablas.Personas, Structure.ColumnPerson.documentP));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Tablas.Carros);
        db.execSQL("DROP TABLE IF EXISTS "+ Tablas.Personas);
        onCreate(db);
    }
}
