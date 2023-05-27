package com.sku.snav;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class LoginActivity extends Activity {

    private final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.INTERNET,
    };
    ImageButton kakaoBtn, faceBtn, naverBtn, googleBtn, guestBtn;

    public boolean runtimeCheckPermission(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        kakaoBtn = findViewById(R.id.kakaobtn);
        faceBtn = findViewById(R.id.facebookbtn);
        naverBtn = findViewById(R.id.naverbtn);
        googleBtn = findViewById(R.id.googlebtn);
        guestBtn = findViewById(R.id.guestbtn);

        if (!runtimeCheckPermission(this, PERMISSIONS)) {
            requestPermissions(PERMISSIONS, 101);
        }

        kakaoBtn.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "카카오 로그인 성공", Toast.LENGTH_SHORT).show());

        faceBtn.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "페이스북 로그인 성공", Toast.LENGTH_SHORT).show());

        naverBtn.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "네이버 로그인 성공", Toast.LENGTH_SHORT).show());

        googleBtn.setOnClickListener(view -> Toast.makeText(getApplicationContext(), "구글 로그인 성공", Toast.LENGTH_SHORT).show());

        guestBtn.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "게스트로 로그인 성공", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainNavActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            finish();
        }
    }
}