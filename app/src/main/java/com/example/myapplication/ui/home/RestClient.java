package com.example.myapplication.ui.home;

import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestClient {
    private static final String URL_FOOD = "http://food02-env.eba-9dntweqm.us-east-1.elasticbeanstalk.com:2005/api/v1/recipe/search";


    public ExampleItem[] getRecipes(int limit) {
        Intent intent = new Intent();
        int maxSum = intent.getIntExtra(SettingsActivity.USER_MAX_SUM_ID, 1500);
        int minSum = intent.getIntExtra(SettingsActivity.USER_MAX_SUM_ID, 1500);
        String skill = intent.getStringExtra(SettingsActivity.USER_SKILL_LEVEL_ID);
        SkillLevel sl = skill == null ? SkillLevel.PROFI : SkillLevel.valueOf(skill);
        int maxTime = intent.getIntExtra(SettingsActivity.USER_TIME_LIMIT_LEVEL, 120);
//       int maxSum= 160;
//        SkillLevel sl = SkillLevel.CAN_COOK_PIE;
//        int maxTime = 40;

        List<ExampleItem> result = new ArrayList<>();
        try {
            String url = URL_FOOD + "?skillsLevel=" + sl.toString() + "&priceMax=" + String.valueOf(maxSum) + "&timeToCook=" + String.valueOf(maxTime) + "&limit=" + String.valueOf(limit);
            Log.i("wefwefwef", url);
            URL githubEndpoint = new URL(url);
            HttpURLConnection myConnection =
                    (HttpURLConnection) githubEndpoint.openConnection();
//            myConnection.setRequestProperty("skillsLevel", sl.toString());
//            myConnection.setRequestProperty("priceMax", String.valueOf(maxSum));
//            myConnection.setRequestProperty("timeToCook", String.valueOf(maxTime));
//            myConnection.setRequestProperty("limit", String.valueOf(limit));
            myConnection.setRequestMethod("GET");


            Log.i("efwef", myConnection.getURL() + "   " + myConnection.getRequestProperties().toString());

            InputStream responseBody = myConnection.getInputStream();

            InputStreamReader responseBodyReader =
                    new InputStreamReader(responseBody, "UTF-8");

            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(responseBodyReader);

            Response[] responses = gson.fromJson(reader, Response[].class);
            for (Response re : responses) {
                Log.i("response: ", String.valueOf(re));
            }


            for (Response re : responses) {
                List<ExampleItem.Step> finalSteps = new ArrayList<>();
                for (Step st : re.steps) {
                    finalSteps.add(new ExampleItem.Step(st.description, st.imageLink.equals("noImage") ? null : st.imageLink));
                }
                result.add(new ExampleItem(re.imageLink, re.title, "Приблизительная цена: " + re.stats.estimatedPriceMax + "₽", re.id, re.ingredients.toArray(new String[0]), finalSteps.toArray(new ExampleItem.Step[0])));
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed connection", e);
        }

        return result.toArray(new ExampleItem[0]);
    }

    private class Step {
        int stepOrderNumber;
        String imageLink;
        String description;
    }

    private class Stats {
        String id;
        Double estimatedPriceMin;
        Double estimatedPriceMax;
        int estimatedCalories;
        int estimatedTimeInMinutes;
        String estimatedSkillsLevel;
    }

    private class Response {

        Stats stats;
        String id;
        String title;
        String url;
        String imageLink;
        List<String> ingredients;
        List<Step> steps;

        @Override
        public String toString() {
            return "Response{" +
                    "stats=" + stats +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", imageLink='" + imageLink + '\'' +
                    ", ingredients=" + ingredients +
                    ", steps=" + steps +
                    '}';
        }
    }
}
