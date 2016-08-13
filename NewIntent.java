package com.example.root.project;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by root on 13/8/16.
 */
public class NewIntent extends IntentService {

    public NewIntent(){
        super(" This is my new Intent service!!!");

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.v("Test ","Intent service has now started !!!");

    }
}
