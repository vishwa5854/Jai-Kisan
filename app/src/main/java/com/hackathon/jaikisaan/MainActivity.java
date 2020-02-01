package com.hackathon.jaikisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newUser;
    Button existingUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newUser = findViewById(R.id.newUser);
        existingUser = findViewById(R.id.existingUser);

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });

        existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInPage();
            }
        });
    }


    void openSignUpPage(){
        Intent intent = new Intent(this.getApplicationContext(),NewUser.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    void openSignInPage(){
        Intent intent = new Intent(this.getApplicationContext(),ExistingUser.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
