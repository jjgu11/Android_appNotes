package com.example.asusp.appNot.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asusp.appNot.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    //asignacion de time del splash
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // creamos la tarea
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                //inicializamos
                startActivity(intent);
                //descanza la actividad
                finish();
            }
        };

        //ejecutamos
        Timer timer = new Timer();
        timer.schedule(timerTask,SPLASH_SCREEN_DELAY);

    }
}
