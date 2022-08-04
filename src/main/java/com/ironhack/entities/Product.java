package com.ironhack.entities;

import com.ironhack.enums.ProductType;

public class Product {
    private String name;
    private float price;
    private ProductType productType;

    public Product(String name, float price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product(String name, ProductType productType) {
        this.name = name;
        this.productType = productType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" + "\n" +
                " name='" + name + '\'' + "\n" +
                " price=" + price + "\n" +
                " productType=" + productType + "\n" +
                '}';
    }
}
