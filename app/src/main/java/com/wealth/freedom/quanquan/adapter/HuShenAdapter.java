package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.HuShen;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/7 0007
 * Describe:
 */
public class HuShenAdapter extends RecyclerView.Adapter<HuShenAdapter.HuShenViewHolder> {
    private Context mContext;
    private List<HuShen> mList;

    public HuShenAdapter(Context context, List<HuShen> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public HuShenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_hushen, parent, false);
        return new HuShenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HuShenViewHolder holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.id.setText(mList.get(position).getId());
        if (mList.get(position).isAdd() == false) {
            holder.data.setBackgroundColor(0XFF119d12);
        }
        holder.data.setText(mList.get(position).getData());
        if (mList.get(position).getPrecent().contains("-")) {
            holder.precent.setText(mList.get(position).getPrecent());
            holder.precent.setTextColor(0XFF119d12);
        } else {
            holder.precent.setText(mList.get(position).getPrecent());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class HuShenViewHolder extends RecyclerView.ViewHolder {


        public TextView type, id, data, precent;

        public HuShenViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.txtType);
            id = (TextView) itemView.findViewById(R.id.txtId);
            data = (TextView) itemView.findViewById(R.id.txtData);
            precent = (TextView) itemView.findViewById(R.id.txtPecent);
        }
    }
}
