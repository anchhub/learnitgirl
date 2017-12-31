package com.example.android.endate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class ProductPagerActivity extends AppCompatActivity {

    private static final String EXTRA_PRODUCT_ID = "com.example.android.endate.product_id";

    private ViewPager mViewPager;
    private List<Product> mProducts;



    public static Intent newIntent(Context packageContext, UUID productId) {
        Intent intent = new Intent(packageContext, ProductPagerActivity.class);
        intent.putExtra(EXTRA_PRODUCT_ID, productId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_pager);

        UUID productId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_PRODUCT_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_product_pager_view_pager);

        mProducts = ProductDataStash.get(this).getProducts();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Product product = mProducts.get(position);
                return ProductDetailFragment.newInstance(product.getId());
            }

            @Override
            public int getCount() {
                return mProducts.size();
            }
        });

        for (int i = 0; i < mProducts.size(); i++) {
            if (mProducts.get(i).getId().equals(productId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
