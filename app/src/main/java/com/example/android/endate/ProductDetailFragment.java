package com.example.android.endate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class ProductDetailFragment extends Fragment {

    private Product mProduct;
    private String mProductName;
    private EditText mEnterNameField;
    private Button mDateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new Product(mProductName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        mEnterNameField = (EditText)v.findViewById(R.id.add_product_title);
        mEnterNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mProduct.setProductName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //intentionally left blank
            }
        });

        mDateButton = (Button)v.findViewById(R.id.add_product_expiration_date);
        mDateButton.setText(mProduct.getExpirationDate().toString());
        mDateButton.setEnabled(false);

        return v;
    }
}
