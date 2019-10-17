package com.example.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.materialdesigndemo.bottomsheetdialog.ZhiHuAc;
import com.example.materialdesigndemo.constraintlayout.ConstraintActivity;
import com.example.materialdesigndemo.coordinatorlayout.CoordinatorLayoutActivity;
import com.example.materialdesigndemo.example.supportdesign.SupportDesignExampleActivity;
import com.example.materialdesigndemo.revealEffect.RevealEffectAc;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * https://www.jianshu.com/p/1f3974408528
 * CoordinatorLayout，AppBarLayout,CollapsingToolbarLayout和Toolbar的结合表现出的动态效果。
 * <p>
 * https://blog.csdn.net/u012045061/article/details/69568807
 * 利用 CollapsingToolbarLayout 完成联动的动画效果
 * <p>
 * 系列文章，会持续更新此demo
 * <p>
 * <p>
 * https://github.com/GitLqr/MaterialDesignDemo
 * Material Design 兼容性控件学习
 * <p>
 * Material Design——控件大汇总(一)
 * https://blog.csdn.net/Fly_li_sir/article/details/79704021
 * <p>
 * android CoordinatorLayout使用
 * https://blog.csdn.net/xyz_lmn/article/details/48055919
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_toolbar)
    Button btToolbar;
    @BindView(R.id.bt_collapsingToolbarLayout)
    Button btCollapsingToolbarLayout;
    @BindView(R.id.bt_example)
    Button btExample;
    @BindView(R.id.bt_coordinatorLayout)
    Button btCoordinatorLayout;
    @BindView(R.id.bt_appBarLayout)
    Button btAppBarLayout;
    @BindView(R.id.bt_zhihu)
    Button btZhihu;
    @BindView(R.id.bt_constraint)
    Button btConstraint;
    @BindView(R.id.bt_RevealEffect)
    Button btRevealEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_toolbar, R.id.bt_collapsingToolbarLayout, R.id.bt_example,
            R.id.bt_coordinatorLayout, R.id.bt_appBarLayout, R.id.bt_zhihu,
            R.id.bt_constraint, R.id.bt_RevealEffect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_toolbar:
                Toast.makeText(this, "toolbar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_collapsingToolbarLayout:
                // 利用 CollapsingToolbarLayout 完成联动的动画效果
//                startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class));
//                startActivity(new Intent(this, CollapsingToolbarLayoutActivityNew.class));
                startActivity(new Intent(this, TeachMainActivity.class));
                break;
            case R.id.bt_example:
                startActivity(new Intent(this, SupportDesignExampleActivity.class));
                break;
            case R.id.bt_coordinatorLayout:
                startActivity(new Intent(this, CoordinatorLayoutActivity.class));
                break;
            case R.id.bt_appBarLayout:
                break;
            case R.id.bt_zhihu:
                ActivityUtils.startActivity(ZhiHuAc.class);
                break;
            case R.id.bt_constraint:
                ActivityUtils.startActivity(ConstraintActivity.class);
                break;
            case R.id.bt_RevealEffect:
                ActivityUtils.startActivity(RevealEffectAc.class);
                break;
        }
    }

}
