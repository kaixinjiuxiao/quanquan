package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.ReChargeNote;

import java.util.List;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class ReChargeNoteAdapter extends RecyclerView.Adapter<ReChargeNoteAdapter.ReChargeNoteViewHolder> {
    private Context mContext;
    private List<ReChargeNote> mList;

    public ReChargeNoteAdapter(Context context, List<ReChargeNote> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public ReChargeNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_recharge_note, parent, false);
        return new ReChargeNoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ReChargeNoteViewHolder holder, int position) {
        holder.time.setText(mList.get(position).getTime());
        holder.money.setText(mList.get(position).getMoney());
        holder.status.setText(mList.get(position).getStatus());
        if (mList.get(position).getStatus().equals("待入账")){
            holder.status.setTextColor(0XFFE9302E);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ReChargeNoteViewHolder extends RecyclerView.ViewHolder {
        public TextView  time,money,status;

        public ReChargeNoteViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            money = (TextView) itemView.findViewById(R.id.money);
            status = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
