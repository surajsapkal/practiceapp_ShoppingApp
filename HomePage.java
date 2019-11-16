package com.example.practiceapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.LayoutInflater;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;


public class HomePage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button b2,b3,b4,b5;

    FlipperLayout flipperLayout;
    FlipperView flipperView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        flipperLayout = findViewById(R.id.flipper_layout);


        b2= findViewById(R.id.btn_2);
        b3= findViewById(R.id.btn_3);
        b4= findViewById(R.id.btn_4);
        b5= findViewById(R.id.btn_5);

        for (int i=0; i<=3; i++){
             flipperView = new FlipperView(getBaseContext());

            switch (i){
                case 0:
                    flipperView.setDescriptionBackgroundDrawable(R.drawable.men_topwear);
                    flipperView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    flipperView.setDescription("Men's Top Wears");
                    break;
                case 1:
                    flipperView.setDescriptionBackgroundDrawable(R.drawable.men_bottomwear);
                    flipperView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    flipperView.setDescription("Men's Bottom Wears");
                    break;
                case 2:
                    flipperView.setDescriptionBackgroundDrawable(R.drawable.men_footwear);
                    flipperView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    flipperView.setDescription("Men's Foot Wears");
                    break;
                case 3:
                    flipperView.setDescriptionBackgroundDrawable(R.drawable.men_watches);
                    flipperView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    flipperView.setDescription("Men's Watches");
                    break;
                case 4:
                    flipperView.setDescriptionBackgroundDrawable(R.drawable.men_grooming);
                    flipperView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
                    flipperView.setDescription("Men's Grooming");
            }

            flipperLayout.addFlipperView(flipperView);

            flipperView.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {

                    //if (flipperView.setDescriptionBackgroundDrawable(R.drawable.men_topwear).equals(R.drawable.men_topwear)){
                      //  Toast.makeText(HomePage.this,"Open",Toast.LENGTH_SHORT).show();
                   // }
                    

                }
            });

        }




    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_men) {
            // Handle the camera action
            Toast.makeText(HomePage.this,"Mens Fashion",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_women) {

            Toast.makeText(HomePage.this,"Womens Fashion",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_kids) {

            Toast.makeText(HomePage.this,"Kids Fashion",Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_kitchen) {

            Toast.makeText(HomePage.this,"Kitchen Utilities",Toast.LENGTH_SHORT).show();


        }else if (id == R.id.nav_furniture){

            Toast.makeText(HomePage.this,"Home Furniture",Toast.LENGTH_SHORT).show();


        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






    public void click_2(View view) {
        Toast.makeText(HomePage.this,"Button 2 Clicked",Toast.LENGTH_SHORT).show();

    }

    public void click_3(View view) {
        Toast.makeText(HomePage.this,"Button 3 Clicked",Toast.LENGTH_SHORT).show();

    }

    public void click_4(View view) {
        Toast.makeText(HomePage.this,"Button 4 Clicked",Toast.LENGTH_SHORT).show();

    }

    public void click_5(View view) {
        Toast.makeText(HomePage.this,"Button 5 Clicked",Toast.LENGTH_SHORT).show();

    }
}
