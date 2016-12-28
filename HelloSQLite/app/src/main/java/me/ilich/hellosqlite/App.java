package me.ilich.hellosqlite;

import android.app.Application;
import android.content.ContextWrapper;

import java.io.File;

/**
 * Created by ilich on 27.12.16.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OpenHelper.init(new ContextWrapper(this){
            @Override
            public File getDatabasePath(String name) {
                return super.getDatabasePath(name);
            }
        });

    }
}
