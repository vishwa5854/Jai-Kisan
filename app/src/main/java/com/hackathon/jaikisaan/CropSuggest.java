package com.hackathon.jaikisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class CropSuggest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_suggest);
        final TextInputLayout budget = findViewById(R.id.budget);
        final TextInputLayout farmArea = findViewById(R.id.farm);
        final TextView op= findViewById(R.id.output);
        Button estimate = findViewById(R.id.estimate);
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = budget.getEditText().getText().toString();
                String f = farmArea.getEditText().getText().toString();
                Data.cropEstimate =  Integer.parseInt(b) / Integer.parseInt(f) ;
                Client client = new Client(4,getApplicationContext());
                client.execute();
                while(true) {
                    op.setText(Data.authentication);
                    if(Data.authentication.compareTo("") != 0){
                        op.setText(Data.authentication);
                        break;
                    }
                }
            }
        });
    }
}
