package com.sku.snav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainNavMenuActivity extends AppCompatActivity {

    Button btnFindRoute, btnFindSurround, btnFavorite, btnSetting, btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav_menu);

        btnFindRoute = findViewById(R.id.btnFindRoute);
        btnFindSurround = findViewById(R.id.btnFindSurround);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnSetting = findViewById(R.id.btnSetting);
        btnReturn = findViewById(R.id.btnReturn);

        btnFindRoute.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RouteSearchActivity.class);
            startActivity(intent);
        });

        btnFindSurround.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainNavSurroundActivity.class);
            startActivity(intent);
        });

        btnFavorite.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainNavFavoriteActivity.class);
            startActivity(intent);
        });

        btnSetting.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(intent);
        });

        btnReturn.setOnClickListener(view -> finish());
    }
}