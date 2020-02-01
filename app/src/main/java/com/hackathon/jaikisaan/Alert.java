package com.hackathon.jaikisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Alert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        final TextInputLayout number = findViewById(R.id.confirm);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.conPhone = number.getEditText().getText().toString();
                Toast.makeText(getApplicationContext(), "Subscription started", Toast.LENGTH_SHORT).show();
                Client client = new Client(6,getApplicationContext());
                client.execute();
            }
        });
    }
}
