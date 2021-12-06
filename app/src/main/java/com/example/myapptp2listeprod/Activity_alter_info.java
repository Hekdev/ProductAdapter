package com.example.myapptp2listeprod;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_alter_info extends AppCompatActivity {
    Button btnValidate,btnRollback;
    EditText editName,editPrice;
    private static final int APPEL_ACTIV2 = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter);
        Intent receivedIntent = getIntent();
        String productName = receivedIntent.getStringExtra("prodName");
         editName = (EditText) findViewById(R.id.editNama);
        editPrice = (EditText) findViewById(R.id.editPrice);
         btnValidate = (Button) findViewById(R.id.validate);
       // btnRollback = (Button) findViewById(R.id.rollback);
        editName.setText(productName);
        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String newProductName = editName.getText().toString();
          float newProductPrice = Float.valueOf(editPrice.getText().toString());
            Intent thisIntent = new Intent();
            thisIntent.putExtra("newProdName",newProductName);
                thisIntent.putExtra("newProdPrice",newProductPrice);
            setResult(RESULT_OK,thisIntent);
            finish();

            }
        });



    }

}
