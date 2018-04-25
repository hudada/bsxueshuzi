package com.example.bsproperty.bean;

/**
 * Created by wdxc1 on 2018/4/24.
 */

public class DaxiaoBean {
    private int id;
    private int left;
    private int right;
    private int answer;

    public DaxiaoBean(int id, int left, int right, int answer) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
