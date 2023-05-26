package com.sku.snav;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingSoundActivity extends AppCompatActivity {

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_sound);

        backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(view -> finish());
    }
}