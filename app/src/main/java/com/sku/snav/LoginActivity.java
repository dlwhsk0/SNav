package com.sku.snav;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

    Button kakaoBtn, faceBtn, naverBtn, googleBtn, guestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        kakaoBtn = (Button) findViewById(R.id.kakaobtn);
        faceBtn = (Button) findViewById(R.id.facebookbtn);
        naverBtn = (Button) findViewById(R.id.naverbtn);
        googleBtn = (Button) findViewById(R.id.googlebtn);
        guestBtn = (Button) findViewById(R.id.guestbtn);

        kakaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"카카오 로그인 성공",Toast.LENGTH_SHORT).show();
            }
        });

        faceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"페이스북 로그인 성공",Toast.LENGTH_SHORT).show();
            }
        });

        naverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"네이버 로그인 성공",Toast.LENGTH_SHORT).show();
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"구글 로그인 성공",Toast.LENGTH_SHORT).show();
            }
        });

        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"게스트로 로그인 성공",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainNavActivity.class);
                startActivity(intent);
            }
        });
    }
}