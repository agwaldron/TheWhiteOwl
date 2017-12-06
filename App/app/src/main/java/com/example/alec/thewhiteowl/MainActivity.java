package com.example.alec.thewhiteowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dailySpecialsButton;
    Button foodMenuButton;
    Button beerMenuButton;
    Button directionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dailySpecialsButton = (Button)findViewById(R.id.daily_specials_button);
        dailySpecialsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectDailySpecials();
            }
        });

        foodMenuButton = (Button)findViewById(R.id.food_menu_button);
        foodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectFoodMenu();
            }
        });

        beerMenuButton = (Button)findViewById(R.id.beer_menu_button);
        beerMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectBeerMenu();
            }
        });

        directionsButton = (Button)findViewById(R.id.directions_button);
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectDirections();
            }
        });
    }

    public void redirectDailySpecials(){
        startActivity(new Intent(this, DailySpecialsActivity.class));
    }

    public void redirectFoodMenu(){
        startActivity(new Intent(this, FoodMenuActivity.class));
    }

    public void redirectBeerMenu(){
        startActivity(new Intent(this, BeerMenuActivity.class));
    }

    public void redirectDirections(){
        startActivity(new Intent(this, DirectionsActivity.class));
    }
}
