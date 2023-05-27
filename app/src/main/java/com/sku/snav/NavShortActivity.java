package com.sku.snav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NavShortActivity extends AppCompatActivity {

    Button detailNavBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_short);

        detailNavBtn = findViewById(R.id.btnDetail);
        detailNavBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), NavDetailedActivity.class);
            startActivity(intent);
        });
    }
}