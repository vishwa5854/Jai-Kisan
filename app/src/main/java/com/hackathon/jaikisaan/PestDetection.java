package com.hackathon.jaikisaan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class PestDetection extends AppCompatActivity {

    final static int READ_REQUEST_CODE = 42;
    TextView op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pest_detection);
        Button filePicker = findViewById(R.id.chooseImage);
        op = findViewById(R.id.outputData);
        filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,READ_REQUEST_CODE);
                Client client = new Client(5,getApplicationContext());
                client.execute();
            }
        });
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            assert data != null;
            Uri uri = data.getData();
            File file = new File(""+uri);
            Data.fileName = file.getName();
            op.setText(Data.fileName);
            while (true){
                if(Data.pestData.compareTo("") != 0){
                    op.setText(Data.pestData);
                    break;
                }
            }
        }
    }
}
