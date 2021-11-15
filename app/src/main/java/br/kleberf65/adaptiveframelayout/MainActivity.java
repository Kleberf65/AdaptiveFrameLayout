package br.kleberf65.adaptiveframelayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.kleberf65.widget.AdaptiveFrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptiveFrameLayout adaptiveFrameLayout = findViewById(R.id.adaptive_frame_layout_by_code);
        adaptiveFrameLayout.setHeightPercentage(45);
        adaptiveFrameLayout.setMatchParent(false);
        adaptiveFrameLayout.setIncrementWidth(10);
        adaptiveFrameLayout.setScreenDivider(2);
        adaptiveFrameLayout.start();
    }
}