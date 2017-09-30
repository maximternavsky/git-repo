package com.maximternavsky.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonListener(View view) {
        this.i++;
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Hello!" + this.i);
    }
}
