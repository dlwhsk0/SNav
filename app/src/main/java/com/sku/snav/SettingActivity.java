package com.sku.snav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SettingActivity extends Activity {

    Button btnProfile, btnNotice, btnSound, btnAlarm, btnTheme, btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnProfile = findViewById(R.id.btnProfile);
        btnSound = findViewById(R.id.btnSound);
        btnAlarm = findViewById(R.id.btnAlarm);
        btnTheme = findViewById(R.id.btnTheme);
        btnCenter = findViewById(R.id.btnCenter);
        btnNotice = findViewById(R.id.btnNotice);

        btnProfile.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "사용자 정보 창으로 이동합니다.", Toast.LENGTH_SHORT).show());

        btnNotice.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "공지사항 창으로 이동합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SettingNoticeActivity.class);
            startActivity(intent);
        });

        btnSound.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "소리 설정 창으로 이동합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SettingSoundActivity.class);
            startActivity(intent);
        });

        btnAlarm.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "시스템 설정 창으로 이동합니다.", Toast.LENGTH_SHORT).show());

        btnTheme.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "테마 설정 창으로 이동합니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SettingThemeActivity.class);
            startActivity(intent);
        });

        btnCenter.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "고객 센터 사이트로 이동합니다.", Toast.LENGTH_SHORT).show());
    }

}