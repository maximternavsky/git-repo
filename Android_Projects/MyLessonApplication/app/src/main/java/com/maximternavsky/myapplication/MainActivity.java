package com.maximternavsky.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    private Button button;
    private Spinner spinner;
    private String string = "";
    private String langString = "";
    private MyTask myTask;
    private MainActivity mainActivity = this;
    private int selectedSpinner;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button:
                        string = editText.getText().toString();
                        myTask = new MyTask(mainActivity);
                        myTask.execute();
                        break;
                }
            }
        };
        button.setOnClickListener(onClickListener);
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

    public int getSelectSpinner() {
        selectedSpinner = spinner.getSelectedItemPosition();
        return selectedSpinner;
    }
}
