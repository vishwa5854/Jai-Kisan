package com.hackathon.jaikisaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class NewUser extends AppCompatActivity {

    TextInputLayout userName;
    EditText phone;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        userName = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.userName = userName.getEditText().getText().toString();
                Data.phoneNumber = phone.getText().toString();
                Client client = new Client(2,getApplicationContext());
                client.execute();

            }
        });
    }

    void openWeatherPage(){
        Intent intent = new Intent(this.getApplicationContext(),Weather.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
