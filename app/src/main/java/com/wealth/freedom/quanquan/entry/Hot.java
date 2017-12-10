package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/7 0007
 * Describe:
 */
public class Hot {
    private String type;
    private String data;
    private String company;
    private String data2;
    private String data3;

    public Hot(String type, String data, String company, String data2, String data3) {
        this.type = type;
        this.data = data;
        this.company = company;
        this.data2 = data2;
        this.data3 = data3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }
}
