package com.example.xakgram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    //Initilizes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("CiitXAjB0bUvlX0DDufN6HC1Arj8OkdwLNIPuqGB")
                .clientKey("hCUA0CC2Jyj5fnmfh3uJ2Yvu9IjhgzepsnqlDLGa")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
