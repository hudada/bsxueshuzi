package com.example.bsproperty.ui;

import android.Manifest;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.bsproperty.MyApplication;
import com.example.bsproperty.R;
import com.example.bsproperty.utils.DenstityUtils;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RenShuActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.rl_content)
    FrameLayout rlContent;

    private int mH, mW;
    private Random random;
    private int size, oneP;
    private Thread move;
    private boolean flag;


    @Override
    protected void initView(Bundle savedInstanceState) {


        tvTitle.setText("认识数字");
        mH = DenstityUtils.screenHeight((Activity) mContext);
        mW = DenstityUtils.screenWidth((Activity) mContext);
        random = new Random();
        size = mW / 3;
        oneP = mW - size;
        String permissions[] = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.MODIFY_AUDIO_SETTINGS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_SETTINGS,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限.
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);
        } else {
            move.start();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
        move.start();
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_ren_shu;
    }

    @Override
    protected void loadData() {
        showToast("请点击气球学习数字");
        move = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            newImg();
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        if (move != null) {
//            move.start();
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
    }

    private boolean newImg() {
        final ImageView imageView = new ImageView(mContext);
        final int qq = random.nextInt(10);
        int id = getResources().getIdentifier("qiqiu_0" + qq, "mipmap", getPackageName());
        imageView.setImageResource(id);
        imageView.setY(mH);

        imageView.setX(random.nextInt(oneP));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        ObjectAnimator translationY = new ObjectAnimator().ofFloat(imageView,
                "translationY", mH, -mH - DenstityUtils.px2dp(mContext, 2500));
        translationY.setDuration(12000);
        translationY.start();

        translationY.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (rlContent != null && imageView != null) {
                    rlContent.removeView(imageView);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNext(qq);
            }
        });

        rlContent.addView(imageView, layoutParams);
        return true;
    }

    private void gotoNext(int qq) {
        MyApplication.mSpeechSynthesizer.speak(qq + "");
        Intent intent=new Intent(RenShuActivity.this,RenshuInfoActivity.class);
        intent.putExtra("num",qq);
        startActivity(intent);
        
    }


    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }
}
