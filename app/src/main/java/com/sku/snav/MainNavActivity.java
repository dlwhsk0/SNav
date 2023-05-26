package com.sku.snav;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.skt.Tmap.TMapGpsManager;
import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;
import com.skt.Tmap.poi_item.TMapPOIItem;

import java.util.ArrayList;

public class MainNavActivity extends AppCompatActivity implements TMapGpsManager.onLocationChangedCallback {
    TMapView tMapView;
    LinearLayout addressLayout, menuLayout, startButton;
    Button btnFindRoad, btnFindSurround, btnFavorite, btnSetting, btnGPSLocation;
    ImageView imgArrow;
    TextView textStart;
    TMapMarkerItem current = new TMapMarkerItem();

    boolean gpsLocation = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);
        tMapView = findViewById(R.id.tmapView);
        addressLayout = findViewById(R.id.addressLayout);
        menuLayout = findViewById(R.id.menuLayout);

        startButton = findViewById(R.id.startButton);
        btnFindRoad = findViewById(R.id.btnFindRoad);
        btnFindSurround = findViewById(R.id.btnFindSurround);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnSetting = findViewById(R.id.btnSetting);
        btnGPSLocation = findViewById(R.id.btnGPSLocation);

        imgArrow = findViewById(R.id.imgArrow);
        textStart = findViewById(R.id.textStart);

        menuLayout.setVisibility(View.GONE);

        tMapView.setSKTMapApiKey("mcV5vicxQs7YutpqqlYYy4nmHDPwSmpbZbuUWcQg");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_circle);
        bitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, true);
        current.setIcon(bitmap);

        tMapView.addMarkerItem("current", current);

        addressLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LocationSearchActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btnGPSLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gpsLocation = true;
            }
        });

        tMapView.setOnClickListenerCallBack(new TMapView.OnClickListenerCallback() {
            @Override
            public boolean onPressEvent(ArrayList<TMapMarkerItem> arrayList, ArrayList<TMapPOIItem> arrayList1, TMapPoint tMapPoint, PointF pointF) {
                gpsLocation = false;
                tMapView.setTrackingMode(false);
                return false;
            }

            @Override
            public boolean onPressUpEvent(ArrayList<TMapMarkerItem> arrayList, ArrayList<TMapPOIItem> arrayList1, TMapPoint tMapPoint, PointF pointF) {
                return false;
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textStart.getVisibility() == View.VISIBLE) {
                    menuLayout.setVisibility(View.VISIBLE);
                    textStart.setVisibility(View.GONE);
                    ViewGroup.LayoutParams params = startButton.getLayoutParams();
                    params.height /= 2;
                    startButton.setLayoutParams(params);
                    imgArrow.setImageResource(R.drawable.arrow_down);
                } else {
                    menuLayout.setVisibility(View.GONE);
                    textStart.setVisibility(View.VISIBLE);
                    ViewGroup.LayoutParams params = startButton.getLayoutParams();
                    params.height *= 2;
                    startButton.setLayoutParams(params);
                    imgArrow.setImageResource(R.drawable.arrow_up);
                }
            }
        });


        TMapGpsManager gps = new TMapGpsManager(this);
        gps.setMinTime(1);
        gps.setMinDistance(1);
        gps.setProvider(TMapGpsManager.GPS_PROVIDER);
        gps.OpenGps();
    }

    @Override
    public void onLocationChange(Location location) {
        current.setTMapPoint(new TMapPoint(location.getLatitude(), location.getLongitude()));
        if (gpsLocation) {
            // GPS 위치로 이동
            tMapView.setLocationPoint(location.getLongitude(), location.getLatitude());
            tMapView.setTrackingMode(true);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (data == null) {
                return;
            }
            double lat = data.getDoubleExtra("lat", 0);
            double lon = data.getDoubleExtra("lon", 0);
            gpsLocation = false;
            tMapView.setCenterPoint(lon, lat, true);
        }
    }
}