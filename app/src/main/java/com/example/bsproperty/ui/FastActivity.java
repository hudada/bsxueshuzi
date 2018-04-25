package com.example.bsproperty.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.bean.TestBean;
import com.example.bsproperty.utils.SpUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FastActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_max)
    TextView tvMax;
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
    private CountDownTimer timer;
    private int mTotal = 0;
    private int lishiMax = 0;

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvTitle.setText("快速计算");
        lishiMax = SpUtils.getSusuanMax(this);
        tvMax.setText("最佳成绩：" + lishiMax + "道");
        timer = new CountDownTimer(21 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (tvTitle != null) {
                    tvTitle.setText("剩余时间" + millisUntilFinished / 1000 + "秒");
                }
            }

            @Override
            public void onFinish() {
                if (tvTitle != null) {
                    tvTitle.setText("快速计算");
                    if (mTotal > lishiMax) {
                        SpUtils.setSusuanMax(FastActivity.this, mTotal);
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    Dialog dialog = builder.setTitle("提示")
                            .setMessage("挑战结束，您总共答对了" + mTotal + "道题！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ((BaseActivity) mContext).finish();
                                }
                            })
                            .create();
                    dialog.setCancelable(false);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();
                }
            }
        };
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_fast;
    }

    @Override
    protected void loadData() {
        random = new Random();
        btnRight.setVisibility(View.GONE);
        testBeans = MyApplication.getTestBeans();
        nowTest = testBeans.get(random.nextInt(20));
        tvTestnum.setText("当前已答对" + mTotal + "道题");
        tvTest.setText(nowTest.getQue());
        btn01.setText("A." + nowTest.getAnswers()[0]);
        btn02.setText("B." + nowTest.getAnswers()[1]);
        btn03.setText("C." + nowTest.getAnswers()[2]);
        btn04.setText("D." + nowTest.getAnswers()[3]);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        Dialog dialog = builder.setTitle("提示")
                .setMessage("是否开始挑战？")
                .setNegativeButton("再等等", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((BaseActivity) mContext).finish();
                    }
                })
                .setPositiveButton("是的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        timer.start();
                    }
                })
                .create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @OnClick({R.id.btn_back, R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn01:
                if (nowTest.getAnswer() == 1) {
                    mTotal++;
                    getNextQe();
                } else {
                    showToast("回答错误，再想想把！");
                }
                break;
            case R.id.btn02:
                if (nowTest.getAnswer() == 2) {
                    mTotal++;
                    getNextQe();
                } else {
                    showToast("回答错误，再想想把！");
                }
                break;
            case R.id.btn03:
                if (nowTest.getAnswer() == 3) {
                    mTotal++;
                    getNextQe();
                } else {
                    showToast("回答错误，再想想把！");
                }
                break;
            case R.id.btn04:
                if (nowTest.getAnswer() == 4) {
                    mTotal++;
                    getNextQe();
                } else {
                    showToast("回答错误，再想想把！");
                }
                break;
        }
    }

    private void getNextQe() {
        if (mTotal > lishiMax) {
            tvMax.setText("最佳成绩：" + mTotal + "道");
        }
        nowTest = testBeans.get(random.nextInt(20));
        tvTestnum.setText("当前已答对" + mTotal + "道题");
        tvTest.setText(nowTest.getQue());
        btn01.setText("A." + nowTest.getAnswers()[0]);
        btn02.setText("B." + nowTest.getAnswers()[1]);
        btn03.setText("C." + nowTest.getAnswers()[2]);
        btn04.setText("D." + nowTest.getAnswers()[3]);
    }

}
