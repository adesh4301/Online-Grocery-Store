package com.codewithadesh.onlinedailygroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.codewithadesh.onlinedailygroceries.adapter.CategoryAdapter;
import com.codewithadesh.onlinedailygroceries.adapter.DiscountedProductAdapter;
import com.codewithadesh.onlinedailygroceries.adapter.RecentlyViewedAdapter;
import com.codewithadesh.onlinedailygroceries.model.Category;
import com.codewithadesh.onlinedailygroceries.model.DiscountedProducts;
import com.codewithadesh.onlinedailygroceries.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView , recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;


    Button allCategory;
    ImageButton openCartButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        discountRecyclerView = findViewById(R.id.discountedRecycler);
        allCategory = (Button)findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        openCartButton=(ImageButton)findViewById(R.id.openCartButton);



        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        openCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discountmeat));

        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provides some fiber", "₹ 80", "1","KG",R.drawable.card4, R.drawable.b4));
        recentlyViewedList.add(new RecentlyViewed("Papaya","Papaya contains high levels of antioxidants.", "₹ 67", "1","KG",R.drawable.card3,R.drawable.b3));
        recentlyViewedList.add(new RecentlyViewed("Strawberry","Packed with fibres,vitamins and high level of antioxidants.", "₹ 90", "1","KG",R.drawable.card2,R.drawable.b1));
        recentlyViewedList.add(new RecentlyViewed("Kiwi","Rich in Vitamin C and dietary fibres.", "₹ 60", "1","PC",R.drawable.card1,R.drawable.b2));


        setDiscountedRecycler(discountedProductsList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> datalist) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this, datalist);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


}