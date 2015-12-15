package com.example.eric.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.send_notice:
//                NotificationManager manager = (NotificationManager)
//                        getSystemService(NOTIFICATION_SERVICE);
//                Notification notification = new Notification(R.drawable.
//                        ic_launcher, "This is ticker text", System.currentTimeMillis());
//                notification.setLatestEventInfo(this, "This is content title",
//                        "This is content text", null);
//                manager.notify(1, notification);
//                break;
//            default:
//                break;
//        }
        switch (v.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.
                        ic_launcher, "This is ticker text", System.currentTimeMillis());
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent,
                        PendingIntent.FLAG_CANCEL_CURRENT);
                //通知增加声音
                Uri soundUri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
                notification.sound = soundUri;
                //通知增加震動
                long[] vibrates = {0, 1000, 1000, 1000};
                notification.vibrate = vibrates;
                //前置一个LED 灯
                notification.ledARGB = Color.GREEN;
                notification.ledOnMS = 1000;
                notification.ledOffMS = 1000;
                notification.flags = Notification.FLAG_SHOW_LIGHTS;
                //使用本機的默認方式
                //notification.defaults = Notification.DEFAULT_ALL;
                notification.setLatestEventInfo(this, "This is content title",
                        "This is content text", pi);
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
