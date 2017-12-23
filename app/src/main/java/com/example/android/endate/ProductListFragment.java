package com.example.android.endate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductListFragment extends Fragment {

    private RecyclerView mProductRecyclerView;
    private ProductAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        mProductRecyclerView = (RecyclerView) view.findViewById(R.id.product_recycler_view);
        mProductRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ProductDataStash productDataStash = ProductDataStash.get(getActivity());
        List<Product> products = productDataStash.getProducts();

        if (mAdapter == null) {
            mAdapter = new ProductAdapter(products);
            mProductRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ProductHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Product mProduct;
        private TextView mProductNameTextView;
        private TextView mExpirationDateTextView;

        public ProductHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mProductNameTextView = (TextView)
                    itemView.findViewById(R.id.list_item_product_name_text_view);
            mExpirationDateTextView = (TextView)
                    itemView.findViewById(R.id.list_item_product_expiration_date_text_view);
        }

        public void bindProduct(Product product) {
            mProduct = product;
            mProductNameTextView.setText(mProduct.getProductName());
            mExpirationDateTextView.setText(mProduct.getExpirationDate().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ProductPagerActivity.newIntent(getActivity(), mProduct.getId());
            startActivity(intent);
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {

        private List<Product> mProducts;

        public ProductAdapter(List<Product> products) {
            mProducts = products;
        }

        @Override
        public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_product, parent, false);
            return new ProductHolder(view);
        }

        @Override
        public void onBindViewHolder(ProductHolder holder, int position) {
            Product product = mProducts.get(position);
            holder.bindProduct(product);
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }
}
