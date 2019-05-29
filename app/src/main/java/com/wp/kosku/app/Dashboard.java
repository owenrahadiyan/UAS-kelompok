package com.wp.kosku.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    ImageView imgSewa, imgAbout, imgInfo, imgRating;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        imgSewa = (ImageView) findViewById(R.id.imgSewa);
        imgAbout = (ImageView) findViewById(R.id.imgAbout);
        imgInfo = (ImageView) findViewById(R.id.imgInfo);
        imgRating = (ImageView) findViewById(R.id.imgRating);


        imgSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this,ActivityCRUDMain.class);
                startActivity(a);
            }
        });

        imgAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this,About.class);
                startActivity(a);
            }
        });

        imgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this,Info.class);
                startActivity(a);
            }
        });

        imgRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Dashboard.this,Rating.class);
                startActivity(a);
            }
        });

    }
}
