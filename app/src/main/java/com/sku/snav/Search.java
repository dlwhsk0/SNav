package com.sku.snav;

import android.util.Base64;

import com.skt.Tmap.TMapPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class Search {
    public Search() {
    }

    public static JSONObject getRouteJson(float startX, float startY, float endX, float endY) {
        final JSONObject[] route = new JSONObject[1];
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(String.format(Locale.KOREAN, "http://osm-oracle.kro.kr:8600/%f/%f/%f/%f", startX, startY, endX, endY));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);

                    String result;
                    InputStream is = connection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    while ((result = br.readLine()) != null) {
                        sb.append(result).append("\n");
                    }

                    result = sb.toString();

                    route[0] = new JSONObject(result);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        return route[0];
    }

    public static ArrayList<String> getRecentLocationList() {
        final ArrayList<String> lines = new ArrayList<>();
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://osm-oracle.kro.kr:8600/recent/foo");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);

                    String result;
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    while ((result = br.readLine()) != null) {
                        lines.add(result);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        return lines;
    }

    public static TMapPoint getPointFromAddress(String address) {
        final TMapPoint[] point = new TMapPoint[1];
        point[0] = new TMapPoint(37.3793938, 126.9277183);
        new Thread() {
            @Override
            public void run() {
                try {
                    byte[] bytes = Base64.encode(address.getBytes(), Base64.URL_SAFE);
                    URL url = new URL("http://osm-oracle.kro.kr:8600/geo/" + new String(bytes));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);

                    String result;
                    InputStream is = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    result = br.readLine();
                    String[] arr = result.split(" ");
                    point[0] = new TMapPoint(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        return point[0];
    }

    public static JSONObject getPoiList(String poi_name) {
        final JSONObject[] jsonObjects = new JSONObject[1];
        new Thread() {
            @Override
            public void run() {
                try {
                    byte[] bytes = Base64.encode(poi_name.getBytes(), Base64.URL_SAFE);
                    URL url = new URL(String.format(Locale.KOREAN, "http://osm-oracle.kro.kr:8600/poi/%s", new String(bytes)));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);

                    String result;
                    InputStream is = connection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                    while ((result = br.readLine()) != null) {
                        sb.append(result).append("\n");
                    }

                    result = sb.toString();

                    jsonObjects[0] = new JSONObject(result);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        return jsonObjects[0];
    }
}
