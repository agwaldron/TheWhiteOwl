package com.example.alec.thewhiteowl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FoodMenuActivity extends AppCompatActivity {
    Button foodToHome;
    ArrayList<String> namesArray = new ArrayList<String>();
    ArrayList<String> descriptionsArray = new ArrayList<String>();
    ArrayList<String> pricesArray = new ArrayList<String>();
    ArrayList<MenuItem> menuArray = new ArrayList<MenuItem>();
    ListView lstView;
    ArrayAdapter<MenuItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_menu);

        foodToHome = (Button)findViewById(R.id.food_to_home);
        foodToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { redirectHome(); }
        });
        loadNames();
        loadDescriptions();
        loadPrices();
        loadMenu();

        lstView = findViewById(R.id.food_list_view);
        adapter = new MenuAdapter(this, R.layout.menu_item_view, menuArray);
        lstView.setAdapter(adapter);
    }

    public void redirectHome(){
        finish();
        this.overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_right);
    }

    public void loadNames(){
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("MenuNames.txt")));
            while((line = bufferedReader.readLine()) != null){
                namesArray.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error Loading Menu Names", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void loadDescriptions(){
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("MenuDescriptions.txt")));
            while((line = bufferedReader.readLine()) != null){
                descriptionsArray.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error Loading Menu Descriptions", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void loadPrices(){
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("MenuPrices.txt")));
            while((line = bufferedReader.readLine()) != null){
                pricesArray.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Error Loading Menu Prices", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void loadMenu(){
        for(int i=0; i<namesArray.size(); i++){
            menuArray.add(new MenuItem(namesArray.get(i), descriptionsArray.get(i), pricesArray.get(i)));
        }
    }
}
