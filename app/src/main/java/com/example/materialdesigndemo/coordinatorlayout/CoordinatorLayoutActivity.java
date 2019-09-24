package com.example.materialdesigndemo.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.materialdesigndemo.R;

/**
 * CoordinatorLayout
 *
 *     scroll: 所有想滚动出屏幕的view都需要设置这个flag， 没有设置这个flag的view将被固定在屏幕顶部。例如，TabLayout 没有设置这个值，将会停留在屏幕顶部。
 *     enterAlways: 设置这个flag时，向下的滚动都会导致该view变为可见，启用快速“返回模式”。
 *     enterAlwaysCollapsed: 当你的视图已经设置minHeight属性又使用此标志时，你的视图只能已最小高度进入，只有当滚动视图到达顶部时才扩大到完整高度。
 *     exitUntilCollapsed: 滚动退出屏幕，最后折叠在顶端。
 *
 * 为了ToolBar可以滚动，CoordinatorLayout里面,放一个带有可滚动的View.如上的例子,放的是ViewPager,而ViewPager里面是放了RecylerView的,即是可以滚动的View。CoordinatorLayout包含的子视图中带有滚动属性的View需要设置app:layout_behavior属性。例如，示例中Viewpager设置了此属性。
 *
 * app:layout_behavior="@string/appbar_scrolling_view_behavior"
 *
 *     1
 *
 *     为了使得Toolbar有滑动效果，必须做到如下三点:
 *     1. CoordinatorLayout作为布局的父布局容器。
 *     2. 给需要滑动的组件设置 app:layout_scrollFlags=”scroll|enterAlways” 属性。
 *     3. 给滑动的组件设置app:layout_behavior属性
 *
 */
public class CoordinatorLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "我是Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件

                            }
                        })
                        .show();
            }
        });
    }
}
