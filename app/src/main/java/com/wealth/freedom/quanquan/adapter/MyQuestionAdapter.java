package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.MyQuestion;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyQuestionAdapter extends RecyclerView.Adapter<MyQuestionAdapter.MyQuestionViewHolder> {
    private Context mContext;
    private List<MyQuestion> mList;

    public MyQuestionAdapter(Context context, List<MyQuestion> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyQuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_my_qanswer, parent, false);
        return new MyQuestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyQuestionViewHolder holder, int position) {
        holder.number.setVisibility(View.VISIBLE);
        holder.time.setText(mList.get(position).getTime());
        holder.number.setText(mList.get(position).getNumber());
        holder.question.setText(mList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyQuestionViewHolder extends RecyclerView.ViewHolder {
        public TextView time, number, question;


        public MyQuestionViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            number = (TextView) itemView.findViewById(R.id.number);
            question = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
