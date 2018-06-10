package br.com.gwaya.maxspin.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.gwaya.maxspin.R;

/**
 * Created by Diego on 10/06/2018.
 * https://www.youtube.com/watch?v=faegDgN7wX4
 */

public class MonitorActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        mTabLayout = (TabLayout) findViewById(R.id.MyTabLayout);


    }
}
