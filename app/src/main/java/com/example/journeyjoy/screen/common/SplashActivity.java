package com.example.journeyjoy.screen.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View rootView = findViewById(android.R.id.content);
        ImageView imageView = findViewById(R.id.planepl);
        EllipseSegmentView pathView = findViewById(R.id.pathView);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int width = rootView.getWidth();
                int height = rootView.getHeight();

                // Calculate parameters based on layout dimensions
                float a = width * 0.58f; // Horizontal radius as
                float b = height * 0.2f; // Vertical radius
                float cx = width * 0.5f; // Center x
                float cy = height * 0.95f; // Center y
                pathView.setOvalBounds(cx - a, cy - b, cx + a, cy + b);
                pathView.animateSweepAngle(-125, 70, 3000);
                // Start animation
                animateAlongEllipse(imageView, a, b, cx, cy, 2800);
            }
        });
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));
            finish();
        }, 3000);
    }
    private void animateAlongEllipse(final ImageView view, final float a, final float b, final float cx, final float cy, long duration) {
        ValueAnimator animator = ValueAnimator.ofFloat(-125, -55);
        animator.setDuration(duration);
        animator.setInterpolator(new LinearInterpolator());

        animator.addUpdateListener(animation -> {
            float angle = (float) animation.getAnimatedValue();
            float radians = (float) Math.toRadians(angle);

            // Calculate the position on the ellipse
            float x = (float) (cx + a * Math.cos(radians));
            float y = (float) (cy + b * Math.sin(radians));

            // Calculate the tangent angle (in degrees)
            float dx = (float) (-a * Math.sin(radians));
            float dy = (float) (b * Math.cos(radians));
            float tangentAngle = (float) Math.toDegrees(Math.atan2(dy, dx));

            // Move and rotate the view
            view.setX(x - view.getWidth() / 2);
            view.setY(y - view.getHeight() / 2);
            view.setRotation(tangentAngle + 45);
        });

        animator.start();
    }
}