package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.MyAward;

import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyAwardAdapter extends RecyclerView.Adapter<MyAwardAdapter.MyAwardViewHolder> {
    private Context mContext;
    private List<MyAward> mList;
    public OnReceiveListener mOnReceiveListener;
    public interface OnReceiveListener{
        void receive();
    }

    public MyAwardAdapter(Context context, List<MyAward> list) {
        mContext = context;
        mList = list;
    }

    public OnReceiveListener getOnReceiveListener() {
        return mOnReceiveListener;
    }

    public void setOnReceiveListener(OnReceiveListener onReceiveListener) {
        mOnReceiveListener = onReceiveListener;
    }

    @Override
    public MyAwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_my_award, parent, false);
        return new MyAwardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAwardViewHolder holder, int position) {
        holder.name.setText(mList.get(position).getTime());
        holder.number.setText(mList.get(position).getContent());
        holder.receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnReceiveListener.receive();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyAwardViewHolder extends RecyclerView.ViewHolder {
        public TextView name, number;
        public ImageView img;
        public Button receive;

        public MyAwardViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.awardImg);
            name = (TextView) itemView.findViewById(R.id.awardName);
            number = (TextView) itemView.findViewById(R.id.awardNumber);
            receive = (Button) itemView.findViewById(R.id.receive);
        }
    }
}
