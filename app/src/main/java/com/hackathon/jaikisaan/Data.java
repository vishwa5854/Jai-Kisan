package com.hackathon.jaikisaan;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

class Data {

    static String userName;
    static String phoneNumber;
    static int landAreaInHectares;
    static String authentication = "";
    @SuppressLint("StaticFieldLeak")
    static Context existingUser;
    @SuppressLint("StaticFieldLeak")
    static Activity activity;

    static int cropEstimate;
    static String fileName;

}
