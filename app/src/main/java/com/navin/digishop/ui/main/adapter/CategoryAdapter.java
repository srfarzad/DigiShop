package com.navin.digishop.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.navin.digishop.R;
import com.navin.digishop.customView.PersianTextView;
import com.navin.digishop.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CatVH> {

    List<Category> categoryList ;

    public CategoryAdapter (List<Category> categories) {
        categoryList =categories;


    }


    @NonNull
    @Override
    public CatVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row,null);

        return new CatVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatVH holder, int position) {


        Category category = categoryList.get(position);

       // Picaa

        String image = "http://androidsupport.ir/market/images/";
        Picasso.get().load(image+category.getIcon()).into(holder.img_category);


        holder.txt_title.setText(category.getTitle());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CatVH extends  RecyclerView.ViewHolder{

        @BindView(R.id.txt_title) PersianTextView txt_title;
        @BindView(R.id.img_category) AppCompatImageView img_category;


        public CatVH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
