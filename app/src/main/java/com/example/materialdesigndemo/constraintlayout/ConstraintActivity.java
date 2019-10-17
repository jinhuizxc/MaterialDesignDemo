package com.example.materialdesigndemo.constraintlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ActivityUtils;
import com.example.materialdesigndemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 代码布局示例
 */
public class ConstraintActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.bt_custom)
    Button btCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.bt_custom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                ActivityUtils.startActivity(ProgramActivity.class);
                break;
            case R.id.bt_custom:
                ActivityUtils.startActivity(CustomConstraintAc.class);
                break;
        }
    }
}
