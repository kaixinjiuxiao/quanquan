package com.wealth.freedom.quanquan.entry;

/**
 * Time:  2017/12/7 0007
 * Describe:
 */
public class HuShen {
    private String type;
    private String id;
    private String data;
    private String precent;
    private boolean isAdd;

    public HuShen(String type, String id, String data, String precent, boolean isAdd) {
        this.type = type;
        this.id = id;
        this.data = data;
        this.precent = precent;
        this.isAdd = isAdd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrecent() {
        return precent;
    }

    public void setPrecent(String precent) {
        this.precent = precent;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }
}
