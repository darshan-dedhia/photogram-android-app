package com.codepath.darshandedhia.photogram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qLwMZ9hy9uRNqG4c4NZhIEOGGEXiLf8Tp0iOd1GR") // should correspond to Application Id env variable
                .clientKey("pRmTD2CU4FmkEgGBzBdLtIsRHEnw2IsTD1uGpcfs")  // should correspond to Client key env variable
                        .server("https://parseapi.back4app.com").build());
    }
}
