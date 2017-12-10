package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.Hot;

import java.util.List;

/**
 * Time:  2017/12/7 0007
 * Describe:
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.HotViewHolder> {
    private Context mContext;
    private List<Hot> mList;

    public HotAdapter(Context context, List<Hot> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_hot, parent, false);
        return new HotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotViewHolder holder, int position) {
        holder.type.setText(mList.get(position).getType());
        holder.data.setText(mList.get(position).getData());
        holder.company.setText(mList.get(position).getCompany());
        holder.data2.setText(mList.get(position).getData2());
        holder.data3.setText(mList.get(position).getData3());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class HotViewHolder extends RecyclerView.ViewHolder {


        public TextView type, data, company,data2,data3;

        public HotViewHolder(View itemView) {
            super(itemView);
            type = (TextView) itemView.findViewById(R.id.type);
            data = (TextView) itemView.findViewById(R.id.data);
            company = (TextView) itemView.findViewById(R.id.company);
            data2 = (TextView) itemView.findViewById(R.id.data2);
            data3 = (TextView) itemView.findViewById(R.id.data3);
        }
    }
}
