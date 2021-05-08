package com.codewithadesh.onlinedailygroceries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithadesh.onlinedailygroceries.R;
import com.codewithadesh.onlinedailygroceries.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHoler> {

    Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_row_items,parent,false);
        return new CategoryViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHoler holder, int position) {

        holder.categoryImage.setImageResource(categoryList.get(position).getImageurl());



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public static class CategoryViewHoler extends RecyclerView.ViewHolder{

        ImageView categoryImage;


        public CategoryViewHoler(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }



}