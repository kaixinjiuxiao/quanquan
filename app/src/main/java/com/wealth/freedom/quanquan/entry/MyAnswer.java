package com.wealth.freedom.quanquan.entry;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyAnswer {
    private String time;
    private String content;

    public MyAnswer(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
