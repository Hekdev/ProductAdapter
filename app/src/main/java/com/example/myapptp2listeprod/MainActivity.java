package com.example.myapptp2listeprod;
//Auteur:Abarki Hatim GIS5
//Version:2.9
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lv;
    Button btnRemove ;
    EditText txtRemove;
    ProductAdapter ma;
    List<Products> prodList;
    int selectedPosition;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK:
                String productName = data.getStringExtra("newProdName");
                float productPrice = data.getFloatExtra("newProdPrice",0);
                Products newProducts = new Products(productName,productPrice,prodList.get(selectedPosition).p_id_image);
                prodList.set(selectedPosition,newProducts);
                ma.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),productName,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         lv =(ListView) findViewById(R.id.lv);
         prodList= new ArrayList<>() ;
        Resources res = getResources();
        final String intitulees[]= res.getStringArray(R.array.intitules);
        final String prices[]= res.getStringArray(R.array.prix);
        TypedArray images = res.obtainTypedArray(R.array.idimages);
         txtRemove = (EditText) findViewById(R.id.deletefield);
         btnRemove = (Button) findViewById(R.id.validatedelete);



    for(int i=0;i<intitulees.length;i++){
        prodList.add(new Products(intitulees[i], Float.parseFloat(prices[i]),images.getResourceId(i,0)));
    }

        //Now create adapter class.
         ma = new ProductAdapter(this,prodList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 selectedPosition = position;
                String nameProd = prodList.get(position).p_intitule;
                Intent intent = new Intent(MainActivity.this,Activity_alter_info.class);
                intent.putExtra("prodName",  nameProd);
                startActivityForResult(intent,0);
                Toast.makeText(getBaseContext(),"Product name:"+nameProd,Toast.LENGTH_SHORT).show();




                }

        });





        lv.setAdapter(ma);
    //Remove a product.
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int  i =0;i<prodList.size();i++){
                    String  getItemName = txtRemove.getText().toString();
                    if (prodList.get(i).getIntitule().equals(getItemName)){
                        ma.remove(ma.getItem(i));
                        ma.notifyDataSetChanged();
                        lv.setAdapter(ma);
                    }else{
                        Toast.makeText(MainActivity.this,"Ce produit ne correspond a aucun produit dans la liste!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Intent in = getIntent();
        String myName = in.getStringExtra("Prodname");
        String myPrice = in.getStringExtra("Prodprice");
        

    }



}