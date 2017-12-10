package com.wealth.freedom.quanquan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.entry.Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {
    private Context mContext;
    private List<Address> mList;
    private  HashMap<Integer, Boolean> mMap;
    int mCurrentPosition;

    public OnDeleteAddressListener mOnDeleteListener;
    public OnEditAddresListener mOnEditListener;
    public onSeetingMorenListener mOnSettMOrenListener;

    public interface OnEditAddresListener{
        void editAddress();
    }

    public interface OnDeleteAddressListener{
        void deleteAddress();
    }
    public interface onSeetingMorenListener{
       void seetMoren(int position);
    }
    public AddressAdapter(Context context, List<Address> list,HashMap<Integer, Boolean> map) {
        mContext = context;
        mList = list;
        mMap = map;
    }

    public OnDeleteAddressListener getOnDeleteListener() {
        return mOnDeleteListener;
    }

    public void setOnDeleteListener(OnDeleteAddressListener onDeleteListener) {
        mOnDeleteListener = onDeleteListener;
    }

    public OnEditAddresListener getOnEditListener() {
        return mOnEditListener;
    }

    public void setOnEditListener(OnEditAddresListener onEditListener) {
        mOnEditListener = onEditListener;
    }

    public onSeetingMorenListener getOnSettMOrenListener() {
        return mOnSettMOrenListener;
    }

    public void setOnSettMOrenListener(onSeetingMorenListener onSettMOrenListener) {
        mOnSettMOrenListener = onSettMOrenListener;
    }
    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_address, parent, false);
        return new AddressViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final AddressViewHolder holder, final int position) {

        holder.name.setText(mList.get(position).getName());
        holder.phone.setText(mList.get(position).getPhone());
        holder.address.setText(mList.get(position).getAddress());
        holder.select.setSelected(mMap.get(position));
        if (mList.get(position).isSelected()==true){
            holder.moren.setVisibility(View.VISIBLE);
        }else{
            holder.moren.setVisibility(View.GONE);
        }
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnSettMOrenListener.seetMoren(position);

                mMap.put(position, !mMap.get(position));
                for (int i = 0; i <mList.size() ; i++) {
                    mList.get(i).setSelected(false);
                }
                mList.get(position).setSelected(true);
                //刷新适配器
                notifyDataSetChanged();
                //单选
                singlesel(position);
            }
        });
        holder.linearEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnEditListener.editAddress();
            }
        });
        holder.linearDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnDeleteListener.deleteAddress();
            }
        });
    }

    /**
     * 单选
     *
     * @param postion
     */
    public void singlesel(int postion) {
        mCurrentPosition = postion;
        Set<Map.Entry<Integer, Boolean>> entries = mMap.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(false);
        }
        mMap.put(postion, true);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AddressViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone,address,moren;
       private LinearLayout linearEdit,linearDelete;
        private ImageView select;

        public AddressViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            phone = (TextView) itemView.findViewById(R.id.phone);
            address = (TextView) itemView.findViewById(R.id.address);
            moren = (TextView) itemView.findViewById(R.id.moren);
            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearDelete = (LinearLayout) itemView.findViewById(R.id.linearDelete);
            select= (ImageView) itemView.findViewById(R.id.imgMoren);

        }
    }
}
