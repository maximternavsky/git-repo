package com.maximternavsky.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button1;
    private String string = "";
    private String langString = "";
    private MyTask myTask;
    private MainActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button1);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        string = editText.getText().toString();
                        myTask = new MyTask(mainActivity);
                        myTask.execute();
                        break;
                }
            }
        };
        button1.setOnClickListener(onClickListener);
    }

    public void textViewsetText(String begin) {
        textView.setText(begin);
    }

    public String getString() {
        return string;
    }

    public void setLangString(String langString) {
        this.langString = langString;
    }

    public String getLangString() {
        return langString;
    }


//    public class MyTask extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            textView.setText("Begin");
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            String line = null;
//
//            try {
//                // Construct data
//                String data = URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode("en-ru", "UTF-8");
//                data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("trnsl.1.1.20" +
//                        "171003T125746Z.d9d155d60493b199.680f5b1d70acf9618012a2f7c31f40cee1cce4f6", "UTF-8");
//                data += "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(string, "UTF-8");
//                // Send data
//                URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?");
//                URLConnection conn = url.openConnection();
//                conn.setDoOutput(true);
//                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//                wr.write(data);
//                wr.flush();
//
//                // Get the response
//                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                while ((line = rd.readLine()) != null) {
//                    langString = line;
//                }
//                wr.close();
//                rd.close();
//            } catch (Exception e) {
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            textView.setText(langString);
//        }
//    }


}
