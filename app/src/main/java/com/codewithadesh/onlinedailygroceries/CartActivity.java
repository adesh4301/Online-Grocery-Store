
package com.codewithadesh.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        GlobalCartClass globalCartClass=(GlobalCartClass)getApplicationContext();

        TextView text=(TextView)findViewById(R.id.testText);

        Map<String,Integer> map=new HashMap<>();
        map=globalCartClass.getCartMap();

        Map<String,Integer> priceMap=new HashMap<>();
        priceMap.put("Watermelon",80);
        priceMap.put("Papaya",67);
        priceMap.put("Strawberry",90);
        priceMap.put("Kiwi",60);

        Iterator<Map.Entry<String,Integer>> itr=map.entrySet().iterator();

        int total=0;

        while(itr.hasNext()){
            Map.Entry<String,Integer> entry=itr.next();
            text.append("\n"+"\n"+"\n"+entry.getKey()+"               "+priceMap.get(entry.getKey()).toString()+"                 "+entry.getValue()+"\n"+"\n"+"\n");
            total+=priceMap.get(entry.getKey())*entry.getValue();
        }

        text.append("Total Amount = "+String.valueOf(total));

    }
}