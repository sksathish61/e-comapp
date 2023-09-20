package com.example.assignmentapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class GridproductLayoutAdapter extends BaseAdapter {

    List<HorizantalProductScrollModel> horizantalproductModelList;

    public GridproductLayoutAdapter(List<HorizantalProductScrollModel> horizantalproductModelList) {
        this.horizantalproductModelList = horizantalproductModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizantal_scroll_item_layout,null);

            view.setBackgroundColor(Color.parseColor("#ffffff"));


            ImageView productImage = view.findViewById(R.id.h_s_productimg);
            TextView productTitle = view.findViewById(R.id.h_s_productname);
            TextView productDetails = view.findViewById(R.id.h_s_productdetails);
            TextView productPrice = view.findViewById(R.id.h_s_productprice);

            productImage.setImageResource(horizantalproductModelList.get(position).getProductImage());
            productTitle.setText(horizantalproductModelList.get(position).getProductTitle());
            productDetails.setText(horizantalproductModelList.get(position).getProductDetails());
            productPrice.setText(horizantalproductModelList.get(position).getProductPrice());

        }else{
            view =convertView;

        }
        return view;
    }
}
