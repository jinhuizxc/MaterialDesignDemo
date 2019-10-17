package com.example.materialdesigndemo.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.materialdesigndemo.R;

/**
 * MVVM模式的BaseActivity
 * <p>
 * ViewDataBinding 基类
 */
public class MVVMBaseActivity<BV extends ViewDataBinding> extends AppCompatActivity {

    protected BV bindingView; // 布局view


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvmbase);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_mvvmbase, null, false);
    }
}
