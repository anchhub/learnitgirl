package com.example.android.endate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class EnDateFragment extends Fragment {


    public EnDateFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.products_list, container, false);

        final ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(R.string.product_name, R.string.expiration_date, R.drawable.product_image));

        ProductAdapter adapter = new ProductAdapter(getActivity(), products, R.color.fragment);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        return rootView;
    }
}