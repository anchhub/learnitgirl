package com.example.android.endate;

import java.util.Date;
import java.util.UUID;

/**
 * @Product represents an item that contains basic information about a specific product.
 * It contains product's name and expiration date.
 */

public class Product {

    private String mProductName;
    private Date mExpirationDate;
    private UUID mId;

    /**
     * Create a new Product object.
     *
     * @productNameId is the String resource ID for the name of a product.
     * @expirationDate is the integer that stores a date
     */

    public Product() {
        mExpirationDate = new Date();
        mId = UUID.randomUUID();
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String name) {
        mProductName = name;
    }

    public Date getExpirationDate() {
        return mExpirationDate;
    }
    
    public void setExpirationDate(Date date) {
        mExpirationDate = date;
    }

    public void setExpirationDate(Date date) {
        mExpirationDate = date;
    }

    public UUID getId() {
        return mId;
    }

}
