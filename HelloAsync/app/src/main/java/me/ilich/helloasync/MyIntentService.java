package me.ilich.helloasync;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ilich on 07.07.16.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v("MyService", Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            Intent intent1 = new Intent("MyAction");
            intent1.putExtra("i", i);
            sendBroadcast(intent1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
