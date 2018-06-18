package br.com.gwaya.maxspin.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import br.com.gwaya.maxspin.Adapters.MyFragmentPagerAdapter;
import br.com.gwaya.maxspin.R;

/**
 * Created by Diego on 10/06/2018.
 * https://www.youtube.com/watch?v=faegDgN7wX4
 */

public class MonitorActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TextView rpm;
    private SeekBar rmpMax;
    private SeekBar.OnSeekBarChangeListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        rpm = (TextView) findViewById(R.id.textRPM);
        rmpMax = (SeekBar) findViewById(R.id.seekBarRpm);
        rmpMax.setOnSeekBarChangeListener(listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rpm.setText( i + "RPM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }); {

        }

        mTabLayout = (TabLayout) findViewById(R.id.TabLayout);
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);

        mViewPager.setAdapter( new MyFragmentPagerAdapter(getSupportFragmentManager(),
                getResources().getStringArray(R.array.titulosDasTabs)));

        mTabLayout.setupWithViewPager(mViewPager);



    }
}
