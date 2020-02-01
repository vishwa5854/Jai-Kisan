package com.hackathon.jaikisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Button cropSuggest = findViewById(R.id.cropsuggest);
        Button pestDetection = findViewById(R.id.pestprediction);
        pestDetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneAnotherPage();
            }
        });
        cropSuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnotherPage();
            }
        });
    }

    void openAnotherPage(){
        Intent intent = new Intent(this.getApplicationContext(),CropSuggest.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    void openOneAnotherPage(){
        Intent intent = new Intent(this.getApplicationContext(),PestDetection.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
