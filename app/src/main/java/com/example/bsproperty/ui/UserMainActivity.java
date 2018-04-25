package com.example.bsproperty.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.bean.DaxiaoBean;
import com.example.bsproperty.bean.UserBean;
import com.example.bsproperty.utils.SpUtils;
import com.example.bsproperty.view.ModifyItemDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserMainActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    private long backTime;
    private UserBean userBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnBack.setVisibility(View.GONE);
        userBean = SpUtils.getUserBean(this);
        tvTitle.setText("乐园首页");
        if (userBean == null) {
            new ModifyItemDialog(mContext)
                    .setTitle("新用户登记")
                    .setMessage("请输入您的昵称：")
                    .setOkClick("确认", new ModifyItemDialog.OnOkClickListener() {
                                @Override
                                public void onOkClick(String etStr) {
                                    if (!TextUtils.isEmpty(etStr)) {
                                        UserBean u = new UserBean();
                                        u.setPoints(0);
                                        u.setUsername(etStr);
                                        SpUtils.setUserBean(UserMainActivity.this, u);
                                        Toast.makeText(mContext, "你好，" + etStr + "！", Toast.LENGTH_SHORT).show();
                                        userBean = u;
                                    } else {
                                        Toast.makeText(mContext, "尚未输入昵称，成绩将不会记录！", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    ).show();
        }
        MyApplication.getInstance().setUserBean(userBean);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected int getRootViewId() {
        return R.layout.activity_user_main;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - backTime < 2000) {
            super.onBackPressed();
        } else {
            showToast(this, "再按一次，退出程序");
            backTime = System.currentTimeMillis();
        }
        backTime = System.currentTimeMillis();
    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(mContext, RenShuActivity.class));
                // 学数字
                break;
            case R.id.btn2:
                // 学数数
                startActivity(new Intent(this, ShuShuActivity.class));
                break;
            case R.id.btn3:
                // 学比较
                startActivity(new Intent(this, DaxiaoActivity.class));
                break;
            case R.id.btn4:
                // 学计算
                startActivity(new Intent(this, TestActivity.class));
                break;
            case R.id.btn5:
                // 速算模式
                startActivity(new Intent(this, FastActivity.class));
                break;
            case R.id.btn6:
                // 考试模式
                startActivity(new Intent(this, KaoshiActivity.class));
                break;
            case R.id.btn7:
                // 知识树
                startActivity(new Intent(this, ViipActivity.class));
                break;
        }
    }
}
