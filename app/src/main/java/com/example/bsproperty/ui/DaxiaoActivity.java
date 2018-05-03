package com.example.bsproperty.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.DaxiaoBean;
import com.example.bsproperty.bean.ShuShuBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class DaxiaoActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_q)
    TextView tvQ;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_list01)
    RecyclerView rvList01;
    @BindView(R.id.rv_list02)
    RecyclerView rvList02;
    @BindView(R.id.btn01)
    Button btn01;
    @BindView(R.id.btn02)
    Button btn02;
    @BindView(R.id.btn03)
    Button btn03;
    private ArrayList<DaxiaoBean> daXiaoBeans;
    private Random random;
    private DaxiaoBean nowDa;
    private ArrayList<String> mData01;
    private ArrayList<String> mData02;
    private DaxiaoActivity.MyAdapter adapter01;
    private DaxiaoActivity.MyAdapter adapter02;
    private int ranInt;

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (SpUtils.getUserPoints(this)<=180){
            ranInt=10;
            tvTitle.setText("学比较(普通难度)");
        }else{
            ranInt=20;
            tvTitle.setText("学比较(困难难度)");
        }
        random = new Random();
        btnRight.setVisibility(View.GONE);
        daXiaoBeans = MyApplication.getInstance().getDaXiaoBeans();
        nowDa = daXiaoBeans.get(random.nextInt(ranInt));
        tvQ.setText(SpUtils.getDaxiaoNum(this) + ".下面括号应该填什么:");
        setData(nowDa.getLeft(), nowDa.getRight());
        rvList01.setLayoutManager(new GridLayoutManager(this, 7));
        adapter01 = new DaxiaoActivity.MyAdapter(mContext, R.layout.item_daxiao, mData01);
        rvList01.setAdapter(adapter01);
        rvList02.setLayoutManager(new GridLayoutManager(this, 7));
        adapter02 = new DaxiaoActivity.MyAdapter(mContext, R.layout.item_daxiao, mData02);
        rvList02.setAdapter(adapter02);
    }

    private void setData(int left, int right) {
        mData01 = new ArrayList<>();
        mData02 = new ArrayList<>();
        for (int j = 0; j < left; j++) {
            mData01.add("");
        }
        for (int j = 0; j < right; j++) {
            mData02.add("");
        }
        int leftCount = mData01.size();
        int rightCount = mData02.size();
        if(leftCount/7<=0){
            rvList01.setLayoutManager(new GridLayoutManager(this, leftCount));
        }else{
            rvList01.setLayoutManager(new GridLayoutManager(this, 7));
        }
        if(rightCount/7<=0){
            rvList02.setLayoutManager(new GridLayoutManager(this, rightCount));
        }else{
            rvList02.setLayoutManager(new GridLayoutManager(this, 7));
        }
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_daxiao;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.btn_back, R.id.btn_right, R.id.btn01, R.id.btn02, R.id.btn03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_right:
                break;
            case R.id.btn01:
                if (nowDa.getAnswer() == 1) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn02:
                if (nowDa.getAnswer() == 2) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn03:
                if (nowDa.getAnswer() == 3) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;

        }
    }

    private void getNextQe() {
        nowDa = daXiaoBeans.get(random.nextInt(ranInt));
        tvQ.setText(SpUtils.getShushuNum(this) + ".下面括号应该填什么:");
        setData(nowDa.getLeft(), nowDa.getRight());
        adapter01.notifyDataSetChanged(mData01);
        adapter02.notifyDataSetChanged(mData02);
    }

    private void loadPoint(boolean isRight) {
        SpUtils.setDaxiaoNum(this, SpUtils.getDaxiaoNum(this) + 1);
        if (isRight) {
            SpUtils.setUserPoints(this, SpUtils.getUserPoints(this) + 10);
            showToast("答对了，加10分！当前总分：" + SpUtils.getUserPoints(this) + "分！");
        } else {
            SpUtils.setUserPoints(this, SpUtils.getUserPoints(this) - 5);
            showToast("答错了，减5分！");
        }
        getNextQe();
    }

    private class MyAdapter extends BaseAdapter<String> {

        public MyAdapter(Context context, int layoutId, ArrayList<String> data) {
            super(context, layoutId, data);
        }

        @Override
        public void initItemView(BaseViewHolder holder, String string, int position) {
        }
    }
}
