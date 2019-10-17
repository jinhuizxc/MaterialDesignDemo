package com.example.materialdesigndemo.bottomsheetdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class BottomSheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list_strs;

    public BottomSheetAdapter(List<String> list_strs) {
        this.list_strs = list_strs;
    }

    public BottomSheetAdapter(Context context, List<String> list_strs) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
