package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.ui.home.ExampleItem;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Main2Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);


        String recipeId = getIntent().getStringExtra("recipeId");
        ExampleItem recipe = HomeFragment.getRecipe(recipeId);

        ImageView iv = findViewById(R.id.recipe_image);


        Picasso picasso = Picasso.get();
        picasso.setLoggingEnabled(true);
        picasso.load(recipe.getImageResource()).into(iv);

        TextView tv = findViewById(R.id.title11);
        tv.setText(recipe.getText1());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_checkbox);
        for (String ing : recipe.getIngredients()) {
            CheckBox cb = new CheckBox(this);
            cb.setText(ing);
            cb.setTextSize(10);

            cb.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));


            linearLayout.addView(cb);


        }
        int index = 0;
        for (ExampleItem.Step st : recipe.getDescription()) {
            index++;
            TextView tv1 = new TextView(this);

            String tempString = "Step number " + index + "\n";
            SpannableString spanString = new SpannableString(tempString);
            spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
            tv1.setText(spanString);
            tv1.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            linearLayout.addView(tv1);
            if (st.getImageRef() != null) {
                ImageView ii = new ImageView(this);
                picasso = Picasso.get();
                picasso.setLoggingEnabled(true);
                picasso.load(st.getImageRef()).into(ii);
                ii.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(ii);
            }


            tv1 = new TextView(this);
            tv1.setText(st.getDescription());
            tv1.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(tv1);

        }
        Button button = new Button(this);
        button.setText("Заказать в Магните!");
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://magnit.ru/promo/"));
                startActivity(viewIntent);
            }
        });

        linearLayout.addView(button);


    }
}