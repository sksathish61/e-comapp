package com.example.assignmentapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 */
public class fragment_mycart extends Fragment {



    public fragment_mycart() {
        // Required empty public constructor
    }


    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_mycart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_item_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartitemModel> cartitemModelList = new ArrayList<>();
        cartitemModelList.add(new CartitemModel(0,R.drawable.phone1,"Realme 5Pro",2,"Rs.199,999/-","Rs.13999/-",1,0,0));
        cartitemModelList.add(new CartitemModel(0,R.drawable.phone1,"Realme 5Pro",0,"Rs.19,999/-","Rs.13999/-",1,1,0));

        cartitemModelList.add(new CartitemModel(1,"Price(2 items)","Rs.39000/-","Free","Rs.35000/-","Rs.999/-"));

        CartAdapter cartAdapter = new CartAdapter(cartitemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();


        return view;
    }
}