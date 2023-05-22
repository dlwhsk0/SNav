package com.sku.snav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingActivity extends Activity {

    Button profileBtn, noticeBtn, soundBtn, alarmBtn, themeBtn, centerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        profileBtn = (Button) findViewById(R.id.profilebtn);
        noticeBtn = (Button) findViewById(R.id.noticebtn);
        soundBtn = (Button) findViewById(R.id.soundbtn);
        alarmBtn = (Button) findViewById(R.id.alarmbtn);
        themeBtn = (Button) findViewById(R.id.themebtn);
        centerBtn = (Button) findViewById(R.id.centerbtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"사용자 정보 창으로 이동합니다.",Toast.LENGTH_SHORT).show();
            }
        });

        noticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"공지사항 창으로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SettingNoticeActivity.class);
                startActivity(intent);
            }
        });

        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"소리 설정 창으로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SettingSoundActivity.class);
                startActivity(intent);
            }
        });

        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"시스템 설정 창으로 이동합니다.",Toast.LENGTH_SHORT).show();
            }
        });

        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"테마 설정 창으로 이동합니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SettingThemeActivity.class);
                startActivity(intent);
            }
        });

        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"고객 센터 사이트로 이동합니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }

}