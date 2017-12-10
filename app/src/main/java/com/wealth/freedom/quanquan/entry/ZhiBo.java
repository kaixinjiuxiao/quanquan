package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/6 0006
 * Describe:
 */
public class ZhiBo {
    private String imgUrl;
    private String touxiangUrl;
    private String content;
    private String watchNum;
    private int isShowing;

    public ZhiBo(String imgUrl, String touxiangUrl, String content, String watchNum, int isShowing) {
        this.imgUrl = imgUrl;
        this.touxiangUrl = touxiangUrl;
        this.content = content;
        this.watchNum = watchNum;
        this.isShowing = isShowing;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTouxiangUrl() {
        return touxiangUrl;
    }

    public void setTouxiangUrl(String touxiangUrl) {
        this.touxiangUrl = touxiangUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(String watchNum) {
        this.watchNum = watchNum;
    }

    public int getIsShowing() {
        return isShowing;
    }

    public void setIsShowing(int isShowing) {
        this.isShowing = isShowing;
    }
}
