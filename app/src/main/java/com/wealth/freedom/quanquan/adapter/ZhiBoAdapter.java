package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.ZhiBo;

import java.util.List;

/**
 * Time:  2017/12/6 0006
 * Describe:
 */
public class ZhiBoAdapter extends RecyclerView.Adapter<ZhiBoAdapter.ZhiBoViewHolder>{
    private Context mContext;
    private List<ZhiBo> mList;
    public OnAcctntionListener mAcctntionListener;
    public OnLookingListener mLookingListener;
    public interface OnAcctntionListener{
        void attentionHouse(int position);
    }
    public interface OnLookingListener{
        void onLooking(int position);
    }

    public ZhiBoAdapter(Context context, List<ZhiBo> list) {
        mContext = context;
        mList = list;
    }

    public OnAcctntionListener getAcctntionListener() {
        return mAcctntionListener;
    }

    public void setAcctntionListener(OnAcctntionListener acctntionListener) {
        mAcctntionListener = acctntionListener;
    }

    public OnLookingListener getLookingListener() {
        return mLookingListener;
    }

    public void setLookingListener(OnLookingListener lookingListener) {
        mLookingListener = lookingListener;
    }

    @Override
    public ZhiBoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false);
        return new ZhiBoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ZhiBoViewHolder holder, final int position) {
        holder.teacher.setText(mList.get(position).getContent());
        holder.watch.setText(mList.get(position).getWatchNum());
        if(mList.get(position).getIsShowing()==1){
            holder.zhibo.setVisibility(View.VISIBLE);
            holder.relativeZBing.setVisibility(View.VISIBLE);
        }
        holder.attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.attention.setText("已关注");
                mAcctntionListener.attentionHouse(position);
            }
        });
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLookingListener.onLooking(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ZhiBoViewHolder extends RecyclerView.ViewHolder{
        public ImageView content,touxiang;
        public TextView zhibo,teacher,watch,attention;
        public RelativeLayout relativeZBing;
        public ZhiBoViewHolder(View itemView) {
            super(itemView);
            content = (ImageView) itemView.findViewById(R.id.imgZB);
            touxiang = (ImageView) itemView.findViewById(R.id.imgTeacher);
            zhibo = (TextView) itemView.findViewById(R.id.txtZBing);
            teacher = (TextView) itemView.findViewById(R.id.zbContent);
            watch = (TextView) itemView.findViewById(R.id.zbWatchNumber);
            attention = (TextView) itemView.findViewById(R.id.txtAttention);
            relativeZBing = (RelativeLayout) itemView.findViewById(R.id.relativeZBing);
        }
    }
}
