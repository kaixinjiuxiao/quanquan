package com.wealth.freedom.quanquan.qiandao.interf;


import com.wealth.freedom.quanquan.qiandao.model.CalendarDate;

/**
 * Time:  2017/12/8 0008
 * Describe:
 */

public interface OnSelectDateListener {
    void onSelectDate(CalendarDate date);

    void onSelectOtherMonth(int offset);//点击其它月份日期
}
