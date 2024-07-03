package com.example.journeyjoy.screen.onboarding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class WelcomeViewAdapter extends RecyclerView.Adapter<WelcomeViewAdapter.WelcomeViewHolder> {
    public static class WelcomeViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public WelcomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.onboardingItemImageView);
        }
    }

    int[] idImage = {R.drawable.onboarding1, R.drawable.onboarding2, R.drawable.onboarding3};

    @NonNull
    @Override
    public WelcomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_onboarding, parent, false);
        return new WelcomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WelcomeViewHolder holder, int position) {
        holder.imageView.setImageResource(idImage[position]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
