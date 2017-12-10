package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.GaiNian;

import java.util.List;

/**
 * Author : Captain
 * Time : 2017/12/6
 * Describe :
 */

public class GaiNianAdapter extends RecyclerView.Adapter<GaiNianAdapter.GaiNianViewHolder> {
    private Context mContext;
    private List<GaiNian> mList;

    public GaiNianAdapter(Context context, List<GaiNian> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public GaiNianViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_gainain, parent, false);
        return new GaiNianViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GaiNianViewHolder holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.id.setText(mList.get(position).getId());
        if(mList.get(position).getData().contains("-")){
            holder.data.setText(mList.get(position).getData().substring(1,mList.get(position).getData().length()));
            holder.data.setBackgroundColor(0XFF119d12);
        }else{
            holder.data.setText(mList.get(position).getData());
        }
        holder.name.setText(mList.get(position).getName());
        holder.precent.setText(mList.get(position).getPrecent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class GaiNianViewHolder extends RecyclerView.ViewHolder{
        public TextView type,id,data,name,precent;
        public GaiNianViewHolder(View itemView) {
            super(itemView);
            type= (TextView) itemView.findViewById(R.id.txtType);
            id= (TextView) itemView.findViewById(R.id.txtId);
            data= (TextView) itemView.findViewById(R.id.txtData);
            name= (TextView) itemView.findViewById(R.id.txtName);
            precent= (TextView) itemView.findViewById(R.id.txtPecent);
        }
    }
}
