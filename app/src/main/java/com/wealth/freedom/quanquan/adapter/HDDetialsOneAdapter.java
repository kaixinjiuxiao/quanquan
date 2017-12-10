package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.HuiDaDetails;

import java.util.List;

/**
 * Time : 2017/12/5
 * Describe :
 */

public class HDDetialsOneAdapter extends RecyclerView.Adapter<HDDetialsOneAdapter.HuiDaViewOneHolder> {

    private Context mContext;
    private List<HuiDaDetails> mList;

    public HDDetialsOneAdapter(Context context, List<HuiDaDetails> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public HuiDaViewOneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_huida_details, parent, false);
        return new HuiDaViewOneHolder(v);
    }

    @Override
    public void onBindViewHolder(HuiDaViewOneHolder holder, int position) {
        holder.time.setText(mList.get(position).getTime());
        holder.name.setText(mList.get(position).getName());
        holder.content.setText(mList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class HuiDaViewOneHolder extends RecyclerView.ViewHolder{
        public TextView time, content,name;
        public ImageView img;
        public HuiDaViewOneHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            time = (TextView) itemView.findViewById(R.id.time);
            name = (TextView) itemView.findViewById(R.id.name);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }

}
