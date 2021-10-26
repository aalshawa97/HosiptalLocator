package com.example.hospitalfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hospitalfinder.MapsActivity;
import com.example.hospitalfinder.R;
import java.util.Timer;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Loading", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_async);
        mProgressBar = findViewById(R.id.progressBar);

        downloadMap();
/*
        new Timer("SettingUp", false).schedule(3000) {
            Intent myIntent = Intent(this, com.example.hospitalfinder.MapsActivity);
            this@HomeActivity.startActivity(myIntent);
        }
        */
    }

    public void downloadMap() {
        String mapUrl = "https://coronavirus.jhu.edu/map.html";
        if(mProgressBar != null)
        {
            DownloadTask downloadTask = new DownloadTask(mProgressBar);
            downloadTask.execute(mapUrl);
        }

    }

    public void downloadMap(View view) {
        String mapUrl = "https://coronavirus.jhu.edu/map.html";
        if(mProgressBar != null)
        {
            DownloadTask downloadTask = new DownloadTask(mProgressBar);
            downloadTask.execute(mapUrl);
        }

    }
}