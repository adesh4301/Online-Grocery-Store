package com.codewithadesh.onlinedailygroceries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithadesh.onlinedailygroceries.AllCategory;
import com.codewithadesh.onlinedailygroceries.R;
import com.codewithadesh.onlinedailygroceries.model.AllCategoryModel;
import com.codewithadesh.onlinedailygroceries.model.Category;

import java.util.List;


public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHoler> {

    Context context;
    List<AllCategoryModel> categoryList;

    public AllCategoryAdapter(Context context, List<AllCategoryModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public AllCategoryViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_items,parent,false);
        return new AllCategoryViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryViewHoler holder, int position) {

        holder.categoryImage.setImageResource(categoryList.get(position).getImageurl());



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public static class AllCategoryViewHoler extends RecyclerView.ViewHolder{

        ImageView categoryImage;


        public AllCategoryViewHoler(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }



}