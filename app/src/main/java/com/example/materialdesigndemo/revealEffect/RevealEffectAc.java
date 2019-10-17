package com.example.materialdesigndemo.revealEffect;

import android.animation.Animator;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.example.materialdesigndemo.R;
import com.example.materialdesigndemo.databinding.ActivityRevealEffectBinding;

/**
 * 揭示效果
 * extends MVVMBaseActivity<ActivityRevealEffectBinding>
 * <p>
 * ViewAnimationUtils 动画类
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RevealEffectAc extends AppCompatActivity implements View.OnClickListener {

    private ActivityRevealEffectBinding bindingView;
    // 抽象类Animator
    private Animator animator;
    private boolean isFirst = true;
    private float width;
    private float height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_reveal_effect);

//        bindingView = DataBindingUtil.inflate(LayoutInflater.from(this),
//                R.layout.activity_reveal_effect, null, false);

        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_reveal_effect);
        getPiexels();
        setTitle("Reveal Effect|揭示效果");
        bindingView.btnRevealeffect.setOnClickListener(this);

    }

    private void getPiexels() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // 屏幕宽度（像素）
        width = displayMetrics.widthPixels;
        // 屏幕高度（像素）
        height = displayMetrics.heightPixels;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_revealeffect:
                if (isFirst) {
                    isFirst = false;
                    animator = ViewAnimationUtils.createCircularReveal(bindingView.ivImg,
                            (int) width / 2,
                            (int) height / 2,
                            0,
                            height);

                } else {
                    isFirst = true;
                    animator = ViewAnimationUtils.createCircularReveal(bindingView.ivImg,
                            0,
                            0,
                            height,
                            0);
                }
                // 对动画进行监听
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (!isFirst) {
                            bindingView.ivImg.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (isFirst) {
                            bindingView.ivImg.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.setDuration(500);
                animator.start();
                break;
        }

    }
}
