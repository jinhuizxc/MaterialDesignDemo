package com.example.materialdesigndemo.constraintlayout;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;

public class MyConstraintLayout2 extends ConstraintLayout {

    public MyConstraintLayout2(Context context) {
        super(context);
    }

    public MyConstraintLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyConstraintLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("test_constraint","onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("test_constraint","onLayout");
    }

}
