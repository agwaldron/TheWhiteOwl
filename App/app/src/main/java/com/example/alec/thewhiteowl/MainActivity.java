package com.example.alec.thewhiteowl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView nameText;
    TextView announcementText;
    Button dailySpecialsButton;
    Button foodMenuButton;
    Button beerMenuButton;
    Button directionsButton;
    TextView contactText;
    TextView visitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (TextView)findViewById(R.id.name_text);
        nameText.setTextColor(getResources().getColor(R.color.colorLight, null));

        announcementText = (TextView)findViewById(R.id.announcement_text);
        announcementText.setTextColor(getResources().getColor(R.color.colorAnnouncement, null));

        dailySpecialsButton = (Button)findViewById(R.id.daily_specials_button);
        dailySpecialsButton.setTextColor(getResources().getColor(R.color.colorDark, null));
        dailySpecialsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectDailySpecials();
            }
        });

        foodMenuButton = (Button)findViewById(R.id.food_menu_button);
        foodMenuButton.setTextColor(getResources().getColor(R.color.colorDark, null));
        foodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectFoodMenu();
            }
        });

        beerMenuButton = (Button)findViewById(R.id.beer_menu_button);
        beerMenuButton.setTextColor(getResources().getColor(R.color.colorDark, null));
        beerMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectBeerMenu();
            }
        });

        directionsButton = (Button)findViewById(R.id.directions_button);
        directionsButton.setTextColor(getResources().getColor(R.color.colorDark, null));
        directionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectDirections();
            }
        });

        contactText = (TextView)findViewById(R.id.contact_text);
        contactText.setTextColor(getResources().getColor(R.color.colorLight, null));

        visitText = (TextView)findViewById(R.id.visit_text);
        visitText.setTextColor(getResources().getColor(R.color.colorLight, null));
    }

    public void redirectDailySpecials(){
        startActivity(new Intent(this, DailySpecialsActivity.class));
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }

    public void redirectFoodMenu(){
        startActivity(new Intent(this, FoodMenuActivity.class));
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }

    public void redirectBeerMenu(){
        startActivity(new Intent(this, BeerMenuActivity.class));
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }

    public void redirectDirections(){
        startActivity(new Intent(this, DirectionsActivity.class));
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
    }
}
