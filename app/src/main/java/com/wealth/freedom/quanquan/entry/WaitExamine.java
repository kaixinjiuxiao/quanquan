package com.wealth.freedom.quanquan.entry;

/**
 * @author: captain
 * Time:  2017/12/4 0004
 * Describe:
 */
public class WaitExamine {
    private String type;
    private String status;
    private String time;

    public WaitExamine(String type, String status, String time) {
        this.type = type;
        this.status = status;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
