package com.wealth.freedom.quanquan.qiandao.interf;

import android.graphics.Canvas;

import com.wealth.freedom.quanquan.qiandao.view.Day;


/**
 * Time:  2017/12/8 0008
 * Describe:
 */

public interface IDayRenderer {

    void refreshContent();

    void drawDay(Canvas canvas, Day day);

    IDayRenderer copy();

}
