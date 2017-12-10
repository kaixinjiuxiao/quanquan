package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.AllQuestionAnswer;

import java.util.List;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class AllQuesAnswAdapter extends RecyclerView.Adapter<AllQuesAnswAdapter.MyQuesAnswerViewHolder> {
    private Context mContext;
    private List<AllQuestionAnswer> mList;
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }
    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    public AllQuesAnswAdapter(Context context, List<AllQuestionAnswer> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyQuesAnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_all_quanswer, parent, false);
        return new MyQuesAnswerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyQuesAnswerViewHolder holder, int position) {

        holder.time.setText(mList.get(position).getTime());
        holder.name.setText(mList.get(position).getName());
        holder.number.setText(mList.get(position).getNumber());
        holder.question.setText(mList.get(position).getContent());
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                    Log.e("tag","点解了啊");
//                    Intent intent = new Intent(mContext, HuiDaDetailsOneActivity.class);
//                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyQuesAnswerViewHolder extends RecyclerView.ViewHolder {
        public TextView time, number, question,name;
        public ImageView img;

        public MyQuesAnswerViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            time = (TextView) itemView.findViewById(R.id.time);
            name = (TextView) itemView.findViewById(R.id.name);
            number = (TextView) itemView.findViewById(R.id.number);
            question = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
