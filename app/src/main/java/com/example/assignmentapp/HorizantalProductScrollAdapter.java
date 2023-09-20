package com.example.assignmentapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.assignmentapp.HorizantalProductScrollModel;
import com.example.assignmentapp.R;

import java.util.List;

public class HorizantalProductScrollAdapter extends RecyclerView.Adapter<HorizantalProductScrollAdapter.ViewHolder> {

    private List<HorizantalProductScrollModel> horizantalproductModelList;

    public HorizantalProductScrollAdapter(List<HorizantalProductScrollModel> horizantalproductModelList) {
        this.horizantalproductModelList = horizantalproductModelList;
    }

    @NonNull
    @Override
    public HorizantalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizantal_scroll_item_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizantalProductScrollAdapter.ViewHolder viewHolder, int position) {
        int resource = horizantalproductModelList.get(position).getProductImage();
        String title = horizantalproductModelList.get(position).getProductTitle();
        String details = horizantalproductModelList.get(position).getProductDetails();
        String price = horizantalproductModelList.get(position).getProductPrice();

        viewHolder.setProductImage(resource);
        viewHolder.setProductTitle(title);
        viewHolder.setProductDetails(details);
        viewHolder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        if (horizantalproductModelList.size() > 8){
            return 8;
        }else {

            return horizantalproductModelList.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ProductImage;
        private TextView ProductTitle;
        private TextView ProductDetails;
        private TextView ProductPrice;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ProductImage = itemView.findViewById(R.id.h_s_productimg);
            ProductTitle = itemView.findViewById(R.id.h_s_productname);
            ProductDetails = itemView.findViewById(R.id.h_s_productdetails);
            ProductPrice = itemView.findViewById(R.id.h_s_productprice);


        }

        private void setProductImage(int resource){
            ProductImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            ProductTitle.setText(title);
        }
        private void setProductDetails(String details){
            ProductDetails.setText(details);
        }
        private void setProductPrice(String price){
            ProductPrice.setText(price);
        }

    }
}
