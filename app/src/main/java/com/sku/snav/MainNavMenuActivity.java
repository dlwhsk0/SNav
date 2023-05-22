package com.sku.snav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainNavMenuActivity extends AppCompatActivity {

    Button routeBtn, surBtn, favBtn, setBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav_menu);

        routeBtn = (Button) findViewById(R.id.routebtn);
        surBtn = (Button) findViewById(R.id.surbtn);
        favBtn = (Button) findViewById(R.id.favbtn);
        setBtn = (Button) findViewById(R.id.setbtn);

        routeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RouteSearchActivity.class);
                startActivity(intent);
            }
        });

        surBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainNavSurroundActivity.class);
                startActivity(intent);
            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainNavFavoriteActivity.class);
                startActivity(intent);
            }
        });

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}