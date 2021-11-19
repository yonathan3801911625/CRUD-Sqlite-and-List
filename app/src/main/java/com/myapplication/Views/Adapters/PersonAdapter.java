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

import com.myapplication.Model.Person;
import com.myapplication.R;

public class PersonAdapter extends BaseAdapter {

    protected Activity objActivityAdp;
    protected ArrayList<Person> objPersonaAdp;


    public PersonAdapter(Activity act, ArrayList<Person> per){
        this.objActivityAdp = act;
        this.objPersonaAdp = per;
    }

    @Override
    public int getCount() {
        return objPersonaAdp.size();
    }

    @Override
    public Object getItem(int i) {
        return objPersonaAdp.get(i);
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
            v=inf.inflate(R.layout.person_item, null);
        }
        Person objPerson = objPersonaAdp.get(i);
        TextView txtDoc = v.findViewById(R.id.txtPerItemId);
        TextView txtName = v.findViewById(R.id.txtCarItemName);
        TextView txtAge = v.findViewById(R.id.txtPerItemAge);
        TextView txtEmail = v.findViewById(R.id.txtPerItemMail);
        TextView txtTel = v.findViewById(R.id.txtPerItemTel);
        ImageView img = v.findViewById(R.id.ImgPerItem);

        txtDoc.setText(objPerson.getDocument());
        txtName.setText(objPerson.getName());
        txtAge.setText(String.valueOf(objPerson.getAge()));
        txtEmail.setText(objPerson.getEmail());
        txtTel.setText(objPerson.getTelephone());
        //Picasso.get().load("");

        return v;
    }

}
