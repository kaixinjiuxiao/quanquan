package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class Notice {
    private String title;
    private String time;

    public Notice(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
