package com.example.bsproperty.bean;

/**
 * Created by wdxc1 on 2018/4/24.
 */

public class ShuShuBean {
    private int id;
    private int count;
    private int answers[];
    private int answer;

    public ShuShuBean(int id, int count, int[] answers,int answer) {
        this.id = id;
        this.count = count;
        this.answers = answers;
        this.answer= answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
