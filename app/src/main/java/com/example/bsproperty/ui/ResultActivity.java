package com.example.bsproperty.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.KaoShiBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResultActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private ArrayList<KaoShiBean> mData = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvTitle.setText("成绩单");
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_result;
    }

    @Override
    protected void loadData() {
        if (SpUtils.getKaoShiBean(mContext) != null){
            mData = SpUtils.getKaoShiBean(mContext).getData();
        }
        adapter = new MyAdapter(mContext, R.layout.item_kaoshi_result, mData);
        rvList.setAdapter(adapter);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }

    private class MyAdapter extends BaseAdapter<KaoShiBean> {

        public MyAdapter(Context context, int layoutId, ArrayList<KaoShiBean> data) {
            super(context, layoutId, data);
        }

        @Override
        public void initItemView(BaseViewHolder holder, KaoShiBean kaoShiBean, int position) {
            holder.setText(R.id.tv_total, "得分：" + kaoShiBean.getSum());
            holder.setText(R.id.tv_time, "用时：" + MyApplication.formatHms.format(kaoShiBean.getTotal()));
            holder.setText(R.id.tv_date, MyApplication.format.format(kaoShiBean.getCurr()));
        }
    }
}
