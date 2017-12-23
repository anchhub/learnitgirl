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
import java.util.UUID;

public class ProductDetailFragment extends Fragment {

    private static final String ARG_PRODUCT_ID = "product_id";

    private Product mProduct;
    private String mProductName;
    private EditText mEnterNameField;
    private Button mDateButton;

    public static ProductDetailFragment newInstance(UUID productId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PRODUCT_ID, productId);

        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID productId = (UUID) getArguments().getSerializable(ARG_PRODUCT_ID);
        mProduct = ProductDataStash.get(getActivity()).getProduct(productId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        mEnterNameField = (EditText)v.findViewById(R.id.add_product_title);
        mEnterNameField.setText(mProduct.getProductName());
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
