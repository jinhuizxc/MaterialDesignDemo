package com.example.materialdesigndemo.constraintlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.materialdesigndemo.R;

public class ProgramActivity extends AppCompatActivity {

    private Button mOkBtn;
    private Button mCancelBtn;
    private ConstraintLayout mConstraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_program);

        mConstraintLayout = new ConstraintLayout(this);

        mOkBtn = new Button(this);
        mOkBtn.setId(View.generateViewId());
        mOkBtn.setText("确定");
        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(mConstraintLayout);
            }
        });
        mConstraintLayout.addView(mOkBtn);


        mCancelBtn = new Button(this);
        mCancelBtn.setId(View.generateViewId());
        mCancelBtn.setText("取消");
        mConstraintLayout.addView(mCancelBtn);

        ConstraintSet set = program();
        set.applyTo(mConstraintLayout);
        setContentView(mConstraintLayout);

    }

    /**
     * 添加一个view 至少需指定约束条件和宽高
     */
    private void add(ConstraintLayout layout) {
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);

        Button btn = new Button(this);
        btn.setText("新的button");
        btn.setId(View.generateViewId());
        layout.addView(btn);
        set.connect(btn.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.connect(btn.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(btn.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        set.connect(btn.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        set.constrainWidth(btn.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainHeight(btn.getId(), ConstraintSet.WRAP_CONTENT);

        set.applyTo(layout);
    }

    /**
     * 通过代码创建约束条件
     */
    private ConstraintSet program() {
        ConstraintSet set = new ConstraintSet();
        //int startID, int startSide, int endID, int endSide, int margin
        set.connect(mOkBtn.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, dpToPx(8));
        set.connect(mOkBtn.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, dpToPx(8));
        set.connect(mOkBtn.getId(), ConstraintSet.RIGHT, mCancelBtn.getId(), ConstraintSet.LEFT);
        //限定大小
        set.constrainWidth(mOkBtn.getId(), ConstraintSet.MATCH_CONSTRAINT);
        set.constrainHeight(mOkBtn.getId(), ConstraintSet.WRAP_CONTENT);

        set.connect(mCancelBtn.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, dpToPx(8));
        set.connect(mCancelBtn.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.constrainWidth(mCancelBtn.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainHeight(mCancelBtn.getId(), ConstraintSet.WRAP_CONTENT);
        return set;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }


}
