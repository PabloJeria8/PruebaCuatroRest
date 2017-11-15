package com.example.pablojeria.pruebacuatrorest.views;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.example.pablojeria.pruebacuatrorest.R;


public class FullscreenActivity extends AppCompatActivity  {

    private IntentFilter intentFilter;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        //new Signin(FullscreenActivity.this).toServer();
        startActivity(new Intent(FullscreenActivity.this, MainActivity.class));

//        intentFilter =  new IntentFilter();
//        intentFilter.addAction(RecentRestaurantService.RESTAURANTS_FINISHED);
//        broadcastReceiver =  new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//
//                String action = intent.getAction();
//
//                if (RecentRestaurantService.RESTAURANTS_FINISHED.equals(action))
//                {
//                    startActivity(new Intent(FullscreenActivity.this, MainActivity.class));
//                }
//            }
//        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

//    @Override
//    public void success() {
//        RecentRestaurantService.startActionRecentRestaurants(this);
//
//    }

}
