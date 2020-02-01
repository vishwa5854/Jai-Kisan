package com.hackathon.jaikisaan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class Client extends AsyncTask<Void,Void,Void> {

    private final int REQUEST_CODE;
    @SuppressLint("StaticFieldLeak")
    private
    Context yay;

    Client(int request_code,Context y) {
        this.REQUEST_CODE = request_code;
        this.yay = y;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Socket socket = new Socket("192.168.43.101",5854);

            switch (this.REQUEST_CODE){
                case 1: // login
                    dataExchange(socket);
                    break;
                case 2: // new user
                    dataExchange(socket);
                    break;

                case 3: // get weather info
                    OutputStream outputStream;
                    String data;
                    DataInputStream inputStream;
                    byte[] n;
                    int nn;
                    byte[] lol;
                    outputStream = socket.getOutputStream();
                    data = this.REQUEST_CODE + ",hyderabad" ;

                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream.write(data.getBytes());

                    n = new byte[1];
                    n[0] = (byte) inputStream.read();

                    nn = Integer.parseInt(new String(n));

                    lol = new byte[nn];
                    for (int i = 0; i < nn; i++) {
                        lol[i] = (byte) inputStream.read();
                    }
                    Data.authentication = new String(lol);
                    break;
                case 4:
                    // crop estimate
                    dataExchangeEstimate(socket,true);
                    break;
                case 5:
                    // pest



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void dataExchange(Socket socket) throws IOException {
        OutputStream outputStream;
        String data;
        DataInputStream inputStream;
        byte[] n;
        int nn;
        byte[] lol;
        outputStream = socket.getOutputStream();
        Data.phoneNumber += "\n";

        data = this.REQUEST_CODE + "," + Data.userName + "," + Data.phoneNumber;

        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.write(data.getBytes());

        n = new byte[1];
        n[0] = (byte) inputStream.read();

        nn = Integer.parseInt(new String(n));

        lol = new byte[nn];
        for (int i = 0; i < nn; i++) {
            lol[i] = (byte) inputStream.read();
        }
        Data.authentication = new String(lol);
    }

    private void dataExchangeEstimate(Socket socket,boolean l) throws IOException {
        OutputStream outputStream;
        String data;
        DataInputStream inputStream;
        byte[] n;
        int nn;
        byte[] lol;
        outputStream = socket.getOutputStream();
        if(l) {
            data = this.REQUEST_CODE + "," + Data.cropEstimate;
        }else {
            data = this.REQUEST_CODE + "," + Data.fileName;
        }

        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.write(data.getBytes());

//        n = new byte[1];
//        n[0] = (byte) inputStream.read();
//
//        nn = Integer.parseInt(new String(n));
//
//        lol = new byte[nn];
//        for (int i = 0; i < nn; i++) {
//            lol[i] = (byte) inputStream.read();
//        }
//        Data.authentication = new String(lol);
//        System.out.println(Data.authentication);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if(REQUEST_CODE == 1) {
            if (Data.authentication.compareTo("True") == 0) {
                Toast.makeText(yay, "Login Success", Toast.LENGTH_SHORT).show();
                openWeatherPage();

            } else {
                Toast.makeText(yay, "Login Failed" + Data.authentication, Toast.LENGTH_SHORT).show();
            }
        }
        if(REQUEST_CODE == 2){
            if(Data.authentication.compareTo("0") == 0){
                Toast.makeText(yay, "SignUp Success", Toast.LENGTH_SHORT).show();
                openWeatherPage();
            }
            else {
                Toast.makeText(yay, "SignUp Failed", Toast.LENGTH_SHORT).show();
            }
        }
        if(REQUEST_CODE == 3){
            ImageView imageView = new ImageView(yay);
            TextView textView = new TextView(yay);
            textView.setText(Data.authentication);
            if(Data.authentication.compareTo("mist") == 0 || Data.authentication.compareTo("cloudy") == 0){
                imageView.setImageResource(R.drawable.cloud);
            }
            if(Data.authentication.compareTo("sunny") == 0){
                imageView.setImageResource(R.drawable.sun);
            }
            if(Data.authentication.compareTo("rainy") == 0){
                imageView.setImageResource(R.drawable.rain);
            }
        }
        if(REQUEST_CODE == 5){
            TextView textView = new TextView(yay);
            textView.setText(Data.fileName);
        }
    }

    private void openWeatherPage(){
        Intent intent = new Intent(yay,Weather.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        yay.startActivity(intent);
    }

}

