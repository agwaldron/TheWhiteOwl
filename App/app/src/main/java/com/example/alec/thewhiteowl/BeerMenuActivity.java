package com.example.alec.thewhiteowl;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BeerMenuActivity extends AppCompatActivity {
    Button beerToHome;
    ArrayList<String> beersArray = new ArrayList<String>();
    ListView lstView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_menu);

        beerToHome = (Button)findViewById(R.id.beers_to_home);
        beerToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectHome();
            }
        });
        loadBeers();
        lstView = findViewById(R.id.on_tap_list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, beersArray);
        lstView.setAdapter(adapter);

    }

    public void redirectHome(){
        finish();
        this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    public void loadBeers(){
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("BeersOnTap.txt")));
            while((line = bufferedReader.readLine()) != null){
                beersArray.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error Loading Beers on Tap", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
