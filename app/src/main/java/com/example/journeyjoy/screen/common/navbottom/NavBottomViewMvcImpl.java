package com.example.journeyjoy.screen.common.navbottom;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class NavBottomViewMvcImpl extends BaseObservableViewMvc<NavBottomViewMvc.Listener>
        implements NavBottomViewMvc{
    private final FrameLayout mFrameLayout;
    private final LinearLayout mHomeLayout;
    private final LinearLayout mBookingLayout;
    private final LinearLayout mNotificationLayout;
    private final LinearLayout mProfileLayout;
    private final ImageView mHomeImageView;
    private final ImageView mBookingImageView;
    private final ImageView mNotificationImageView;
    private final ImageView mProfileImageView;
    private final TextView mHomeTextView;
    private final TextView mBookingTextView;
    private final TextView mNotificationTextView;
    private final TextView mProfileTextView;

    public NavBottomViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_navbottom, parent, false));
        mFrameLayout = findViewById(R.id.frameLayout);

        mHomeLayout = findViewById(R.id.homeLayout);
        mBookingLayout = findViewById(R.id.bookingLayout);
        mNotificationLayout = findViewById(R.id.notificationLayout);
        mProfileLayout = findViewById(R.id.profileLayout);

        mHomeImageView = findViewById(R.id.homeImageView);
        mBookingImageView = findViewById(R.id.bookingImageView);
        mNotificationImageView = findViewById(R.id.notificationImageView);
        mProfileImageView = findViewById(R.id.profileImageView);

        mHomeTextView = findViewById(R.id.homeTextView);
        mBookingTextView = findViewById(R.id.bookingTextView);
        mNotificationTextView = findViewById(R.id.notificationTextView);
        mProfileTextView = findViewById(R.id.profileTextView);

        setBookingUnSelected();
        setNotificationUnSelected();
        setProfileUnSelected();
        setHomeSelected();
        mHomeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBookingUnSelected();
                setNotificationUnSelected();
                setProfileUnSelected();
                setHomeSelected();
                for (Listener listener : getListeners()) {
                    listener.onNavBottomClick(R.id.homeLayout);
                }
            }
        });

        mBookingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHomeUnSelected();
                setNotificationUnSelected();
                setProfileUnSelected();
                setBookingSelected();
                for (Listener listener : getListeners()) {
                    listener.onNavBottomClick(R.id.bookingLayout);
                }
            }
        });

        mNotificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHomeUnSelected();
                setBookingUnSelected();
                setProfileUnSelected();
                setNotificationSelected();
                for (Listener listener : getListeners()) {
                    listener.onNavBottomClick(R.id.notificationLayout);
                }
            }
        });

        mProfileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHomeUnSelected();
                setBookingUnSelected();
                setNotificationUnSelected();
                setProfileSelected();
                for (Listener listener : getListeners()) {
                    listener.onNavBottomClick(R.id.profileLayout);
                }
            }
        });
    }

    void setHomeSelected() {
        mHomeTextView.setVisibility(View.VISIBLE);
        mHomeLayout.setBackgroundResource(R.drawable.round_back_100);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        mHomeLayout.startAnimation(scaleAnimation);
    }

    void setBookingSelected() {
        mBookingTextView.setVisibility(View.VISIBLE);
        mBookingLayout.setBackgroundResource(R.drawable.round_back_100);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        mBookingLayout.startAnimation(scaleAnimation);
    }

    void setNotificationSelected() {
        mNotificationTextView.setVisibility(View.VISIBLE);
        mNotificationLayout.setBackgroundResource(R.drawable.round_back_100);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        mNotificationLayout.startAnimation(scaleAnimation);
    }

    void setProfileSelected() {
        mProfileTextView.setVisibility(View.VISIBLE);
        mProfileLayout.setBackgroundResource(R.drawable.round_back_100);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setFillAfter(true);
        mProfileLayout.startAnimation(scaleAnimation);
    }

    void setHomeUnSelected() {
        mHomeTextView.setVisibility(View.GONE);
        mHomeLayout.setBackgroundResource(0);
    }

    void setBookingUnSelected() {
        mBookingTextView.setVisibility(View.GONE);
        mBookingLayout.setBackgroundResource(0);
    }

    void setNotificationUnSelected() {
        mNotificationTextView.setVisibility(View.GONE);
        mNotificationLayout.setBackgroundResource(0);
    }

    void setProfileUnSelected() {
        mProfileTextView.setVisibility(View.GONE);
        mProfileLayout.setBackgroundResource(0);
    }


    @Override
    public FrameLayout getFragmentFrame() {
        return mFrameLayout;
    }
}
