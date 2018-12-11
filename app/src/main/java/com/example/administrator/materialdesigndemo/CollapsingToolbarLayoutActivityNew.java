package com.example.administrator.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/9.
 * <p>
 * 仅仅测试，设计成项目需要的样子
 */
public class CollapsingToolbarLayoutActivityNew extends AppCompatActivity {

    private static final String TAG = "CollapsingToolbarLayout";

    //    @BindView(R.id.back)
//    ImageView back;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.nestScrollView)
    NestedScrollView nestScrollView;
    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.tv_subscription_title)
    TextView mSubscriptionTitle;
    @BindView(R.id.tv_subscribe)
    TextView tvSubscribe;
    @BindView(R.id.iv_my_yu)
    ImageView ivMyYu;

    private float mSelfHeight = 0;//用以判断是否得到正确的宽高值
    private float mTitleScale;
    private float mSubScribeScale;
    private float mSubScribeScaleX;
    private float mHeadImgScale;
    private float mYuImgScale;
    private float mYuScaleX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_new);
        ButterKnife.bind(this);

        float screenW = getResources().getDisplayMetrics().widthPixels;
        float toolBarHeight = getResources().getDimension(R.dimen.toolbar_height);
        float initHeight = getResources().getDimension(R.dimen.subscription_head);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (mSelfHeight == 0) {
                    mSelfHeight = mSubscriptionTitle.getHeight();
                    float distanceTitle = mSubscriptionTitle.getTop() + (mSelfHeight - toolBarHeight) / 2.0f;
                    float distanceSubscribe = tvSubscribe.getY() + (tvSubscribe.getHeight() - toolBarHeight) / 2.0f;
                    float distanceHeadImg = iv_head.getY() + (iv_head.getHeight() - toolBarHeight) / 2.0f;
                    float distanceYuImg = ivMyYu.getY() + (ivMyYu.getHeight() - toolBarHeight) / 2.0f;
                    Log.e(TAG, "distanceHeadImg 0: "
                            + "iv_head.getY() = " + iv_head.getY()
                    + "iv_head.getHeight() = " + iv_head.getHeight()
                    + "(iv_head.getHeight() - toolBarHeight) / 2.0f = " + (iv_head.getHeight() - toolBarHeight) / 2.0f);
                    Log.e(TAG, "distanceHeadImg 1: " + distanceHeadImg);  // E/CollapsingToolbarLayout: distanceHeadImg 1: -62.5
                    // E/CollapsingToolbarLayout: distanceHeadImg:
                    // iv_head.getY() = 0.0
                    // iv_head.getHeight() = 0
                    // (iv_head.getHeight() - toolBarHeight) / 2.0f = -62.5
                    float distanceSubscribeX = screenW / 2.0f - (tvSubscribe.getWidth() / 2.0f + getResources().getDimension(R.dimen.normal_space));
                    float distanceYuX = screenW / 2.0f - (ivMyYu.getWidth() / 2.0f + getResources().getDimension(R.dimen.normal_space1));
                    mTitleScale = distanceTitle / (initHeight - toolBarHeight);
                    mSubScribeScale = distanceSubscribe / (initHeight - toolBarHeight);
                    mHeadImgScale = distanceHeadImg / (initHeight - toolBarHeight);
                    Log.e(TAG, "mHeadImgScale 0: " + mHeadImgScale);
                    mYuImgScale = distanceYuImg / (initHeight - toolBarHeight);
                    mSubScribeScaleX = distanceSubscribeX / (initHeight - toolBarHeight);
                    mYuScaleX = distanceYuX / (initHeight - toolBarHeight);
                }
                float scale = 1.0f - (-verticalOffset) / (initHeight - toolBarHeight);

                // 设置缩放
//                mHeadImage.setScaleX(scale);
//                mHeadImage.setScaleY(scale);
//                mHeadImage.setTranslationY(mHeadImgScale * verticalOffset);
                // 设置平移
                iv_head.setTranslationX(mSubScribeScaleX * verticalOffset);
                Log.e(TAG, "mHeadImgScale iv_head: " + mSubScribeScaleX * verticalOffset);
                iv_head.setTranslationY(mHeadImgScale * verticalOffset);


                // 设置育图片位置
                ivMyYu.setTranslationX(mYuScaleX * verticalOffset);
                Log.e(TAG, "mHeadImgScale ivMyYu: " + mSubScribeScaleX * verticalOffset);
//                Log.e(TAG, "设置育字 X: " + mSubScribeScaleX * verticalOffset);
                ivMyYu.setTranslationY(mYuImgScale * verticalOffset);

                mSubscriptionTitle.setTranslationY(mTitleScale * verticalOffset);
//                mSubscriptionTitle.setTranslationX(mSubScribeScaleX * verticalOffset);  // 平移到左上角位置
                tvSubscribe.setTranslationY(mSubScribeScale * verticalOffset);
//                tvSubscribe.setTranslationX(-mSubScribeScaleX * verticalOffset);
                tvSubscribe.setTranslationX(mSubScribeScaleX * verticalOffset);


            }
        });

    }

}
