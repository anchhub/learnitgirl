package com.example.android.endate;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ProductDataStash {
    private static ProductDataStash sProductDataStash;
    private List<Product> mProducts;

    public static ProductDataStash get(Context context){
        if (sProductDataStash == null) {
            sProductDataStash = new ProductDataStash(context);
        }
        return sProductDataStash;
    }

    private ProductDataStash (Context context) {
        mProducts = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setProductName("Product #" + i);
            mProducts.add(product);
        }
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public Product getProduct(UUID id) {
        for (Product product : mProducts) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
