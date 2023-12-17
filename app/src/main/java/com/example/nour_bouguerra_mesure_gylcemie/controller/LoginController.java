package com.example.nour_bouguerra_mesure_gylcemie.controller;// LoginController.java

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nour_bouguerra_mesure_gylcemie.model.User;

public class LoginController {
    private static final String USER_PREFS = "USER_PREFS";
    private static final String USER_NAME_KEY = "USER_NAME";
    private static final String PASSWORD_KEY = "PASSWORD";

    private static LoginController instance;
    private User user;

    private LoginController() {
        // Private constructor to enforce Singleton pattern
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    public void createUser(String userName, String password, Context context) {
        user = new User(userName, password);

        // Save user credentials in SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME_KEY, userName);
        editor.putString(PASSWORD_KEY, password);
        editor.apply();
    }

    public void recapUser(Context context) {
        // Retrieve user credentials from SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(USER_NAME_KEY, "");
        String password = sharedPreferences.getString(PASSWORD_KEY, "");

        user = new User(userName, password);
    }
    public boolean isUserCreated() {
        return user != null; // Ou une autre condition appropriée selon votre logique
    }

    public User getUser() {
        return user;
    }
}

