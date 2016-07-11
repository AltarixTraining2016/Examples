package me.ilich.helloasync;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ilich on 07.07.16.
 */
public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("MyService", Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
