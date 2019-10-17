package com.example.materialdesigndemo.bottomsheetdialog;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.example.materialdesigndemo.R;
import com.example.materialdesigndemo.bottomsheetdialog.icloud.BottomSheetDialogListView;
import com.example.materialdesigndemo.bottomsheetdialog.icloud.SpringBackBottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * BottomSheetDialog
 * <p>
 * Android Support Library 23.2里的 Design Support Library新加了一个Bottom Sheets控件,Bottom Sheets顾名思义就是底部操作控件，
 * 用于在屏幕底部创建一个可滑动关闭的视图，可以替代对话框和菜单。其中包含BottomSheets、BottomSheetDialog和BottomSheetDialogFragment三种可以使用。
 * 其中应用较多的控件是BottomSheetDialog，主要运用在界面底部分享列表，评论列表等，最近在知乎评论列表界面看到知乎运用到了这个效果，
 * 所有在这里详细介绍一下该控件的使用，以及简单实现知乎评论列表功能。本文实现效果如下：
 * <p>
 * setCancelable(boolean cancelable) | 设置此对话框是否取消与BACK关联
 * setCanceledOnTouchOutside | 当设置窗口的边界之外触及这个对话框是否被取消
 */
public class ZhiHuAc extends AppCompatActivity {

    @BindView(R.id.bt_zhihu)
    Button btZhihu;
    @BindView(R.id.bt_style1)
    Button btStyle1;
    @BindView(R.id.bt_style2)
    Button btStyle2;
    @BindView(R.id.bt_icloud)
    Button btIcloud;

    private BottomSheetAdapter bottomSheetAdapter;

    private BottomSheetDialog bottomSheetDialog;
    private List<String> list_strs = new ArrayList<>();

    private BottomSheetDialog bottomShareDialog;

    // 初始化list
    private BottomSheetDialog bottomListDialog;
    private BottomDialogAdapter bottomDialogAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu);
        ButterKnife.bind(this);

        initData();

        initShareDialog();

        // 初始化zhihu
        initZhuhiDialog();

        initListDialog();


    }

    private void showCustomSheet() {
        SpringBackBottomSheetDialog sheetDialog = new SpringBackBottomSheetDialog(this);

        View view = LayoutInflater.from(this).inflate(R.layout.item_list, null, false);

        BottomSheetDialogListView bottomSheetDialogListView = view.findViewById(R.id.listview);
        initListView(bottomSheetDialogListView);
        sheetDialog.setContentView(view);

        bottomSheetDialogListView.bindBottomSheetDialog(view);
        sheetDialog.addSpringBackDisLimit(-1);

        sheetDialog.show();
    }

    private void initListView(final BottomSheetDialogListView l) {
        final List<String> datas = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            datas.add(String.valueOf(i));
        }

        l.setAdapter(
                new ListAdapter() {
                    @Override
                    public boolean areAllItemsEnabled() {
                        return false;
                    }

                    @Override
                    public boolean isEnabled(int position) {
                        return false;
                    }

                    @Override
                    public void registerDataSetObserver(DataSetObserver observer) {

                    }

                    @Override
                    public void unregisterDataSetObserver(DataSetObserver observer) {

                    }

                    @Override
                    public int getCount() {
                        return datas.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return datas.get(position);
                    }

                    @Override
                    public long getItemId(int position) {
                        return position;
                    }

                    @Override
                    public boolean hasStableIds() {
                        return false;
                    }

                    @SuppressLint("ClickableViewAccessibility")
                    @Override
                    public View getView(final int position, View convertView, final ViewGroup parent) {
                        if (convertView == null) {
                            convertView = new TextView(parent.getContext());
                            convertView.setLayoutParams(
                                    new AbsListView.LayoutParams(
                                            ViewGroup.LayoutParams.MATCH_PARENT,
                                            40 * 3 // 40dp
                                    )
                            );
                        }
                        TextView t = (TextView) convertView;
                        t.setTextColor(Color.BLACK);
                        t.setGravity(Gravity.CENTER);
                        t.setText(datas.get(position));
                        t.setTextSize(17);
                        t.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(parent.getContext(), "" + position, Toast.LENGTH_LONG).show();
                                    }
                                }
                        );
                        t.setOnTouchListener(
                                new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {
                                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                            l.setCoordinatorDisallow();
                                        }
                                        return false;
                                    }
                                }
                        );
                        return t;
                    }

                    @Override
                    public int getItemViewType(int position) {
                        return 0;
                    }

                    @Override
                    public int getViewTypeCount() {
                        return 1;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }
                }
        );
    }


    private void initListDialog() {

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            list.add("" + i);
        }
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(this).inflate(R.layout.item_recycler, null);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bottomDialogAdapter = new BottomDialogAdapter(this, list);
        recyclerView.setAdapter(bottomDialogAdapter);

        bottomListDialog = new BottomSheetDialog(this);
        bottomListDialog.setContentView(recyclerView);

    }

    private void initShareDialog() {
        View view = View.inflate(this, R.layout.item_style1, null);
        ImageView image_wechat = (ImageView) view.findViewById(R.id.image_wechat);
        ImageView image_wxcircle = (ImageView) view.findViewById(R.id.image_wxcircle);

        image_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("image_wechat");
                bottomShareDialog.dismiss();
            }
        });
        image_wxcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("image_wxcircle");
                bottomShareDialog.dismiss();
            }
        });

        bottomShareDialog = new BottomSheetDialog(this);
        bottomShareDialog.setContentView(view);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list_strs.add("评论" + i);
        }
    }

    private void initZhuhiDialog() {
        View view = View.inflate(ZhiHuAc.this, R.layout.dialog_bottomsheet, null);
        ImageView iv_dialog_close = (ImageView) view.findViewById(R.id.dialog_bottomsheet_iv_close);
        RecyclerView rv_dialog_lists = (RecyclerView) view.findViewById(R.id.dialog_bottomsheet_rv_lists);


        bottomSheetAdapter = new BottomSheetAdapter(ZhiHuAc.this, list_strs);
        rv_dialog_lists.setHasFixedSize(true);
        rv_dialog_lists.setLayoutManager(new LinearLayoutManager(ZhiHuAc.this));
        rv_dialog_lists.setItemAnimator(new DefaultItemAnimator());
        rv_dialog_lists.setAdapter(bottomSheetAdapter);

        // 创建BottomSheetDialog对象
//        bottomSheetDialog = new BottomSheetDialog(ZhiHuAc.this, R.style.dialog);
        bottomSheetDialog = new BottomSheetDialog(ZhiHuAc.this);
        bottomSheetDialog.setContentView(view);

        // 我们即可以通过调用bottomSheetDialog.show();

    }


    @OnClick({R.id.bt_zhihu, R.id.bt_style1, R.id.bt_style2, R.id.bt_icloud})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_zhihu:
//                showSheetDialog();
                bottomSheetDialog.show();
                ToastUtils.showShort("todo");
                break;
            case R.id.bt_style1:
                // 显示微信好友、朋友圈弹框;
                showShareDialog();
                break;
            case R.id.bt_style2:
                bottomListDialog.show();
                break;
            case R.id.bt_icloud:
                // 显示网易云dialog
                showCustomSheet();
                break;
        }
    }

    private void showShareDialog() {
        bottomShareDialog.show();
    }
}
