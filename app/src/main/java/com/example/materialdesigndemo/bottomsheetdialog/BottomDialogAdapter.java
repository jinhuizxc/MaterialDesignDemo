package com.example.materialdesigndemo.bottomsheetdialog;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.materialdesigndemo.R;
import com.example.materialdesigndemo.databinding.ItemSampleBinding;

import java.util.List;

public class BottomDialogAdapter extends RecyclerView.Adapter {

    private List<String> mList;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemSampleBinding normalBinding;

    public BottomDialogAdapter(Context context, List list) {
        mInflater = LayoutInflater.from(context);
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        normalBinding = DataBindingUtil.inflate(mInflater, R.layout.item_sample, parent, false);
        return new NormalViewHolder(normalBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NormalViewHolder viewHolder = (NormalViewHolder) holder;
        viewHolder.text.setText("条目:" + position);
        viewHolder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(position + "被点击");
            }
        });
    }

    // 获取条目数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class NormalViewHolder extends RecyclerView.ViewHolder {

        public TextView text;

        public NormalViewHolder(View itemView) {
            super(itemView);
            text = normalBinding.itemTextview;
        }
    }


}
