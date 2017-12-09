package com.example.android.endate;

/**
 * @Product represents an item that contains basic information about a specific product.
 * It contains product's name and expiration date.
 */

public class Product {

    private int mProductNameId;
    private int mExpirationDate;
    private int mProductImageId;

    /**
     * Create a new Product object.
     *
     * @productNameId is the String resource ID for the name of a product.
     * @expirationDate is the integer that stores a date
     */

    public Product(int productNameId, int expirationDate, int productImageId) {
        mProductNameId = productNameId;
        mExpirationDate = expirationDate;
        mProductImageId = productImageId;
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

    public int getExpirationDate() {
        return mExpirationDate;
    }

    /**
     * Get the image red ID
     */
    public int getProductImageId() {
        return mProductImageId;
    }
}
