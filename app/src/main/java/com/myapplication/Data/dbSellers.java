package com.myapplication.Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.myapplication.Model.Person;
import com.myapplication.Model.Seller;

import java.util.ArrayList;

public class dbSellers {

    SQLiteDatabase db;
    private Seller sel;

    public dbSellers(SQLiteDatabase db) {
        this.db = db;
    }

    public void insertSeller(Seller s){
        ContentValues cv = new ContentValues();
        cv.put(Structure.ColumnSeller.documentS,s.getDocument());
        cv.put(Structure.ColumnSeller.nameS, s.getName());
        cv.put(Structure.ColumnSeller.typeS,s.getType());
        cv.put(Structure.ColumnSeller.areaS,s.getArea());
        cv.put(Structure.ColumnSeller.sucursalS,s.getSucursal());
        cv.put(Structure.ColumnSeller.telephoneS,s.getTelephone());
        cv.put(Structure.ColumnSeller.emailS,s.getEmail());
        db.insert(DataBase.Tablas.Vendedores,null, cv);
    }

    public void deleteSeller(String doc){
        db.delete(DataBase.Tablas.Vendedores, Structure.ColumnSeller.documentS+"=?", new String[]{doc});
        db.close();
    }


    public int conteoSellers(){
        int conteo = 0;
        Cursor c = db.rawQuery("Select count(*) as conteo from vendedores", null);
        if (c != null ){
            c.moveToFirst();
            do{
                conteo = c.getInt(c.getColumnIndex("conteo"));
            }while (c.moveToNext());
        }
        c.close();
        return  conteo;
    }



    public ArrayList<Seller> obtenerSeller(){
        ArrayList<Seller> objArraySe = new ArrayList<>();
        Cursor c = db.rawQuery("select * from vendedores",null);
        if (c.getCount() > 0 ){
            c.moveToFirst();
            do{
                Seller sel = new Seller();
                sel.setDocument(c.getString(c.getColumnIndex(Structure.ColumnSeller.documentS)));
                sel.setName(c.getString(c.getColumnIndex(Structure.ColumnSeller.nameS)));
                sel.setType(c.getInt(c.getColumnIndex(Structure.ColumnSeller.typeS)));
                sel.setArea(c.getString(c.getColumnIndex(Structure.ColumnSeller.areaS)));
                sel.setSucursal(c.getString(c.getColumnIndex(Structure.ColumnSeller.sucursalS)));
                sel.setTelephone(c.getString(c.getColumnIndex(Structure.ColumnSeller.telephoneS)));
                sel.setEmail(c.getString(c.getColumnIndex(Structure.ColumnSeller.emailS)));
                objArraySe.add(sel);
            }while (c.moveToNext());
        }
        c.close();
        return  objArraySe;
    }
}
