package com.example.root.project;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v("Test","in onstart method");
        Runnable r = new Runnable() {
            @Override
            public void run() {

                Log.v("Test","in run method");
                for(int i = 0; i<5 ;i++){
                    int Final = 1000;
                    while (Final>100){
                        synchronized (this){
                            Final=Final/10;
                            Log.v("Test"," In loop.....");

                            try {
                            wait(5000);
                        }catch(Exception e) {
                            }
                        }
                    }
                }
            }
        };

        Log.v("Test","Creating a thread....");


        Thread thread= new Thread(r);
        thread.start();
        return Service.START_STICKY;


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
