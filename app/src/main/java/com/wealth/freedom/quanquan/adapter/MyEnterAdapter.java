package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.WaitExamine;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyEnterAdapter extends RecyclerView.Adapter<MyEnterAdapter.MyEnterViewHolder> {
    private Context mContext;
    private List<WaitExamine> mList;

    public MyEnterAdapter(Context context, List<WaitExamine> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public MyEnterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_my_enter, parent, false);
        return new MyEnterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyEnterViewHolder holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.status.setText(mList.get(position).getStatus());
       holder.time.setText(mList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyEnterViewHolder extends RecyclerView.ViewHolder {
        public TextView type, status,time;

        public MyEnterViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.type);
            status = (TextView) itemView.findViewById(R.id.status);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
