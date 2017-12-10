package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.OwnSelected2;

import java.util.List;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class OwnSelectAdapter2 extends RecyclerView.Adapter<OwnSelectAdapter2.OwnSelect2ViewHolder> {
    private Context mContext;
    private List<OwnSelected2> mList;
    private OnItemClickListener mItemClickListener;

    public OnItemClickListener getItemClickListener() {
        return mItemClickListener;
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public OwnSelectAdapter2(Context context, List<OwnSelected2> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public OwnSelect2ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_aa, parent, false);
        return new OwnSelect2ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OwnSelect2ViewHolder holder, final int position) {
        holder.type.setText(mList.get(position).getType());
        if(mList.get(position).isAdd()==false){
            holder.data.setTextColor(0XFF119d12);
            holder.data2.setTextColor(0XFF119d12);
            holder.data3.setTextColor(0XFF119d12);
        }
        holder.data.setText(mList.get(position).getData());
        holder.data2.setText(mList.get(position).getData2());
        holder.data3.setText(mList.get(position).getData3());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class OwnSelect2ViewHolder extends RecyclerView.ViewHolder{
        public TextView type,data,data2,data3;
        public OwnSelect2ViewHolder(View itemView) {
            super(itemView);
            type= (TextView) itemView.findViewById(R.id.type);
            data= (TextView) itemView.findViewById(R.id.data);
            data2= (TextView) itemView.findViewById(R.id.data2);
            data3= (TextView) itemView.findViewById(R.id.data3);
        }
    }
}
