package me.ilich.helloasync;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by ilich on 07.07.16.
 */
public class StrongAsyncTask extends AsyncTask<Void, Void, Void> {

    private final Activity activity;

    public StrongAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 100; i++) {
            if (activity == null) {
                Log.v("Sokolov", i + " null");
            } else {
                Log.v("Sokolov", i + " " + activity.getString(R.string.app_name));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
