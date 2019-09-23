package com.example.materialdesigndemo.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.materialdesigndemo.R;
import com.example.materialdesigndemo.example.supportdesign.helper.Cheeses;

import java.util.Objects;

/**
 * Email: 1004260403@qq.com
 * Created by jinhui on 2018/12/23.
 */
public class ArrayListFragment extends ListFragment {

    int mNum;

    public static Fragment newInstance(int num) {
        ArrayListFragment arrayListFragment = new ArrayListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("num", num + 1);
        arrayListFragment.setArguments(bundle);
        return arrayListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(getActivity());
        textView.setPadding(16, 16, 16, 16);
        textView.setText("Fragment#" + mNum);
        textView.setLayoutParams(params);
        getListView().addHeaderView(textView);
        setListAdapter(new ArrayAdapter<String>(Objects.requireNonNull(getActivity()),
                android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}
