package com.wealth.freedom.quanquan.entry;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class OwnSelected2 {
    private String type;
    private String data;
    private String data2;
    private String data3;
    private boolean isAdd;

    public OwnSelected2(String type, String data, String data2, String data3, boolean isAdd) {
        this.type = type;
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
        this.isAdd = isAdd;
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

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    @Override
    public String toString() {
        return "OwnSelected{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", data2='" + data2 + '\'' +
                ", data3='" + data3 + '\'' +
                ", isAdd=" + isAdd +
                '}';
    }
}
