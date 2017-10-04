package com.maximternavsky.myapplication;

import android.os.AsyncTask;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MyTask extends AsyncTask<Void, Void, Void> {

    MainActivity mainActivity;

    MyTask (MainActivity mainActivity) {
        this.mainActivity = (MainActivity) mainActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        mainActivity.textViewsetText("Begin");

    }

    @Override
    protected Void doInBackground(Void... voids) {
        String line = null;

        try {
            // Construct data
            String data = URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode("en-ru", "UTF-8");
            data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("trnsl.1.1.20" +
                    "171003T125746Z.d9d155d60493b199.680f5b1d70acf9618012a2f7c31f40cee1cce4f6", "UTF-8");
            data += "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(mainActivity.getString(), "UTF-8");
            // Send data
            URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                mainActivity.setLangString(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mainActivity.textViewsetText(mainActivity.getLangString());
    }
}
