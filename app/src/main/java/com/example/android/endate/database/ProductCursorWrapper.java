package com.example.android.endate.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.android.endate.Product;
import com.example.android.endate.database.ProductDbSchema.ProductTable;

import java.util.Date;
import java.util.UUID;


public class ProductCursorWrapper extends CursorWrapper {
    public ProductCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Product getProduct() {
        String uuidString = getString(getColumnIndex(ProductTable.Cols.UUID));
        String name = getString(getColumnIndex(ProductTable.Cols.NAME));
        long date = getLong(getColumnIndex(ProductTable.Cols.DATE));

        Product product = new Product(UUID.fromString(uuidString));
        product.setProductName(name);
        product.setExpirationDate(new Date(date));

        return product;
    }
}
