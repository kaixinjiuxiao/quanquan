package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class MyAward {
    private String img;
    private String time;
    private String content;

    public MyAward(String img, String time, String content) {
        this.img = img;
        this.time = time;
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
