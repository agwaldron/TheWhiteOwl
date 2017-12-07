package com.example.alec.thewhiteowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DailySpecialsActivity extends AppCompatActivity {
    Button specialsToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_specials);

        specialsToHome = (Button)findViewById(R.id.specials_to_home);
        specialsToHome.setOnClickListener(new View.OnClickListener() {
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
