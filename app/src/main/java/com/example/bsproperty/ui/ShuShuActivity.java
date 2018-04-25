package com.example.bsproperty.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.ShuShuBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuShuActivity extends BaseActivity {


    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_q)
    TextView tvQ;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.btn01)
    Button btn01;
    @BindView(R.id.btn02)
    Button btn02;
    @BindView(R.id.btn03)
    Button btn03;
    @BindView(R.id.btn04)
    Button btn04;
    @BindView(R.id.lin_list)
    LinearLayout linList;
    private ArrayList<ShuShuBean> shuShuBeans;
    private Random random;
    private ShuShuBean nowShu;
    private ArrayList<String> mData;
    private MyAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        random = new Random();
        btnRight.setVisibility(View.GONE);
        tvTitle.setText("学数数");
        shuShuBeans = MyApplication.getInstance().getShuShuBeans();
        nowShu = shuShuBeans.get(random.nextInt(10));
        tvQ.setText(SpUtils.getShushuNum(this) + ".下面有几个青柠檬:");
        btn01.setText("A."+nowShu.getAnswers()[0]+"个");
        btn02.setText("B."+nowShu.getAnswers()[1]+"个");
        btn03.setText("C."+nowShu.getAnswers()[2]+"个");
        btn04.setText("D."+nowShu.getAnswers()[3]+"个");
        setData(nowShu.getCount());
        rvList.setLayoutManager(new GridLayoutManager(this, 7));
        adapter = new MyAdapter(mContext, R.layout.item_shushu, mData);
        rvList.setAdapter(adapter);

    }

    private void setData(int count) {
        mData = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            mData.add("");
        }
        if (mData.size() / 7<=0){
            rvList.setLayoutManager(new GridLayoutManager(this, mData.size()));
        }else{
            rvList.setLayoutManager(new GridLayoutManager(this, 7));
        }
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_shushu;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.btn_back, R.id.btn_right, R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_right:
                break;
            case R.id.btn01:
                if (nowShu.getAnswer() == 1) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn02:
                if (nowShu.getAnswer() == 2) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn03:
                if (nowShu.getAnswer() == 3) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
            case R.id.btn04:
                if (nowShu.getAnswer() == 4) {
                    loadPoint(true);
                } else {
                    loadPoint(false);
                }
                break;
        }
    }
    private void getNextQe(){
        nowShu = shuShuBeans.get(random.nextInt(10));
        tvQ.setText(SpUtils.getShushuNum(this) + ".下面有几个青柠檬:");
        setData(nowShu.getCount());
        adapter.notifyDataSetChanged(mData);
        btn01.setText("A."+nowShu.getAnswers()[0]+"个");
        btn02.setText("B."+nowShu.getAnswers()[1]+"个");
        btn03.setText("C."+nowShu.getAnswers()[2]+"个");
        btn04.setText("D."+nowShu.getAnswers()[3]+"个");
    }
    private void loadPoint(boolean isRight) {
        SpUtils.setShushuNum(this,SpUtils.getShushuNum(this)+1);
        if (isRight){
            SpUtils.setUserPoints(this,SpUtils.getUserPoints(this)+10);
            showToast("答对了，加10分！当前总分："+SpUtils.getUserPoints(this)+"分！");
        }else{
            SpUtils.setUserPoints(this,SpUtils.getUserPoints(this)-5);
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
