package com.example.bsproperty.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsproperty.R;
import com.example.bsproperty.bean.UserBean;
import com.example.bsproperty.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViipActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.tv_nic)
    TextView tvNic;
    @BindView(R.id.tv_point)
    TextView tvPoint;
    @BindView(R.id.ima_vip)
    ImageView imaVip;
    private UserBean userBean;

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvTitle.setText("知识树");
        userBean=SpUtils.getUserBean(this);
        if (userBean!=null){
            tvNic.setText("你好，"+userBean.getUsername()+"！");
        }else{
            tvNic.setText("你好，游客001！");
        }
        int point=SpUtils.getUserPoints(this);
        if (point<=50){
            tvPoint.setText("当前等级：V1("+point+"/50)");
            imaVip.setImageResource(getResources().getIdentifier("v1", "mipmap", getPackageName()));
        }else if(point>50&&point<=110){
            tvPoint.setText("当前等级：V2("+point+"/110)");
            imaVip.setImageResource(getResources().getIdentifier("v2", "mipmap", getPackageName()));
        }else if(point>110&&point<=180){
            tvPoint.setText("当前等级：V3("+point+"/180)");
            imaVip.setImageResource(getResources().getIdentifier("v3", "mipmap", getPackageName()));
        }else if(point>180&&point<=300){
            tvPoint.setText("当前等级：V4("+point+"/300)");
            imaVip.setImageResource(getResources().getIdentifier("v4", "mipmap", getPackageName()));
        }else {
            tvPoint.setText("当前等级：V5("+point+"/10000)");
            imaVip.setImageResource(getResources().getIdentifier("v5", "mipmap", getPackageName()));
        }

    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_viip;
    }

    @Override
    protected void loadData() {

    }


    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        this.finish();
    }
}
