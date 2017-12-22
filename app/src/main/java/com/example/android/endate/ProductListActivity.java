package com.example.android.endate;


import android.support.v4.app.Fragment;

public class ProductListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ProductListFragment();
    }
}
