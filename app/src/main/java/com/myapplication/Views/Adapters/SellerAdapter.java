package com.myapplication.Views.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Model.Seller;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SellerAdapter extends BaseAdapter {

    protected Activity objActivityAdse;
    protected ArrayList<Seller> objSellerAdse;


    public SellerAdapter (Activity act, ArrayList<Seller> sel){
        this.objActivityAdse = act;
        this.objSellerAdse = sel;
    }

    @Override
    public int getCount() {
        return objSellerAdse.size();
    }

    @Override
    public Object getItem(int i) {
        return objSellerAdse.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) objActivityAdse.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inf.inflate(R.layout.seller_item, null);
        }
        Seller objSeller = objSellerAdse.get(i);
        //TextView txtDoc = v.findViewById(R.id.txtSeltemId);
        TextView txtName = v.findViewById(R.id.txtSeltemName);
        TextView txtType = v.findViewById(R.id.txtSeltemType);
        TextView txtArea = v.findViewById(R.id.txtSeltemArea);
        TextView txtSucursal = v.findViewById(R.id.txtSeltemSucursal);
        TextView txtTel = v.findViewById(R.id.txtSeltemTel);
        TextView txtMail = v.findViewById(R.id.txtSeltemMail);
        ImageView img = v.findViewById(R.id.ImgSeltem);

        //txtDoc.setText(objSeller.getDocument());
        txtName.setText(objSeller.getName());
        txtType.setText(String.valueOf(objSeller.getType()));
        txtArea.setText(objSeller.getArea());
        txtSucursal.setText(objSeller.getSucursal());
        txtTel.setText(objSeller.getTelephone());
        txtMail.setText(objSeller.getEmail());
        Picasso.get().load("https://images.pexels.com/photos/3822430/pexels-photo-3822430.jpeg").into(img);

        return v;
    }
}
