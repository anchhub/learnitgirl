package com.example.android.endate;

import java.util.Date;
import java.util.UUID;

/**
 * @Product represents an item that contains basic information about a specific product.
 * It contains product's name and expiration date.
 */

public class Product {

    private int mProductNameId;
    private Date mExpirationDate;
    private int mProductImageId;
    private UUID mId;

    /**
     * Create a new Product object.
     *
     * @productNameId is the String resource ID for the name of a product.
     * @expirationDate is the integer that stores a date
     */

    public Product(int productNameId, int productImageId) {
        mProductNameId = productNameId;
        mExpirationDate = new Date();
        mProductImageId = productImageId;
        mId = UUID.randomUUID();

    }

    /**
     * Get the string res ID for the product's name
     */

    public int getProductNameId() {
        return mProductNameId;
    }

    /**
     * Get the int for expiration date
     */

    public Date getExpirationDate() {
        return mExpirationDate;
    }
    
    public void setExpirationDate(Date date) {
        mExpirationDate = date;
    }

    /**
     * Get the image red ID
     */
    public int getProductImageId() {
        return mProductImageId;
    }

    /*
    * Gettter method for read-only mId.
     */
    public UUID getId() {
        return mId;
    }

}
