package com.example.journeyjoy.screen.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class EllipseSegmentView extends View {
    private Paint paint;
    private Path path;
    private RectF oval;
    private float sweepAngle;
    private float startAngle;

    public EllipseSegmentView(Context context) {
        super(context);
        init();
    }

    public EllipseSegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EllipseSegmentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(0xFFFFFFFF); // White color
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        path = new Path();
        oval = new RectF();
    }


    public void setOvalBounds(float left, float top, float right, float bottom) {
        oval.set(left, top, right, bottom);
        invalidate();
    }

    public void animateSweepAngle(float startAngle, float endAngle, long duration) {
        this.startAngle = startAngle;

        ValueAnimator animator = ValueAnimator.ofFloat(0, endAngle); // Change endAngle to desired angle
        animator.setDuration(duration); // Duration in milliseconds
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(animation -> {
            sweepAngle = (float) animation.getAnimatedValue();
            invalidate();
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path.addArc(oval, startAngle, sweepAngle);
        canvas.drawPath(path, paint);
    }
}
