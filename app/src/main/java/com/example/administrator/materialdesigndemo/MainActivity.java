package com.example.administrator.materialdesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
 *
 *
 * https://github.com/GitLqr/MaterialDesignDemo
 * Material Design 兼容性控件学习
 *
 * Material Design——控件大汇总(一)
 * https://blog.csdn.net/Fly_li_sir/article/details/79704021
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_toolbar)
    Button btToolbar;
    @BindView(R.id.bt_collapsingToolbarLayout)
    Button btCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_toolbar, R.id.bt_collapsingToolbarLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_toolbar:
                Toast.makeText(this, "toolbar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_collapsingToolbarLayout: // 利用 CollapsingToolbarLayout 完成联动的动画效果
                startActivity(new Intent(this, CollapsingToolbarLayoutActivity.class));
                break;
        }
    }
}
