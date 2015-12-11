package com.example.eric.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Eric on 2015/12/11.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}