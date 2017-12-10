package com.wealth.freedom.quanquan.qiandao.view;


import com.wealth.freedom.quanquan.qiandao.Const;

/**
 * @author: captain
 * Time:  2017/12/8 0008
 * Describe:
 */

public class Week {
    public int row;
    public Day[] days = new Day[Const.TOTAL_COL];

    public Week(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Day[] getDays() {
        return days;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }
}
