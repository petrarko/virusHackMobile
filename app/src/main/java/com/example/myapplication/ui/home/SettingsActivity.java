package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication.R;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    public static final String USER_MAX_SUM_ID = "USER_MAX_SUM_ID";
    public static final String USER_MIN_SUM_ID = "USER_MIN_SUM_ID";
    public static final String USER_SKILL_LEVEL_ID = "USER_SKILL_LEVEL_ID";
    public static final String USER_TIME_LIMIT_LEVEL = "USER_TIME_LIMIT_LEVEL";
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
        textview1 = (TextView) findViewById(R.id.textView12);


        RangeSeekBar seekBar = (RangeSeekBar) findViewById(R.id.seekBar);
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar,
                                                    Integer minValue, Integer maxValue) {
                String powerranger = "Минимальная сумма: " + minValue + "р, максимальная:" + maxValue + "р";
                Intent intent = new Intent(bar.getContext(), SettingsActivity.class);
                intent.putExtra(USER_MAX_SUM_ID, maxValue);
                intent.putExtra(USER_MIN_SUM_ID, minValue);
                textview1.setText(powerranger);
            }
        });


        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String powerranger = "Укажи свой уровень умения готовить.\nВы выбрали: " + SkillLevel.getLevel(rating).name;
                Intent intent = new Intent(ratingBar.getContext(), SettingsActivity.class);
                intent.putExtra(USER_SKILL_LEVEL_ID, SkillLevel.getLevel(rating).name);
                textView3.setText(powerranger);
            }

        });


        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final SeekBar sBar = (SeekBar) findViewById(R.id.seekBar2);
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String powerranger = "Ограничение по времени: " + (seekBar.getProgress() + 1) * 6 + " минут";
                Intent intent = new Intent(sBar.getContext(), SettingsActivity.class);
                intent.putExtra(USER_TIME_LIMIT_LEVEL, (seekBar.getProgress() + 1) * 6);
                textView4.setText(powerranger);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String powerranger = "Ограничение по времени: " + (seekBar.getProgress() + 1) * 6 + " минут";
                Intent intent = new Intent(sBar.getContext(), SettingsActivity.class);
                intent.putExtra(USER_TIME_LIMIT_LEVEL, (seekBar.getProgress() + 1) * 6);
                textView4.setText(powerranger);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String powerranger = "Ограничение по времени: " + (seekBar.getProgress() + 1) * 6 + " минут";
                Intent intent = new Intent(sBar.getContext(), SettingsActivity.class);
                intent.putExtra(USER_TIME_LIMIT_LEVEL, (seekBar.getProgress() + 1) * 6);
                textView4.setText(powerranger);

            }

        });


    }

}