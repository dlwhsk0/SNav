package com.sku.snav;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.skt.Tmap.TMapPoint;

import java.util.ArrayList;

public class LocationSearchActivity extends AppCompatActivity {
    EditText edtAddress;
    RecyclerView recentRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_search);

        recentRecyclerView = findViewById(R.id.recentList);
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        edtAddress = findViewById(R.id.edtAddress);

        ArrayAdapter adapter = new ArrayAdapter(Search.getRecentLocationList());
        recentRecyclerView.setAdapter(adapter);

        edtAddress.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER || i == KeyEvent.KEYCODE_NUMPAD_ENTER) {
                    TMapPoint point = null;
                    try {
                        point = Search.getPointFromAddress(edtAddress.getText().toString());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (point == null) {
                        Toast.makeText(LocationSearchActivity.this, "Location Not Found", Toast.LENGTH_SHORT).show();
                        point = new TMapPoint(37.3793938, 126.9277183);
                    }

                    Intent intent = getIntent();
                    intent.putExtra("lat", point.getLatitude());
                    intent.putExtra("lon", point.getLongitude());
                    setResult(RESULT_OK, intent);
                    finish();
                }
                return false;
            }
        });
    }

    public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> {
        private ArrayList<String> mData = null;

        ArrayAdapter(ArrayList<String> list) {
            mData = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.recent_location_item, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String text = mData.get(position);
            holder.textView1.setText(text);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView1;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = getAdapterPosition();

                        if (pos == RecyclerView.NO_POSITION) {
                            return;
                        }

                        edtAddress.setText(mData.get(pos));
                    }
                });

                textView1 = itemView.findViewById(R.id.text1);
            }
        }
    }
}