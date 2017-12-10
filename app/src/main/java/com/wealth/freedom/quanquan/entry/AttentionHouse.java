package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class AttentionHouse {
    private String img;
    private String teacherName;
    private String content;

    public AttentionHouse(String img, String teacherName, String content) {
        this.img = img;
        this.teacherName = teacherName;
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
