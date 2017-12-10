package com.wealth.freedom.quanquan.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wealth.freedom.quanquan.R;
import com.wealth.freedom.quanquan.qiandao.Utils;
import com.wealth.freedom.quanquan.qiandao.component.CalendarAttr;
import com.wealth.freedom.quanquan.qiandao.component.CalendarViewAdapter;
import com.wealth.freedom.quanquan.qiandao.interf.OnSelectDateListener;
import com.wealth.freedom.quanquan.qiandao.model.CalendarDate;
import com.wealth.freedom.quanquan.qiandao.view.Calendar;
import com.wealth.freedom.quanquan.qiandao.view.MonthPager;
import com.wealth.freedom.quanquan.utils.PreferenceUtil;
import com.wealth.freedom.quanquan.view.CustomDayView;
import com.wealth.freedom.quanquan.view.ThemeDayView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class QianDaoActivity extends BaseActivity {
    private ImageView mBack, mQianDao;
    private TextView mTitle;
    private TextView textViewYearDisplay;
    private TextView textViewMonthDisplay;
    private TextView backToday;
    private CoordinatorLayout content;
    private MonthPager monthPager;
    private RecyclerView rvToDoList;
    TextView scrollSwitch;
    TextView themeSwitch;
    private ImageView nextMonthImg;
    private ImageView lastMonthImg;
    private ArrayList<Calendar> currentCalendars = new ArrayList<>();
    private CalendarViewAdapter calendarAdapter;
    private OnSelectDateListener onSelectDateListener;
    private int mCurrentPage = MonthPager.CURRENT_DAY_INDEX;
    private Context context;
    private CalendarDate currentDate;
    private boolean initiated = false;
    private String mCurrentTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qiandao);
        initView();
    }

    private void initView() {
        PreferenceUtil.init(this);
        mCurrentTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Log.e("tag", "ssfjjf" + mCurrentTime);
        mBack = (ImageView) findViewById(R.id.imgBack);
        mQianDao = (ImageView) findViewById(R.id.imgQianDao);
        if (PreferenceUtil.getString("qiandao","").equals(mCurrentTime)) {
        mQianDao.setSelected(true);
        }
        mBack.setVisibility(View.VISIBLE);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("签到");
        context = this;
        content = (CoordinatorLayout) findViewById(R.id.content);
        monthPager = (MonthPager) findViewById(R.id.calendar_view);
        //此处强行setViewHeight，毕竟你知道你的日历牌的高度
        monthPager.setViewheight(Utils.dpi2px(context, 270));
        textViewYearDisplay = (TextView) findViewById(R.id.show_year_view);
        textViewMonthDisplay = (TextView) findViewById(R.id.show_month_view);
//        backToday = (TextView) findViewById(R.id.back_today_button);
//        scrollSwitch = (TextView) findViewById(R.id.scroll_switch);
//        themeSwitch = (TextView) findViewById(R.id.theme_switch);
        nextMonthImg = (ImageView) findViewById(R.id.next_month);
        lastMonthImg = (ImageView) findViewById(R.id.last_month);
        rvToDoList = (RecyclerView) findViewById(R.id.list);
        rvToDoList.setHasFixedSize(true);
        //这里用线性显示 类似于listview
        rvToDoList.setLayoutManager(new LinearLayoutManager(this));
        // rvToDoList.setAdapter(new ExampleAdapter(this));
        initCurrentDate();
        initCalendarView();
        initToolbarClickListener();
    }

    /**
     * onWindowFocusChanged回调时，将当前月的种子日期修改为今天
     *
     * @return void
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !initiated) {
            refreshMonthPager();
            initiated = true;
        }
    }

    /**
     * 初始化对应功能的listener
     *
     * @return void
     */
    private void initToolbarClickListener() {
//        backToday.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onClickBackToDayBtn();
//            }
//        });
//        scrollSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (calendarAdapter.getCalendarType() == CalendarAttr.CalendayType.WEEK) {
//                    Utils.scrollTo(content, rvToDoList, monthPager.getViewHeight(), 200);
//                    calendarAdapter.switchToMonth();
//                } else {
//                    Utils.scrollTo(content, rvToDoList, monthPager.getCellHeight(), 200);
//                    calendarAdapter.switchToWeek(monthPager.getRowIndex());
//                }
//            }
//        });
//        themeSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                refreshSelectBackground();
//            }
//        });
        nextMonthImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monthPager.setCurrentItem(monthPager.getCurrentPosition() + 1);
            }
        });
        lastMonthImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monthPager.setCurrentItem(monthPager.getCurrentPosition() - 1);
            }
        });
        mQianDao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtil.commitString("qiandao",mCurrentTime);
                mQianDao.setSelected(true);
            }
        });
    }

    /**
     * 初始化currentDate
     */
    private void initCurrentDate() {
        currentDate = new CalendarDate();
        textViewYearDisplay.setText(currentDate.getYear() + "-");
        if (currentDate.getMonth() <= 9) {
            textViewMonthDisplay.setText("0" + currentDate.getMonth());
        } else {
            textViewMonthDisplay.setText(currentDate.getMonth() + "");
        }
    }

    /**
     * 初始化CustomDayView，并作为CalendarViewAdapter的参数传入
     */
    private void initCalendarView() {
        initListener();
        CustomDayView customDayView = new CustomDayView(context, R.layout.custom_day);
        calendarAdapter = new CalendarViewAdapter(
                context,
                onSelectDateListener,
                CalendarAttr.CalendayType.MONTH,
                customDayView);
        initMarkData();
        initMonthPager();
    }

    /**
     * 初始化标记数据，HashMap的形式，可自定义
     *
     * @return void
     */
    private void initMarkData() {
        HashMap<String, String> markData = new HashMap<>();
        markData.put("2017-8-9", "1");
        markData.put("2017-7-9", "0");
        markData.put("2017-6-9", "1");
        markData.put("2017-6-10", "0");
        markData.put("2017-12-5", "0");
        calendarAdapter.setMarkData(markData);
    }

    private void initListener() {
        onSelectDateListener = new OnSelectDateListener() {
            @Override
            public void onSelectDate(CalendarDate date) {
                refreshClickDate(date);
            }

            @Override
            public void onSelectOtherMonth(int offset) {
                //偏移量 -1表示刷新成上一个月数据 ， 1表示刷新成下一个月数据
                monthPager.selectOtherMonth(offset);
            }
        };
    }

    private void refreshClickDate(CalendarDate date) {
        currentDate = date;
        textViewYearDisplay.setText(date.getYear() + "-");
        if (currentDate.getMonth() <= 9) {
            textViewMonthDisplay.setText("0" + date.getMonth());
        } else {
            textViewMonthDisplay.setText(date.getMonth() + "");
        }
    }

    /**
     * 初始化monthPager，MonthPager继承自ViewPager
     *
     * @return void
     */
    private void initMonthPager() {
        monthPager.setAdapter(calendarAdapter);
        monthPager.setCurrentItem(MonthPager.CURRENT_DAY_INDEX);
        monthPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                position = (float) Math.sqrt(1 - Math.abs(position));
                page.setAlpha(position);
            }
        });
        monthPager.addOnPageChangeListener(new MonthPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage = position;
                currentCalendars = calendarAdapter.getPagers();
                if (currentCalendars.get(position % currentCalendars.size()) instanceof Calendar) {
                    CalendarDate date = currentCalendars.get(position % currentCalendars.size()).getSeedDate();
                    currentDate = date;
                    textViewYearDisplay.setText(date.getYear() + "-");
                    if (currentDate.getMonth() <= 9) {
                        textViewMonthDisplay.setText("0" + date.getMonth());
                    } else {
                        textViewMonthDisplay.setText(date.getMonth() + "");
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void onClickBackToDayBtn() {
        refreshMonthPager();
    }

    private void refreshMonthPager() {
        CalendarDate today = new CalendarDate();
        calendarAdapter.notifyDataChanged(today);
        textViewYearDisplay.setText(today.getYear() + "-");
        if (currentDate.getMonth() <= 9) {
            textViewMonthDisplay.setText("0" + today.getMonth());
        } else {
            textViewMonthDisplay.setText(today.getMonth() + "");
        }
    }

    private void refreshSelectBackground() {
        ThemeDayView themeDayView = new ThemeDayView(context, R.layout.custom_day_focus);
        calendarAdapter.setCustomDayRenderer(themeDayView);
        calendarAdapter.notifyDataSetChanged();
        calendarAdapter.notifyDataChanged(new CalendarDate());
    }
}
