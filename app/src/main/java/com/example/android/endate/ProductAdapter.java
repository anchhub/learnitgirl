package com.example.android.endate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aleksandra on 16-Nov-17.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    private int mBackColorResId;

    /**
     * Create a new ProductAdapter object
     */
    public ProductAdapter(Context context, ArrayList<Product> products, int backColorResID) {
        super(context, 0, products);
        mBackColorResId = backColorResID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the Product object located at this position in the list
        Product currentProduct = getItem(position);

        //Find the TextView in list_item.xml layout with the ID product_name
        TextView productNameTextView = (TextView) listItemView.findViewById(R.id.product_name);

        //Get the name from the current Product object, and set this text on the productNameTextView
        productNameTextView.setText(currentProduct.getProductNameId());

        //Find the TextView in list_item.xml layout with the ID product_expiration_date
        TextView expirationDateTextView = (TextView) listItemView.findViewById(R.id.product_expiration_date);

        //Get the expiration date from the current Product object and set this text on the expirationDateTextView
        expirationDateTextView.setText(currentProduct.getExpirationDate());

        //Find the ImageView in list_item.xml with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //If an image is available, display it based on the res id
        imageView.setImageResource(currentProduct.getProductImageId());

        //Set theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that res id maps to
        int color = ContextCompat.getColor(getContext(), mBackColorResId);
        //Set background color for the textContainer
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}

