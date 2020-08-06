package com.nandom.doctorsappointment.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nandom.doctorsappointment.LoginActivity;
import com.nandom.doctorsappointment.data.User;

/**
 * Created by Belal on 14/04/17.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "iGoTellApp";
    private Gson gson;
    private static final String KEY_USER = "user";


    public SharedPrefManager(Context context) {
        mCtx = context;
        gson = new Gson();
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void setLoggedInUser(User user) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(KEY_USER, gson.toJson(user, new TypeToken<User>() {
            }.getType()));
            editor.apply();
        }
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
        return sharedPreferences.getString(KEY_USER, null) != null;
    }

    public User getLoggedInUser() {
        String value = null;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
        if (preferences != null) {
            value = preferences.getString(KEY_USER, null);
        }
        return value != null ? gson.fromJson(value, new TypeToken<User>() {
        }.getType()) : null;
    }


    public boolean logout() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mCtx);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
        ((Activity) mCtx).finish();
        return true;
    }
}