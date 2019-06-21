package com.sitimaeturoh.kuis2222;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView presentase;
    private int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.progress);
        presentase = findViewById(R.id.persentase);
        progressBar.setProgress(0);

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                presentase.setText(String.valueOf(value)+"%");
                if(value == progressBar.getMax()){
                    Toast.makeText(getApplicationContext(),"Progress Completed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
                value++;
            }
        };

        // Thread untuk updating progress pada ProgressBar di Latar Belakang
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int w=0; w<=progressBar.getMax(); w++){
                        progressBar.setProgress(w); // Memasukan Value pada ProgressBar
                        // Mengirim pesan dari handler, untuk diproses didalam thread
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(100); // Waktu Pending 100ms/0.1 detik
                    }
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        });
        thread.start();


    }
}
