package com.sku.snav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RouteSearchActivity extends AppCompatActivity {

    Button resultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_search);

        resultBtn = findViewById(R.id.btn1);
        resultBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RouteSearchResultActivity.class);
            startActivity(intent);
        });
    }
}