package com.example.assignmentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {

    private List<CartitemModel> cartitemModelList;

    public CartAdapter(List<CartitemModel> cartitemModelList) {
        this.cartitemModelList = cartitemModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartitemModelList.get(position).getType()) {
            case 0:
                return CartitemModel.CART_ITEM;
            case 1:
                return CartitemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case CartitemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new CartItemViewholder(cartItemView);

            case CartitemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                return new CartTotalAmountViewholder(cartTotalView);

            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewholder, int position) {
        switch (cartitemModelList.get(position).getType()){
            case CartitemModel.CART_ITEM:
                int resource = cartitemModelList.get(position).getProductImage();
                String title = cartitemModelList.get(position).getProductTitle();
                int freeCoupens  = cartitemModelList.get(position).getFreecoupens();
                String productPrice = cartitemModelList.get(position).getProductPrice();
                String cuttedPrice = cartitemModelList.get(position).getCuttedPrice();
                int offersApplied = cartitemModelList.get(position).getOffersApplied();
                ((CartItemViewholder)viewholder).setItemDetails(resource,title,freeCoupens,productPrice,cuttedPrice,offersApplied);
                break;
            case CartitemModel.TOTAL_AMOUNT:
                String totalItems = cartitemModelList.get(position).getTotalItems();
                String totalItemPrice = cartitemModelList.get(position).getTotalItemPrice();
                String deliveryPrice = cartitemModelList.get(position).getDeliveryPrice();
                String totalAmount = cartitemModelList.get(position).getTotalAmount();
                String savedAmount = cartitemModelList.get(position).getSavedAmount();
                ((CartTotalAmountViewholder)viewholder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                break;
            default:
                return;
        }

    }

    @Override
    public int getItemCount() {
        return cartitemModelList.size();
    }

    class CartItemViewholder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private ImageView freecoupenIcon;
        private TextView productTitle;
        private TextView freeCoupens;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offersApplied;
        private TextView coupensApplied;
        private TextView productQuantity;

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.cart_product_image);
            freecoupenIcon = itemView.findViewById(R.id.free_coupon_icon);
            productTitle = itemView.findViewById(R.id.cart_product_title);
            freeCoupens = itemView.findViewById(R.id.free_coupon_text);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            offersApplied = itemView.findViewById(R.id.offers_applied);
            coupensApplied = itemView.findViewById(R.id.coupen_applied);
            productQuantity = itemView.findViewById(R.id.qty_product);

        }
        private void setItemDetails(int resource,String title, int freeCoupensNo, String productPriceText,String cuttedPriceText, int offersAppliedNo ){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCoupensNo > 0){
                freecoupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setVisibility(View.VISIBLE);
                if (freeCoupensNo == 1) {
                    freeCoupens.setText("free " + freeCoupensNo + " Coupen");
                }else {
                    freeCoupens.setText("free " + freeCoupensNo + " Coupens");
                }
            }else {
                freecoupenIcon.setVisibility(View.INVISIBLE);
                freeCoupens.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
            cuttedPrice.setText(cuttedPriceText);
            if (offersAppliedNo > 0){
                offersApplied.setVisibility(View.VISIBLE);
                offersApplied.setText(offersAppliedNo + " offers applied");
            }else {
                offersApplied.setVisibility(View.INVISIBLE);
            }
        }
    }

    class CartTotalAmountViewholder extends RecyclerView.ViewHolder {

        private TextView totalItems;
        private TextView totalItemPrice;
        private TextView deliveryprice;
        private TextView totalAmount;
        private TextView savedAmount;

        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);
            totalItems = itemView.findViewById(R.id.total_items);
            totalItemPrice = itemView.findViewById(R.id.total_item_price);
            deliveryprice = itemView.findViewById(R.id.delivery_charge_price);
            totalAmount = itemView.findViewById(R.id.total_amount_price);
            savedAmount = itemView.findViewById(R.id.savings_amount);
        }
        private void setTotalAmount(String totalItemText, String totalItemPriceText, String deliveryPriceText, String totalAmountText, String savedAmountText){
            totalItems.setText(totalItemText);
            totalItemPrice.setText(totalItemPriceText);
            deliveryprice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
            savedAmount.setText(savedAmountText);
        }
    }
}
