package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.ui.home.ExampleItem;
import com.example.myapplication.ui.home.HomeFragment;
import com.example.myapplication.ui.home.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.squareup.picasso.Picasso;

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

        tv = findViewById(R.id.text_recipe11);
        tv.setText(String.join("\n", recipe.getIngredients() ));



    }
}