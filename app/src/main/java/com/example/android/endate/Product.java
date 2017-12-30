package com.example.android.endate;

import java.util.Date;
import java.util.UUID;

public class Product {

    private String mProductName;
    private Date mExpirationDate;
    private UUID mId;

    public Product() {
        this(UUID.randomUUID());
    }

    public Product(UUID id) {
        mId = id;
        mExpirationDate = new Date();
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

    public UUID getId() {
        return mId;
    }

}
