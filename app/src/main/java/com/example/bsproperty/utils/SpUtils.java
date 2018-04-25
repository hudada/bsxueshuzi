package com.example.bsproperty.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.bsproperty.bean.KaoShiBean;
import com.example.bsproperty.bean.KaoShiListBean;
import com.example.bsproperty.bean.UserBean;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by yezi on 2018/1/29.
 */

public class SpUtils {

    private static final String SP_NAME = "sp_name";
    private static final String ABOUT_USER = "about_user";
    private static final String SHUSHU_NUM = "shushu_num";
    private static final String DAXIAO_NUM = "daxiao_num";
    private static final String SUSUAN_MAX = "susuan_max";
    private static final String TEST_NUM = "test_num";
    private static final String USER_POINTS = "user_points";
    private static final String ABOUT_KAOSHI = "about_kaoshi";


    private static SharedPreferences getSp(Context context) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static void setUserBean(Context context, UserBean userBean) {
        if (userBean != null) {
            getSp(context).edit().putString(ABOUT_USER, new Gson().toJson(userBean)).apply();
        }
    }

    public static UserBean getUserBean(Context context) {
        String user = getSp(context).getString(ABOUT_USER, "");
        if (!TextUtils.isEmpty(user)) {
            return new Gson().fromJson(user, UserBean.class);
        } else {
            return null;
        }
    }

    public static void setKaoShiBean(Context context, KaoShiBean kaoShiBean) {
        if (kaoShiBean != null) {
            KaoShiListBean listBean = getKaoShiBean(context);
            if (listBean == null) {
                listBean = new KaoShiListBean();
                ArrayList<KaoShiBean> list = new ArrayList<>();
                listBean.setData(list);
            }
            listBean.getData().add(kaoShiBean);
            getSp(context).edit().putString(ABOUT_KAOSHI, new Gson().toJson(listBean)).apply();
        }
    }

    public static KaoShiListBean getKaoShiBean(Context context) {
        String user = getSp(context).getString(ABOUT_KAOSHI, "");
        if (!TextUtils.isEmpty(user)) {
            return new Gson().fromJson(user, KaoShiListBean.class);
        } else {
            return null;
        }
    }

    public static void setShushuNum(Context context, int num) {
        getSp(context).edit().putInt(SHUSHU_NUM, num).apply();
    }

    public static int getShushuNum(Context context) {
        return getSp(context).getInt(SHUSHU_NUM, 1);
    }

    public static void setDaxiaoNum(Context context, int num) {
        getSp(context).edit().putInt(DAXIAO_NUM, num).apply();
    }

    public static int getDaxiaoNum(Context context) {
        return getSp(context).getInt(DAXIAO_NUM, 1);
    }

    public static void setTestNum(Context context, int num) {
        getSp(context).edit().putInt(TEST_NUM, num).apply();
    }

    public static int getTestNum(Context context) {
        return getSp(context).getInt(TEST_NUM, 1);
    }

    public static void setUserPoints(Context context, int point) {
        getSp(context).edit().putInt(USER_POINTS, point).apply();
    }

    public static int getSusuanMax(Context context) {
        return getSp(context).getInt(SUSUAN_MAX, 0);
    }

    public static void setSusuanMax(Context context, int point) {
        getSp(context).edit().putInt(SUSUAN_MAX, point).apply();
    }

    public static int getUserPoints(Context context) {
        return getSp(context).getInt(USER_POINTS, 0);
    }

    public static boolean cleanUserBean(Context context) {
        return getSp(context).edit().putString(ABOUT_USER, "").commit();
    }
}
