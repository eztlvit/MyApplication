package com.example.eric.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button forceOffline = (Button) findViewById(R.id.force_offline);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcastbestpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
//                sendOrderedBroadcast(intent,null);
//                IntentFilter intentFilter = new IntentFilter();
//                intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE");
//                ForceOfflineReceiver forceOfflineReceiver = new ForceOfflineReceiver();
//                registerReceiver(forceOfflineReceiver,intentFilter);
            }
        });
    }
}
