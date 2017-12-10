package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.AttentionHouse;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.NoticeViewHolder> {
    private Context mContext;
    private List<AttentionHouse> mList;
    public interface OnCancelAttentionListener{
      void  cancelAttention(int position);
    }
    private OnCancelAttentionListener mCancelAttentionListener;

    public OnCancelAttentionListener getCancelAttentionListener() {
        return mCancelAttentionListener;
    }

    public void setCancelAttentionListener(OnCancelAttentionListener cancelAttentionListener) {
        mCancelAttentionListener = cancelAttentionListener;
    }

    public AttentionAdapter(Context context, List<AttentionHouse> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_attention, parent, false);
        return new NoticeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoticeViewHolder holder, final int position) {
        holder.teacherName.setText(mList.get(position).getTeacherName());
        holder.teachContent.setText(mList.get(position).getContent());
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCancelAttentionListener.cancelAttention(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {
        public TextView teacherName, teachContent,cancel;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            teacherName = (TextView) itemView.findViewById(R.id.teacherName);
            teachContent = (TextView) itemView.findViewById(R.id.teachContent);
            cancel = (TextView) itemView.findViewById(R.id.cancel);
        }
    }
}
