package com.wealth.freedom.quanquan.entry;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class HuiDaDetails {
    private String img;
    private String name;
    private String time;
    private String content;

    public HuiDaDetails(String img, String name, String time, String content) {
        this.img = img;
        this.name = name;
        this.time = time;
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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