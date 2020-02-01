package com.hackathon.jaikisaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Weather extends AppCompatActivity {

    Button services;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        services = findViewById(R.id.services);
//        Data.activity = getParent();
//        Client client = new Client(3,getApplicationContext());
//        client.execute();
        ImageView imageView = findViewById(R.id.showOp);
        imageView.setImageResource(R.drawable.sun);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServicesPage();
            }
        });
    }

    void openServicesPage(){
        Intent intent = new Intent(this.getApplicationContext(),Services.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
