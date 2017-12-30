package com.example.android.endate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.endate.database.ProductBaseHelper;
import com.example.android.endate.database.ProductCursorWrapper;
import com.example.android.endate.database.ProductDbSchema;
import com.example.android.endate.database.ProductDbSchema.ProductTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


class ProductDataStash {

    private static ProductDataStash sProductDataStash;
    private Context mContext;
    private static SQLiteDatabase mDatabase;

    public static ProductDataStash get(Context context){
        if (sProductDataStash == null) {
            sProductDataStash = new ProductDataStash(context);
        }
        return sProductDataStash;
    }

    private ProductDataStash (Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ProductBaseHelper(mContext)
                .getWritableDatabase();
    }

    public void addProduct(Product p) {
        ContentValues values = getContentValues(p);

        mDatabase.insert(ProductTable.NAME, null, values);
    }

    public static void deleteProduct(Product product) {
        mDatabase.delete(
                ProductTable.NAME,
                ProductTable.Cols.UUID + " = ?",
                new String[] {product.getId().toString()}
        );
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        ProductCursorWrapper cursor = queryProducts(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                products.add(cursor.getProduct());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return products;
    }

    public Product getProduct(UUID id) {
        ProductCursorWrapper cursor = queryProducts(
                ProductTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getProduct();
        } finally {
            cursor.close();
        }
    }

    public void updateProduct(Product product) {
        String uuidString = product.getId().toString();
        ContentValues values = getContentValues(product);

        mDatabase.update(ProductTable.NAME, values,
                ProductTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private static ContentValues getContentValues(Product product) {
        ContentValues values = new ContentValues();
        values.put(ProductTable.Cols.UUID, product.getId().toString());
        values.put(ProductTable.Cols.NAME, product.getProductName());
        values.put(ProductTable.Cols.DATE, product.getExpirationDate().getTime());

        return values;
    }

    private ProductCursorWrapper queryProducts(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ProductTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        return new ProductCursorWrapper(cursor);
    }
}
