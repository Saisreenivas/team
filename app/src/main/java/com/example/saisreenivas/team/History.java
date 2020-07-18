package com.example.saisreenivas.team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_history);
        layout.addView(textView);

        DBHandler db = new DBHandler(this);

// Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new QRData("Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addShop(new QRData("Dunkin Donuts", "White Plains, NY 10601"));
        db.addShop(new QRData("Pizza Porlar", "North West Avenue, Boston , USA"));
        db.addShop(new QRData("Town Bakers", "Beverly Hills, CA 90210, USA"));

// Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<QRData> shops = db.getAllShops();

        for (QRData shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
// Writing shops to log
            Log.d("QRData: : ", log);
        }

    }


}
