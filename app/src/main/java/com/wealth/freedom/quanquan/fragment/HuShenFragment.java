package com.wealth.freedom.quanquan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.activity.GuPiaoDetailsActivity;
import com.wealth.freedom.quanquan.activity.HotPlateActivity;
import com.wealth.freedom.quanquan.adapter.HotAdapter;
import com.wealth.freedom.quanquan.adapter.HuShenAdapter;
import com.wealth.freedom.quanquan.adapter.OwnSelectAdapter2;
import com.wealth.freedom.quanquan.entry.Hot;
import com.wealth.freedom.quanquan.entry.HuShen;
import com.wealth.freedom.quanquan.entry.OwnSelected2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: captain
 * Time:  2017/12/7 0007
 * Describe:
 */
public class HuShenFragment extends BaseFragment implements View.OnClickListener {
    private ImageView mHotMore,mAddMore,mFallMore;
    private View mView;
    private RecyclerView mRecyclerHot,mRecyclerAdd,mRecyclerFall;
    //private HuShenAdapter mAdapter;
    private HotAdapter mAdapter;
    private List<Hot> mHotList;
    private List<HuShen> mAddList,mFallList;
    private ViewPager mPager;
    private RecyclerView[] mRecyclerViews = new RecyclerView[2];
    private List<OwnSelected2> mList, mList2;
    private OwnSelectAdapter2 mHuSehnAdapter1,mHuSehnAdapter2;
    private ImageView mImg1,mImg2;
    private ImageView[] mImgAdwares = new ImageView[2];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_hushen,container,false);
            initView();
            initEvent();
        }
        return mView;
    }

    private void initView() {
        mHotMore= (ImageView) mView.findViewById(R.id.moreHot);
        mAddMore= (ImageView) mView.findViewById(R.id.moreHot);
        mFallMore= (ImageView) mView.findViewById(R.id.moreHot);
        mImg1 = (ImageView) mView.findViewById(R.id.img1);
        mImg2 = (ImageView) mView.findViewById(R.id.img2);
        mImgAdwares[0] = mImg1;
        mImgAdwares[1] = mImg2;
        initData();
        mRecyclerHot = (RecyclerView) mView.findViewById(R.id.recylerHot);
        mRecyclerAdd = (RecyclerView) mView.findViewById(R.id.recylerAdd);
        mRecyclerFall = (RecyclerView) mView.findViewById(R.id.recylerFall);
        mRecyclerHot.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRecyclerAdd.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerFall.setLayoutManager(new LinearLayoutManager(getActivity()));


        RecyclerView recyclerView = new RecyclerView(getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mHuSehnAdapter1 = new OwnSelectAdapter2(getActivity(),mList);
        recyclerView.setAdapter(mHuSehnAdapter1);
        mRecyclerViews[0]=recyclerView;

        RecyclerView recyclerView2 = new RecyclerView(getActivity());
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mHuSehnAdapter2 =new OwnSelectAdapter2(getActivity(),mList2);
        recyclerView2.setAdapter(mHuSehnAdapter2);
        mRecyclerViews[1]=recyclerView2;


        mPager = (ViewPager) mView.findViewById(R.id.viewpager);
        GuideAdapter adapter = new GuideAdapter();
        mPager.setAdapter(adapter);

        mRecyclerAdd.setAdapter(new HuShenAdapter(getActivity(),mAddList));
        mRecyclerFall.setAdapter(new HuShenAdapter(getActivity(),mFallList));
        mAdapter = new HotAdapter(getActivity(),mHotList);
        mRecyclerHot.setAdapter(mAdapter);
        setImgAdwares(0);
    }

    private void initData() {
        mHotList =new ArrayList<>();
        mAddList =new ArrayList<>();
        mFallList =new ArrayList<>();
        mList = new ArrayList<>();
        mList2= new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            mAddList.add(new HuShen("上证指数","000001","1277.9","+0.87%",true));
        }
        for (int i = 0; i <4 ; i++) {
            mFallList.add(new HuShen("华胜天成","600410","10.23","-1.08%",false));
        }
        for (int i = 0; i <6 ; i++) {
            mHotList.add(new Hot("水泥","+2.90%","天山股份","+1.90%","+0.06"));
        }
        mList.add(new OwnSelected2("上证指数", "3353.82", "+1.90%", "+0.66", true));
        mList.add(new OwnSelected2("上证指数", "3383.82", "-1.90", "-0.66", false));
        mList.add(new OwnSelected2("上证指数", "3353.82", "+1.90%", "+0.66", true));
        mList2.add(new OwnSelected2("道琼斯", "3353.82", "+1.90%", "+0.66", true));
        mList2.add(new OwnSelected2("道琼斯", "3353.82", "+1.90%", "+0.66", false));
        mList2.add(new OwnSelected2("道琼斯", "3353.82", "+1.90%", "+0.66", true));
    }

    private void initEvent() {
        mHotMore.setOnClickListener(this);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setImgAdwares(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mHuSehnAdapter1.setItemClickListener(new OwnSelectAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), GuPiaoDetailsActivity.class);
                intent.putExtra("data",mList2.get(position).toString());
                startActivity(intent);
            }
        });
        mHuSehnAdapter2.setItemClickListener(new OwnSelectAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), GuPiaoDetailsActivity.class);
                intent.putExtra("data",mList2.get(position).toString());
                startActivity(intent);
            }
        });
    }

    private void setImgAdwares(int position) {
        for (int i = 0; i < mImgAdwares.length; i++) {
            if (position == i) {
               mImgAdwares[i].setSelected(true);
            } else {
                mImgAdwares[i].setSelected(false);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moreHot:
                startActivity(new Intent(getActivity(), HotPlateActivity.class));
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = mRecyclerViews[position];
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
