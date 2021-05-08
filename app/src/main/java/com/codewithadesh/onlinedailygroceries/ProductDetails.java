package com.codewithadesh.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ProductDetails extends AppCompatActivity {

    ImageView img,back;
    TextView proName ,proPrice , proDesc;
    String name,price,desc;
    ImageButton addCartButton;
    int image;
    ImageButton openCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        GlobalCartClass globalCartClass=(GlobalCartClass)getApplicationContext();

         name = i.getStringExtra("name");
         image = i.getIntExtra("image",R.drawable.b1);
         price = i.getStringExtra("price");
         desc = i.getStringExtra("desc");

         proName = findViewById(R.id.productName);
         proDesc = findViewById(R.id.prodDesc);
         proPrice = findViewById(R.id.prodPrice);
         img = findViewById(R.id.big_image);
         back = findViewById(R.id.back2);
         addCartButton=(ImageButton)findViewById(R.id.addCartButton);
        openCartButton=(ImageButton)findViewById(R.id.openCartButton);

         proName.setText(name);
         proPrice.setText(price);
         proDesc.setText(desc);
         proName.setText(name);
         img.setImageResource(image);

         addCartButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Map<String,Integer> map=new HashMap<>();
                 map=globalCartClass.getCartMap();
                 if(map.containsKey(name)){
                     map.put(name,map.get(name)+1);
                 }else{
                     map.put(name,1);
                 }
             }
         });

        openCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductDetails.this,CartActivity.class);
                startActivity(intent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent i = new Intent(ProductDetails.this, MainActivity.class);
                 startActivity(i);
                 finish();
             }
         });
    }
}