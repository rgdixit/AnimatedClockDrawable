package com.example.rgdixit.animatedclock;

import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimatedClockActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimatedVectorDrawableCompat animatedClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_clock);
        ImageView animatedClockView = (ImageView) findViewById(R.id.img_clock);

        // Creating though compat library
        animatedClock = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_clock_rotate);
        animatedClockView.setImageDrawable(animatedClock);

        Button startStopAnimation = (Button) findViewById(R.id.start_animation);
        startStopAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String buttonText;
        if (animatedClock.isRunning()) {
            animatedClock.stop();
            buttonText = getString(R.string.start);
        } else {
            animatedClock.start();
            buttonText = getString(R.string.stop);
        }
        button.setText(buttonText);
    }
}
