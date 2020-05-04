package com.example.myapplication.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.util.jar.Attributes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
        textview1 = (TextView) findViewById(R.id.textView12);

        // create RangeSeekBar as Integer range between 20 and 75
        RangeSeekBar<Integer> seekBar = new RangeSeekBar<Integer>(getApplicationContext());
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar,
                                                    Integer minValue, Integer maxValue) {
                // handle changed range values
                String powerranger = "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue;
                //Log.i(TAG, powerranger);
                textview1.setText(powerranger);
            }
        });

        // add RangeSeekBar to pre-defined layout
        ViewGroup layout = findViewById(R.id.setting_id);
        layout.addView(seekBar);
    }

}