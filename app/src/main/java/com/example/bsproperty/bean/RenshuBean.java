package com.example.bsproperty.bean;

/**
 * Created by wdxc1 on 2018/4/25.
 */

public class RenshuBean {
    private int id;
    private int num;
    private String imaId;
    private String duyin;
    private String erge;

    public RenshuBean(int id, int num, String imaId, String duyin, String erge) {
        this.id = id;
        this.num = num;
        this.imaId = imaId;
        this.duyin = duyin;
        this.erge = erge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImaId() {
        return imaId;
    }

    public void setImaId(String imaId) {
        this.imaId = imaId;
    }

    public String getDuyin() {
        return duyin;
    }

    public void setDuyin(String duyin) {
        this.duyin = duyin;
    }

    public String getErge() {
        return erge;
    }

    public void setErge(String erge) {
        this.erge = erge;
    }
}
