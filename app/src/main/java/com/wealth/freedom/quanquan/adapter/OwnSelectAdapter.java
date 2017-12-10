package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.OwnSelected;

import java.util.List;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class OwnSelectAdapter extends RecyclerView.Adapter<OwnSelectAdapter.OwnSelectViewHolder> {
    private Context mContext;
    private List<OwnSelected> mList;

    public OwnSelectAdapter(Context context, List<OwnSelected> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public OwnSelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_own_selected, parent, false);
        return new OwnSelectViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OwnSelectViewHolder holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.id.setText(mList.get(position).getId());
        if(mList.get(position).isAdd()==false){
            holder.data.setBackgroundColor(0XFF119d12);
        }
        holder.data.setText(mList.get(position).getData());
        if(mList.get(position).getPrecent().contains("-")){
            holder.precent.setText(mList.get(position).getPrecent());
            holder.precent.setTextColor(0XFF119d12);
        }else{
            holder.precent.setText(mList.get(position).getPrecent());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class OwnSelectViewHolder extends RecyclerView.ViewHolder{
        public TextView type,id,data,precent;
        public OwnSelectViewHolder(View itemView) {
            super(itemView);
            type= (TextView) itemView.findViewById(R.id.txtType);
            id= (TextView) itemView.findViewById(R.id.txtId);
            data= (TextView) itemView.findViewById(R.id.txtData);
            precent= (TextView) itemView.findViewById(R.id.txtPecent);
        }
    }
}
