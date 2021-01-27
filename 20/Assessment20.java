package com.sin.buildingInsights.data.repository;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Please add this line in AndroidManifest.xml
 * <uses-permission android:name="android.permission.INTERNET" />
 * Call getTopicCount() on background thread
 */
public class Assessment20 {

    public static int getTopicCount(String topic) {
        int count = 0;
        int lastIndex = 0;

        // sample url: https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=book
        String url = "https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic;
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

            String textHtml = jsonObject.getJSONObject("parse").getString("text");

            while (lastIndex != -1) {
                // find index in text
                lastIndex = textHtml.indexOf(topic, lastIndex);

                if (lastIndex != -1) {
                    count++;
                    lastIndex += topic.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return count;
    }
}
