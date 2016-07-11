package me.ilich.helloasync;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.SoftReference;

/**
 * Created by ilich on 07.07.16.
 */
public class SoftAsyncTask extends AsyncTask<Void, Void, Void> {

    private final SoftReference<Activity> activity;

    public SoftAsyncTask(Activity activity) {
        this.activity = new SoftReference<>(activity);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i < 100; i++) {
            if(isCancelled()){
                Log.v("Sokolov", "canceled!");
                //break;
            }
            if (activity.get() == null) {
                Log.v("Sokolov", i + " null");
            } else {
                Log.v("Sokolov", i + " " + activity.get().getString(R.string.app_name));
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.v("Sokolov", "canceled");
    }

}
