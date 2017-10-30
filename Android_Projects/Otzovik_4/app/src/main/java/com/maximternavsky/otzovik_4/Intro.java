package com.maximternavsky.otzovik_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.maximternavsky.otzovik_4.R.id.rv;

public class Intro extends AppCompatActivity implements View.OnClickListener {

    private List<PlaceList> places;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        setTabLayout();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_tune);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intro.this, NewPlace.class);
                startActivity(intent);

            }
        });

        buttonInit();

        rv=(RecyclerView)findViewById(R.id.rv_favorites);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();

    }

    private void buttonInit() {
        Button btn_all_places = (Button) findViewById(R.id.btn_all_places);
        Button btn_parks = (Button) findViewById(R.id.btn_parks);
        Button btn_cinemas = (Button) findViewById(R.id.btn_cinemas);
        Button btn_cafes = (Button) findViewById(R.id.btn_cafes);
        Button btn_zoos = (Button) findViewById(R.id.btn_zoos);
        Button btn_muzeums = (Button) findViewById(R.id.btn_muzeums);
        Button btn_night_club = (Button) findViewById(R.id.btn_night_club);
        Button btn_theatres = (Button) findViewById(R.id.btn_theatres);
        Button btn_beauty_salons = (Button) findViewById(R.id.btn_beauty_salons);
        Button btn_shopping_and_entertainment_centers_button = (Button) findViewById(R.id.btn_shopping_and_entertainment_centers_button);
        Button btn_circuses = (Button) findViewById(R.id.btn_circuses);

        btn_all_places.setOnClickListener(this);
        btn_parks.setOnClickListener(this);
        btn_cinemas.setOnClickListener(this);
        btn_cafes.setOnClickListener(this);
        btn_zoos.setOnClickListener(this);
        btn_muzeums.setOnClickListener(this);
        btn_night_club.setOnClickListener(this);
        btn_theatres.setOnClickListener(this);
        btn_beauty_salons.setOnClickListener(this);
        btn_shopping_and_entertainment_centers_button.setOnClickListener(this);
        btn_circuses.setOnClickListener(this);
    }

    private void initializeData(){
        places = new ArrayList<>();
        places.add(new PlaceList("Парковъ", "4.2", R.drawable.place1, R.drawable.place1_hq));
        places.add(new PlaceList("Вилки-Палки", "4.6", R.drawable.place2, R.drawable.place2_hq));
        places.add(new PlaceList("ProSushi", "3.8", R.drawable.place3, R.drawable.place3_hq));
        places.add(new PlaceList("Крема", "4.0", R.drawable.place4, R.drawable.place4_hq));
        places.add(new PlaceList("Sushi de Samba", "3.3", R.drawable.place5, R.drawable.place5_hq));
        places.add(new PlaceList("Granata Cafe", "4.1", R.drawable.place6, R.drawable.place6_hq));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(places);
        rv.setAdapter(adapter);
    }

    private void setTabLayout() {
        setTitle("TabHost");

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("Отзывы");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.linearLayout2);
        tabSpec.setIndicator("Избранное");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.linearLayout3);
        tabSpec.setIndicator("Мой кабинет");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_all_places:
                Intent intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_parks:  Toast toast_parks = Toast.makeText(getApplicationContext(), "Parks", Toast.LENGTH_LONG);
                toast_parks.show();
                break;
            case R.id.btn_cinemas:  Toast toast_cinemas = Toast.makeText(getApplicationContext(), "Cinemas", Toast.LENGTH_LONG);
                toast_cinemas.show();
                break;
            case R.id.btn_cafes:  Toast toast_cafes = Toast.makeText(getApplicationContext(), "Cafes", Toast.LENGTH_LONG);
                toast_cafes.show();
                break;
            case R.id.btn_zoos:  Toast toast_zoos = Toast.makeText(getApplicationContext(), "Zoos", Toast.LENGTH_LONG);
                toast_zoos.show();
                break;
            case R.id.btn_muzeums:  Toast toast_muzeums = Toast.makeText(getApplicationContext(), "Muzeums", Toast.LENGTH_LONG);
                toast_muzeums.show();
                break;
            case R.id.btn_night_club:  Toast toast_night_club = Toast.makeText(getApplicationContext(), "Night Club", Toast.LENGTH_LONG);
                toast_night_club.show();
                break;
            case R.id.btn_theatres:  Toast toast_theatres = Toast.makeText(getApplicationContext(), "Theatres", Toast.LENGTH_LONG);
                toast_theatres.show();
                break;
            case R.id.btn_beauty_salons:  Toast toastbeauty_salons = Toast.makeText(getApplicationContext(), "Beauty salons", Toast.LENGTH_LONG);
                toastbeauty_salons.show();
                break;
            case R.id.btn_shopping_and_entertainment_centers_button:  Toast toast_shopping_and_entertainment_centers_button = Toast.makeText(getApplicationContext(), "Shopping and entertainment centers", Toast.LENGTH_LONG);
                toast_shopping_and_entertainment_centers_button.show();
                break;
            case R.id.btn_circuses:  Toast toast_circuses = Toast.makeText(getApplicationContext(), "Circuses", Toast.LENGTH_LONG);
                toast_circuses.show();
                break;

        }
    }
}
