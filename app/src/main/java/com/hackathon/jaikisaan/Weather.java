package com.hackathon.jaikisaan;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Weather extends AppCompatActivity {


    ImageView op;
    TextView temperature;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hey you", Toast.LENGTH_SHORT).show();
            }
        });
//        op = findViewById(R.id.showOp);
//        temperature = findViewById(R.id.tempDisplay);
//        Client client = new Client(3,getApplicationContext());
//        client.execute();
//        op.setImageResource(R.drawable.cloud);
    }
}
