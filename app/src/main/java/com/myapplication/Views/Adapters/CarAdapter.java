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
import com.squareup.picasso.Picasso;

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
        TextView txtName = v.findViewById(R.id.txtCarItemName);
        TextView txtValue = v.findViewById(R.id.txtCarItemValue);
        TextView txtPlaca = v.findViewById(R.id.txtCarItemPlaca);
        TextView txtModel = v.findViewById(R.id.txtCarItemModel);
        TextView txtColor = v.findViewById(R.id.txtCarItemColor);
        TextView txtType = v.findViewById(R.id.txtCarItemType);
        //TextView txtDoc = v.findViewById(R.id.edtRegisCarDocument);
        TextView txtUrl = v.findViewById(R.id.txtCarItemUrl);
        ImageView img = v.findViewById(R.id.ImgCarItem);

        txtName.setText(objVehicle.getName());
        txtValue.setText(objVehicle.getValue());
        txtPlaca.setText(objVehicle.getPlaca());
        txtModel.setText(String.valueOf(objVehicle.getModel()));
        txtColor.setText(objVehicle.getColor());
        txtType.setText(objVehicle.getType());
        //txtDoc.setText(objVehicle.getDocument());
        txtUrl.setText(objVehicle.getUrl());
        Picasso.get().load("https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg").into(img);
        return v;
    }
}
