package com.example.assignmentapp;

public class HorizantalProductScrollModel {

    private int ProductImage;
    private String ProductTitle;
    private String ProductDetails;
    private String ProductPrice;

    public HorizantalProductScrollModel(int productImage, String productTitle, String productDetails, String productPrice) {
        ProductImage = productImage;
        ProductTitle = productTitle;
        ProductDetails= productDetails;
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {
        ProductTitle = productTitle;
    }

    public String getProductDetails() {
        return ProductDetails;
    }

    public void setProductDetails(String productDescription) {
        ProductDetails = getProductDetails();
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }
}
