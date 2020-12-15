package com.toni.notes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.toni.notes.notes.NotesActivity;
import com.toni.notes.utils.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        runSplash();
    }

    private void runSplash() {

        final Runnable splash = new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(SplashActivity.this, NotesActivity.class);
                startActivity(intent);
                finish();
            }
        };

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(splash);
            }
        };

        Timer timer = new Timer();
        int DELAY_TIME = 2000;
        timer.schedule(task, DELAY_TIME);
    }
}
