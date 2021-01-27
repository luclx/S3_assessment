package com.sin.buildingInsights.data.repository;

import android.annotation.SuppressLint;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assessment21 {

    public static List<String> getMovieTitles(String subStr, int page) {
        String baseURL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%s&page=%d";
        @SuppressLint("DefaultLocale")
        String url = String.format(baseURL, subStr, page);

        List<String> result = new ArrayList<>();

        HttpURLConnection connection = null;

        try {
            URL urlRequest = new URL(url);
            connection = (HttpURLConnection) urlRequest.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            Gson gson = new Gson();
            JSONObject jsonObject = gson.fromJson(response.toString(), JSONObject.class);

            // get data list
            JSONArray data = jsonObject.getJSONArray("data");

            // get tittle
            for (int i = 0; i < data.length(); i++) {
                JSONObject element = data.getJSONObject(i);
                result.add(element.getString("Title"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        // sort before return result
        Collections.sort(result);
        return result;
    }
}
