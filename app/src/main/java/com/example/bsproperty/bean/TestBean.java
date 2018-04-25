package com.example.bsproperty.bean;

/**
 * Created by wdxc1 on 2018/4/25.
 */

public class TestBean implements Cloneable {
    private int id;
    private String que;
    private int answers[];
    private int answer;
    private boolean isTrue;
    private int select;

    public TestBean(int id, String que, int[] answers, int answer) {
        this.id = id;
        this.que = que;
        this.answers = answers;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
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

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }
}
