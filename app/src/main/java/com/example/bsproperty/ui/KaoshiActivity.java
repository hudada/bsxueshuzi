package com.example.bsproperty.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.KaoShiBean;
import com.example.bsproperty.bean.TestBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class KaoshiActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    @BindView(R.id.btn1)
    Button btn1;
    private ArrayList<TestBean> testBeans;
    private ArrayList<TestBean> mData;
    private Random random;
    private KaoshiActivity.MyAdapter adapter;
    private boolean isEnd;
    private long start = -1, end;

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvTitle.setText("考试模式");
        random = new Random();
        testBeans = MyApplication.getTestBeans();
        mData = new ArrayList<>();
        while (true) {
            if (mData.size() < 10) {
                TestBean testBean = testBeans.get(random.nextInt(20));
                if (!mData.contains(testBean)) {
                    mData.add(testBean);
                }
            } else {
                break;
            }
        }
        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new KaoshiActivity.MyAdapter(mContext, R.layout.item_kaoshi, mData);
        rvList.setAdapter(adapter);

        btnRight.setText("成绩单");
        btnRight.setVisibility(View.VISIBLE);
    }


    @Override
    protected int getRootViewId() {
        return R.layout.activity_kaoshi;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.btn_back, R.id.btn1, R.id.btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                for (TestBean testBean : testBeans) {
                    testBean.setSelect(0);
                    testBean.setTrue(false);
                }
                this.finish();
                break;
            case R.id.btn1:
                if (start == -1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    Dialog dialog = builder.setTitle("提示")
                            .setMessage("是否开始考试？")
                            .setNegativeButton("再等等", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    start = System.currentTimeMillis();
                                    btn1.setText("提交试卷");
                                    rvList.setVisibility(View.VISIBLE);
                                }
                            })
                            .create();
                    dialog.show();
                } else {
                    adapter.notifyDataSetChanged(mData);
                    end = System.currentTimeMillis();
                    long total = end - start;
                    int sum = 0;
                    for (TestBean mDatum : mData) {
                        if (mDatum.isTrue()) {
                            sum += 10;
                        }
                    }
                    long curr = System.currentTimeMillis();
                    btn1.setVisibility(View.GONE);
                    KaoShiBean bean = new KaoShiBean();
                    bean.setCurr(curr);
                    bean.setSum(sum);
                    bean.setTotal(total);
                    SpUtils.setKaoShiBean(mContext, bean);
                    isEnd = true;
                }
                break;
            case R.id.btn_right:
                startActivity(new Intent(mContext, ResultActivity.class));
                break;
        }
    }

    private class MyAdapter extends BaseAdapter<TestBean> {

        public MyAdapter(Context context, int layoutId, ArrayList<TestBean> data) {
            super(context, layoutId, data);
        }

        @Override
        public void initItemView(BaseViewHolder holder, TestBean testBean, int position) {
            holder.setText(R.id.tv_test, (position + 1) + ". " + testBean.getQue());
            holder.setText(R.id.rd_01, "A." + testBean.getAnswers()[0]);
            holder.setText(R.id.rd_02, "B." + testBean.getAnswers()[1]);
            holder.setText(R.id.rd_03, "C." + testBean.getAnswers()[2]);
            holder.setText(R.id.rd_04, "D." + testBean.getAnswers()[3]);
            switch (testBean.getSelect()) {
                case 1:
                    ((RadioButton) holder.getView(R.id.rd_01)).setChecked(true);
                    break;
                case 2:
                    ((RadioButton) holder.getView(R.id.rd_02)).setChecked(true);
                    break;
                case 3:
                    ((RadioButton) holder.getView(R.id.rd_03)).setChecked(true);
                    break;
                case 4:
                    ((RadioButton) holder.getView(R.id.rd_04)).setChecked(true);
                    break;
                default:
                    ((RadioButton) holder.getView(R.id.rd_01)).setChecked(false);
                    ((RadioButton) holder.getView(R.id.rd_02)).setChecked(false);
                    ((RadioButton) holder.getView(R.id.rd_03)).setChecked(false);
                    ((RadioButton) holder.getView(R.id.rd_04)).setChecked(false);
                    break;
            }
            holder.getView(R.id.rd_01).setOnClickListener(new MyOnClickListener(1, position));
            holder.getView(R.id.rd_02).setOnClickListener(new MyOnClickListener(2, position));
            holder.getView(R.id.rd_03).setOnClickListener(new MyOnClickListener(3, position));
            holder.getView(R.id.rd_04).setOnClickListener(new MyOnClickListener(4, position));
            String ok = "";
            switch (testBean.getAnswer()) {
                case 1:
                    ok = "(错误！正确答案：A)";
                    break;
                case 2:
                    ok = "(错误！正确答案：B)";
                    break;
                case 3:
                    ok = "(错误！正确答案：C)";
                    break;
                case 4:
                    ok = "(错误！正确答案：D)";
                    break;
            }
            holder.setText(R.id.tv_tip, ok);

            if (isEnd) {
                if (testBean.isTrue()) {
                    holder.getView(R.id.tv_tip).setVisibility(View.GONE);
                } else {
                    holder.getView(R.id.tv_tip).setVisibility(View.VISIBLE);
                }
            } else {
                holder.getView(R.id.tv_tip).setVisibility(View.GONE);
            }
        }
    }

    private class MyOnClickListener implements View.OnClickListener {

        private int result;
        private int position;

        public MyOnClickListener(int result, int position) {
            this.result = result;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            mData.get(position).setSelect(result);
            if (result == mData.get(position).getAnswer()) {
                mData.get(position).setTrue(true);
            } else {
                mData.get(position).setTrue(false);
            }
        }
    }
}
