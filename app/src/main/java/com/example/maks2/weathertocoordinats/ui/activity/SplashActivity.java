package com.example.maks2.weathertocoordinats.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.maks2.weathertocoordinats.ui.BaseActivity;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
        finish();
    }
}
