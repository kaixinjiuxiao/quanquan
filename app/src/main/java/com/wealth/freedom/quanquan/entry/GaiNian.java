package com.wealth.freedom.quanquan.entry;

/**
 * Time : 2017/12/6
 * Describe :
 */

public class GaiNian {
    private String type;
    private String id;
    private String data;
    private String name;
    private String number;
    private String precent;

    public GaiNian(String type, String id, String data, String name, String number, String precent) {
        this.type = type;
        this.id = id;
        this.data = data;
        this.name = name;
        this.number = number;
        this.precent = precent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrecent() {
        return precent;
    }

    public void setPrecent(String precent) {
        this.precent = precent;
    }
}
