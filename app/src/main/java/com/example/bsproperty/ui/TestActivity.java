package com.example.bsproperty.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.ShuShuBean;
import com.example.bsproperty.bean.TestBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_testnum)
    TextView tvTestnum;
    @BindView(R.id.btn01)
    TextView btn01;
    @BindView(R.id.btn02)
    TextView btn02;
    @BindView(R.id.btn03)
    TextView btn03;
    @BindView(R.id.btn04)
    TextView btn04;
    private ArrayList<TestBean> testBeans;
    private Random random;
    private TestBean nowTest;
    private int ranInt=10;
    @Override
    protected void initView(Bundle savedInstanceState) {
        if (SpUtils.getUserPoints(this)<=180){
            ranInt=10;
            tvTitle.setText("学计算(普通难度)");
        }else{
            ranInt=20;
            tvTitle.setText("学计算(困难难度)");
        }
        random = new Random();
        btnRight.setVisibility(View.GONE);
        testBeans = MyApplication.getTestBeans();
        nowTest = testBeans.get(random.nextInt(ranInt));
        tvTestnum.setText("第"+SpUtils.getTestNum(this) + "题");
        tvTest.setText(nowTest.getQue());
        btn01.setText("A."+nowTest.getAnswers()[0]);
        btn02.setText("B."+nowTest.getAnswers()[1]);
        btn03.setText("C."+nowTest.getAnswers()[2]);
        btn04.setText("D."+nowTest.getAnswers()[3]);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.btn_back, R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn01:
                if (nowTest.getAnswer() == 1) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn02:
                if (nowTest.getAnswer() == 2) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn03:
                if (nowTest.getAnswer() == 3) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn04:
                if (nowTest.getAnswer() == 4) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
        }
    }

    private void getNextQe(){
        nowTest = testBeans.get(random.nextInt(ranInt));
        tvTestnum.setText("第"+SpUtils.getTestNum(this) + "题");
        tvTest.setText(nowTest.getQue());
        btn01.setText("A."+nowTest.getAnswers()[0]);
        btn02.setText("B."+nowTest.getAnswers()[1]);
        btn03.setText("C."+nowTest.getAnswers()[2]);
        btn04.setText("D."+nowTest.getAnswers()[3]);
    }
    private void loadPoint(boolean isRight) {
        SpUtils.setTestNum(this,SpUtils.getTestNum(this)+1);
        if (isRight){
            SpUtils.setUserPoints(this,SpUtils.getUserPoints(this)+10);
            showToast("答对了，加10分！当前总分："+SpUtils.getUserPoints(this)+"分！");
        }else{
            SpUtils.setUserPoints(this,SpUtils.getUserPoints(this)-5);
            showToast("答错了，减5分！");
        }
        getNextQe();
    }
}
