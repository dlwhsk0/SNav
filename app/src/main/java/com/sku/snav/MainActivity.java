package com.sku.snav;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
        //startActivity(intent);
        Toast.makeText(getApplicationContext(),"MainActivity가 실행됨",Toast.LENGTH_SHORT).show();
    }
}