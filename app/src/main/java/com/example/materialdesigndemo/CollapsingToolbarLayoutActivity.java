package com.example.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.materialdesigndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/9.
 * <p>
 * https://blog.csdn.net/u012045061/article/details/69568807
 * 利用 CollapsingToolbarLayout 完成联动的动画效果
 * <p>
 * 最初的想法是自己去利用 Android 的嵌套滚动机制,去实现上面的嵌套滚动效果.但最后为了开发效率直接利用了 CollapsingToolbarLayout 和 CoordinatorLayout 的效果.
 * 实现效果的原理十分简单,监听 CollapsingToolbarLayout 收缩和扩展的距离,换算成你想要的一个范围比如移动的距离,缩放的比例.
 * ---------------------
 * 作者：夏洛克的猫
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u012045061/article/details/69568807
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * <p>
 * 代码其实没啥可说的,主要是一些距离的计算,主要就是顶在最上方时,文字都到了居中的位置.大家在图中画出开始和结束的位置,都能计算出来.
 * <p>
 * 有一点提一下,最初我是把布局嵌入到 CollapsingToolbarLayout 中去的,但是由于 CollapsingToolbarLayout
 * 自身的收缩和扩展改变了自身高度,会影响里面的 View 的位置,如果按照静态的起始和结束位置计算,加上自身高度对 View 布局的影响,
 * 这就复杂了,我没有细研究.采用了一个笨拙的方式,用 FrameLayout 把布局给抽取到顶部,不让他们受到 CollapsingToolbarLayout 的影响.
 *
 *
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.nestScrollView)
    NestedScrollView nestScrollView;
    @BindView(R.id.iv_head)
    ImageView mHeadImage;
    @BindView(R.id.tv_subscription_title)
    TextView mSubscriptionTitle;
    @BindView(R.id.tv_subscribe)
    TextView tvSubscribe;

    private float mSelfHeight = 0;//用以判断是否得到正确的宽高值
    private float mTitleScale;
    private float mSubScribeScale;
    private float mSubScribeScaleX;
    private float mHeadImgScale;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
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
                    float distanceHeadImg = mHeadImage.getY() + (mHeadImage.getHeight() - toolBarHeight) / 2.0f;
                    float distanceSubscribeX = screenW / 2.0f - (tvSubscribe.getWidth() / 2.0f + getResources().getDimension(R.dimen.normal_space));
                    mTitleScale = distanceTitle / (initHeight - toolBarHeight);
                    mSubScribeScale = distanceSubscribe / (initHeight - toolBarHeight);
                    mHeadImgScale = distanceHeadImg / (initHeight - toolBarHeight);
                    mSubScribeScaleX = distanceSubscribeX / (initHeight - toolBarHeight);
                }
                float scale = 1.0f - (-verticalOffset) / (initHeight - toolBarHeight);
                mHeadImage.setScaleX(scale);
                mHeadImage.setScaleY(scale);
                mHeadImage.setTranslationY(mHeadImgScale * verticalOffset);
                mSubscriptionTitle.setTranslationY(mTitleScale * verticalOffset);
//                mSubscriptionTitle.setTranslationX(mSubScribeScaleX * verticalOffset);  // 平移到左上角位置
                tvSubscribe.setTranslationY(mSubScribeScale * verticalOffset);
                tvSubscribe.setTranslationX(-mSubScribeScaleX * verticalOffset);


            }
        });


    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        this.finish();
    }
}
