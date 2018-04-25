package com.example.bsproperty.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.RenshuBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RenshuInfoActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_duyin)
    TextView tvDuyin;
    @BindView(R.id.tv_erge)
    TextView tvErge;
    @BindView(R.id.img_tu)
    ImageView imgTu;
    @BindView(R.id.tv_num)
    TextView tvNum;
    private ArrayList<RenshuBean> renshuBeans;
    private RenshuBean renshuBean;
    private ArrayList<String> mData;
    private RenshuInfoActivity.MyAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        MyApplication.getInstance().loadRenshuBeans();
        renshuBeans=MyApplication.getInstance().getRenshuBeans();
        renshuBean= renshuBeans.get(getIntent().getIntExtra("num",0));
        tvDuyin.setText(renshuBean.getDuyin());
        tvErge.setText(renshuBean.getErge());
        MyApplication.mSpeechSynthesizer.speak(renshuBean.getErge());
        tvNum.setText(renshuBean.getNum()+"");
        tvTitle.setText("数字"+renshuBean.getNum()+"的介绍");
        imgTu.setImageResource(getResources().getIdentifier(renshuBean.getImaId(), "mipmap", getPackageName()));
        setData(renshuBean.getNum());
        rvList.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new RenshuInfoActivity.MyAdapter(mContext, R.layout.item_shushu, mData);
        rvList.setAdapter(adapter);

    }

    private void setData(int count) {
        mData = new ArrayList<>();
        for (int j = 0; j < count; j++) {
            mData.add("");
        }
//        if (mData.size() / 6<=0){
//            rvList.setLayoutManager(new GridLayoutManager(this, mData.size()));
//        }else{
//            rvList.setLayoutManager(new GridLayoutManager(this, 7));
//        }
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_renshu_info;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.btn_back, R.id.tv_duyin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.tv_duyin:
                MyApplication.mSpeechSynthesizer.speak(renshuBean.getNum()+"");
                break;
        }
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
