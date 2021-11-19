package com.myapplication.Views.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.myapplication.Model.Car;
import com.myapplication.R;

public class CarAdapter extends BaseAdapter {

    protected Activity objActivityAdp;
    protected ArrayList<Car> objCarAdp;

    public CarAdapter(Activity act, ArrayList<Car> car){
        this.objActivityAdp = act;
        this.objCarAdp = car;
    }

    @Override
    public int getCount() {
        return objCarAdp.size();
    }

    @Override
    public Object getItem(int i) {
        return objCarAdp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) objActivityAdp.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inf.inflate(R.layout.car_item, null);
        }
        Car objVehicle = objCarAdp.get(i);
        TextView txtId = v.findViewById(R.id.edtRegisCarID);
        TextView txtName = v.findViewById(R.id.edtRegisCarName);
        TextView txtValue = v.findViewById(R.id.edtRegisCarValue);
        TextView txtPlaca = v.findViewById(R.id.edtRegisCarPlaca);
        TextView txtModel = v.findViewById(R.id.edtRegisCarModel);
        TextView txtColor = v.findViewById(R.id.edtRegisCarColor);
        TextView txtType = v.findViewById(R.id.edtRegisCarType);
        TextView txtDoc = v.findViewById(R.id.edtRegisCarDocument);
        TextView txtUrl = v.findViewById(R.id.edtRegisCarUrl);
        //ImageView img = v.findViewById(R.id.imgPerson);

        txtId.setText(objVehicle.getId());
        txtName.setText(objVehicle.getName());
        txtValue.setText(objVehicle.getValue());
        txtPlaca.setText(objVehicle.getPlaca());
        txtModel.setText(String.valueOf(objVehicle.getModel()));
        txtColor.setText(objVehicle.getColor());
        txtType.setText(objVehicle.getType());
        txtDoc.setText(objVehicle.getDocument());
        txtUrl.setText(objVehicle.getUrl());
        //Picasso.get().load("");
        return v;
    }
}
