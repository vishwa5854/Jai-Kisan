package com.hackathon.jaikisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ExistingUser extends AppCompatActivity {


    TextInputLayout userName;
    EditText phone;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_user);
        userName = findViewById(R.id.nameExisting);
        phone = findViewById(R.id.phoneExisting);
        next = findViewById(R.id.login);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.existingUser = getApplicationContext();
                Data.userName = userName.getEditText().getText().toString();
                Data.phoneNumber = phone.getText().toString();
                Client client = new Client(2,getApplicationContext());
                client.execute();
            }
        });

    }

}



