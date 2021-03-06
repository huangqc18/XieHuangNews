package com.java.xieyuntong.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.java.xieyuntong.R;
import com.java.xieyuntong.backend.news.NewsPiece;

import java.util.ArrayList;

public class MyNewsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<NewsPiece> newsPieceArrayList;

    public MyNewsAdapter(Context c, ArrayList<NewsPiece> newsPieceArrayList) {
        super();
        mContext = c;
        this.newsPieceArrayList = newsPieceArrayList;
    }

    @Override
    public int getCount() {
        return newsPieceArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewHolder holder;
        if (view == null) {
            view = inflater.inflate(R.layout.news_list_layout, null);
            holder = new ViewHolder();
            holder.textView1 = view.findViewById(R.id.text1);
            holder.textView2 = view.findViewById(R.id.text2);
            holder.textView3 = view.findViewById(R.id.text3);
            holder.relativeLayout = view.findViewById(R.id.news_list_linearlayout);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Log.i("news", String.valueOf(i));
        holder.textView1.setText(newsPieceArrayList.get(i).getTitleAbstract());
        holder.textView2.setText(newsPieceArrayList.get(i).getSource());
        holder.textView3.setText(newsPieceArrayList.get(i).getTimeStr());
        if (newsPieceArrayList.get(i).getHaveRead()) {//设置灰色
            Log.i("已读", String.valueOf(i));
            holder.relativeLayout.setBackgroundColor(Color.GRAY);
        } else {
            holder.relativeLayout.setBackgroundColor(Color.WHITE);
        }

        return view;
    }

    class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        RelativeLayout relativeLayout;
    }
}
