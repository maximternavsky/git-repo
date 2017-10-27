package com.maximternavsky.otzovik_4;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;


public class PlaceDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.BLACK);

        //Включаем кнопку назад в Toolbar'e
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Изменяем цвет кнопки назад
        final Drawable upArrow = getResources().getDrawable(R.drawable.back_button_image);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlue), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        int filelist = (Integer) getIntent().getSerializableExtra("FILES_LIST");
        ImageView image = (ImageView) findViewById(R.id.imageViewDescription);
        System.out.println(filelist);
        image.setImageResource(filelist);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }  else if (id == R.id.action_rate) {
            Toast toast = Toast.makeText(getApplicationContext(), "Добавлено в избранное", Toast.LENGTH_LONG);
            toast.show();
        } else if (id == R.id.action_share) {
            Toast toast = Toast.makeText(getApplicationContext(), "Поделиться", Toast.LENGTH_LONG);
            toast.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_place_description, menu);


        return true;
    }

}
