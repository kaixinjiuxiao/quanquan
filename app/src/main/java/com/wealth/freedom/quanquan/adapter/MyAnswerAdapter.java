package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.MyAnswer;

import java.util.List;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyAnswerAdapter extends RecyclerView.Adapter<MyAnswerAdapter.MyAnswerViewHolder> {
    private Context mContext;
    private List<MyAnswer> mList;

    public MyAnswerAdapter(Context context, List<MyAnswer> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyAnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_my_qanswer, parent, false);
        return new MyAnswerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAnswerViewHolder holder, int position) {
        holder.time.setText(mList.get(position).getTime());
        holder.question.setText(mList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView time, number, question;


        public MyAnswerViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            question = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
