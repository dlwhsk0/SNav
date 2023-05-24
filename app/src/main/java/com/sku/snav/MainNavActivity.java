package com.sku.snav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainNavActivity extends AppCompatActivity {

    Button searchBtn, menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);

        searchBtn = (Button) findViewById(R.id.searchbtn);
        menuBtn = (Button) findViewById(R.id.menubtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainNavSearchActivity.class);
                startActivity(intent);
            }
        });
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainNavMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}