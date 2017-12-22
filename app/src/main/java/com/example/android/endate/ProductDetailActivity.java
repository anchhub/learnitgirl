package com.example.android.endate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Aleksandra on 20-Dec-17.
 */

public class ProductDetailActivity extends SingleFragmentActivity {

   @Override
    protected Fragment createFragment() {
        return new ProductDetailFragment();
   }
}

