package com.example.myapptp2listeprod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<Products> {
    Context context;
    private List<Products> myListOfProductsFull;
    //String rTitle[];
    //String rPrice[];
    int rImage[];

    ProductAdapter(@NonNull  Context context,@NonNull List<Products> myListOfProducts){
        super(context,0,myListOfProducts);
       myListOfProductsFull= new ArrayList<>(myListOfProducts);
    }


    @NonNull
    @Override
    public View getView(int position,@NonNull View convertView,@NonNull ViewGroup parent) {//converView:vue ancienne devenue invisible,i=position.
        if(convertView==null){
            LayoutInflater li = LayoutInflater.from(getContext());//Fabriquer des vues pour afficher les items!!
            convertView =li.inflate(R.layout.item,parent,false);
        }
        ImageView iv = convertView.findViewById(R.id.image);
        TextView myTitle = convertView.findViewById(R.id.titre);
        TextView myPrice = convertView.findViewById(R.id.desc);

        Products newProducts = getItem(position);
        if(newProducts!=null){
            myTitle.setText(newProducts.getIntitule());
            myPrice.setText(newProducts.getP_prixString());
            iv.setImageResource( newProducts.getIdImage());
        }

        return convertView;
        //get les infos du objet !!
       // Products currentItem = (Products) getItem(i);
       // String intitu = currentItem.getIntitule();
       // float prc = currentItem.getPrix();
        //int img = (int) currentItem.getIdImage();


        //Set our ressources on view
        // iv.setImageResource(rImage[position]);
        // myTitle.setText(rTitle[position]);
        //myPrice.setText(rPrice[position]);

    }
}

