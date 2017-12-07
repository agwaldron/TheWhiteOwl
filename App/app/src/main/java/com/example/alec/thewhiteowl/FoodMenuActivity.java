package com.example.alec.thewhiteowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodMenuActivity extends AppCompatActivity {
    Button foodToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_menu);

        foodToHome = (Button)findViewById(R.id.food_to_home);
        foodToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { redirectHome(); }
        });
    }

    public void redirectHome(){
        finish();
    }
}
