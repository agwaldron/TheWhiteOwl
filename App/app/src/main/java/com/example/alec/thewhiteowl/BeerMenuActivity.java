package com.example.alec.thewhiteowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeerMenuActivity extends AppCompatActivity {
    Button beerToHome;

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
    }

    public void redirectHome(){
        finish();
    }
}
