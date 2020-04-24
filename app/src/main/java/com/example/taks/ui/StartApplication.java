package com.example.taks.ui;

import android.app.Application;
import android.content.SharedPreferences;

public class StartApplication extends Application {
    private static SharedPreferences mSharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = getSharedPreferences("my_pref",0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("login","no");
        editor.commit();


    }
    public static SharedPreferences getSharedPreferences(){
        return mSharedPreferences;
    }
}
