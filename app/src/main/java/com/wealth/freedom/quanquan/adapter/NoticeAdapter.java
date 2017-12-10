package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.Notice;

import java.util.List;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    private Context mContext;
    private List<Notice> mList;

    public NoticeAdapter(Context context, List<Notice> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_notice, parent, false);
        return new NoticeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder holder, int position) {
        holder.title.setText(mList.get(position).getTitle());
        holder.time.setText(mList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtContent);
            time = (TextView) itemView.findViewById(R.id.txtTime);
        }
    }
}
