package com.wealth.freedom.quanquan.entry;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyQuestion {
    private String time;
    private String number;
    private String content;

    public MyQuestion(String time, String number, String content) {
        this.time = time;
        this.number = number;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
