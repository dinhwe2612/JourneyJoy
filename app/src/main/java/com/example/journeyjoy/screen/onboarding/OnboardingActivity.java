package com.example.journeyjoy.screen.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.WelcomeActivity;

import java.util.Objects;

public class OnboardingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_onboarding);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new WelcomeViewAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int position = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager()))
                        .findFirstVisibleItemPosition();
                View[] line = new View[] {
                        findViewById(R.id.line1),
                        findViewById(R.id.line2),
                        findViewById(R.id.line3)
                };
                for (int i = 0; i < 3; ++i) {
                    line[i].setAlpha(0.3f);
                }
                line[position].setAlpha(1);
            }
        });

        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(v -> {
            int position = ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager()))
                    .findFirstVisibleItemPosition();
            if (position < 2) {
                recyclerView.smoothScrollToPosition(position + 1);
            } else {
                Intent intent = new Intent(OnboardingActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
