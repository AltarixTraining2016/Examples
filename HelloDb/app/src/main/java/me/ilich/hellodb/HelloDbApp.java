package me.ilich.hellodb;

import android.app.Application;

/**
 * Created by ilich on 30.06.16.
 */
public class HelloDbApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(getApplicationContext());
    }

}
