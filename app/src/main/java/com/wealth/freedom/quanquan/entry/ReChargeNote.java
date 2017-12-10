package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/4 0004
 * Describe:
 */
public class ReChargeNote {
    private String time;
    private String money;
    private String status;

    public ReChargeNote(String time, String money, String status) {
        this.time = time;
        this.money = money;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
