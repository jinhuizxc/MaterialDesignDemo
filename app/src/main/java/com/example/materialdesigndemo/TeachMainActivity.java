package com.example.administrator.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/11.
 */
public class TeachMainActivity extends AppCompatActivity {

    @BindView(R.id.iv_teacher_portrait)
    ImageView ivTeacherPortrait;
    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.tv_teacher_mark)
    TextView tvTeacherMark;
    @BindView(R.id.rl_teacher_info)
    RelativeLayout rlTeacherInfo;
    @BindView(R.id.tv_teacher_introduce)
    TextView tvTeacherIntroduce;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.iv_teacher_portrait_toolbar)
    ImageView ivTeacherPortraitToolbar;
    @BindView(R.id.tv_teacher_name_toolbar)
    TextView tvTeacherNameToolbar;
    @BindView(R.id.ll_teacher_info_toolbar)
    LinearLayout llTeacherInfoToolbar;
    @BindView(R.id.focus_view_toolbar)
    TextView focusViewToolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.vp_teacher)
    ViewPager vpTeacher;

    private AppBarLayout.OnOffsetChangedListener offsetChangedListener;
    private boolean showToobarTeacherInfo = false;
    private static final String TAG = "TeachMainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachmain);
        ButterKnife.bind(this);


        // 向上滑动，i的值越大，反之越小；
        offsetChangedListener = new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int top = rlTeacherInfo.getTop();
                int bottom = rlTeacherInfo.getBottom();
                Log.e(TAG, "onOffsetChanged 0: "+ "top = " + top + "," + "bottom = " + bottom);
                //  E/TeachMainActivity: onOffsetChanged 0: top = 135,bottom = 310
                int offset = Math.abs(i);
                Log.e(TAG, "onOffsetChanged 1: " + offset);
                if (offset > bottom) {
                    showToolBarTeacherInfo(true);
                } else if (offset < top) {
                    showToolBarTeacherInfo(false);
                }
            }
        };

        appBarLayout.addOnOffsetChangedListener(offsetChangedListener);

    }

    private void showToolBarTeacherInfo(boolean b) {
        if (b == showToobarTeacherInfo) {
            return;
        }
        llTeacherInfoToolbar.setVisibility(b ? View.VISIBLE : View.GONE);
        focusViewToolbar.setVisibility(b ? View.VISIBLE : View.GONE);
        showToobarTeacherInfo = b;
    }
}
