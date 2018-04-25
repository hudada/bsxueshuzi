package com.example.bsproperty;

import android.app.Application;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;
import com.example.bsproperty.bean.DaxiaoBean;
import com.example.bsproperty.bean.RenshuBean;
import com.example.bsproperty.bean.ShuShuBean;
import com.example.bsproperty.bean.TestBean;
import com.example.bsproperty.bean.UserBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by yezi on 2018/1/27.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private UserBean userBean;
    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat formatHms = new SimpleDateFormat("mm:ss");
    private static ArrayList<ShuShuBean> shuShuBeans;
    private static ArrayList<DaxiaoBean> daXiaoBeans;
    public static SpeechSynthesizer mSpeechSynthesizer;
    private ArrayList<RenshuBean> renshuBeans;
    private static ArrayList<TestBean> testBeans;



    @Override
    public void onCreate() {
        super.onCreate();
        loadShuShuBeans();
        loadDaxiaoBeans();
        loadTestBeans();
        mSpeechSynthesizer = SpeechSynthesizer.getInstance();
        mSpeechSynthesizer.setContext(this);
        mSpeechSynthesizer.setAppId("11150934");
        mSpeechSynthesizer.setApiKey("EjvbqSLMrAiRTj5qCdI3E6FY",
                "kUIhNZjRBCUZmgFxMSOrMtg9u4GoAvPL");
        mSpeechSynthesizer.auth(TtsMode.ONLINE);
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0");
        mSpeechSynthesizer.initTts(TtsMode.MIX);
    }

    private static void loadShuShuBeans() {
        shuShuBeans = new ArrayList<>();
        ShuShuBean s01 = new ShuShuBean(1, 1, new int[]{0, 1, 2, 3}, 2);
        ShuShuBean s02 = new ShuShuBean(2, 3, new int[]{0, 1, 2, 3}, 4);
        ShuShuBean s03 = new ShuShuBean(3, 5, new int[]{3, 4, 5, 6}, 3);
        ShuShuBean s04 = new ShuShuBean(4, 6, new int[]{3, 4, 5, 6}, 4);
        ShuShuBean s05 = new ShuShuBean(5, 9, new int[]{7, 8, 9, 10}, 3);
        ShuShuBean s06 = new ShuShuBean(6, 11, new int[]{11, 13, 14, 15}, 1);
        ShuShuBean s07 = new ShuShuBean(7, 13, new int[]{9, 10, 11, 13}, 4);
        ShuShuBean s08 = new ShuShuBean(8, 15, new int[]{13, 15, 17, 19}, 2);
        ShuShuBean s09 = new ShuShuBean(9, 17, new int[]{13, 17, 18, 19}, 2);
        ShuShuBean s10 = new ShuShuBean(10, 19, new int[]{13, 15, 17, 19}, 4);
        shuShuBeans.add(s01);
        shuShuBeans.add(s02);
        shuShuBeans.add(s03);
        shuShuBeans.add(s04);
        shuShuBeans.add(s05);
        shuShuBeans.add(s06);
        shuShuBeans.add(s07);
        shuShuBeans.add(s08);
        shuShuBeans.add(s09);
        shuShuBeans.add(s10);
    }

    private static void loadDaxiaoBeans() {
        daXiaoBeans = new ArrayList<>();
        DaxiaoBean da01 = new DaxiaoBean(1, 1, 1, 3);
        DaxiaoBean da02 = new DaxiaoBean(2, 5, 6, 2);
        DaxiaoBean da03 = new DaxiaoBean(3, 3, 7, 2);
        DaxiaoBean da04 = new DaxiaoBean(4, 10, 7, 1);
        DaxiaoBean da05 = new DaxiaoBean(5, 13, 11, 1);
        DaxiaoBean da06 = new DaxiaoBean(6, 4, 4, 3);
        DaxiaoBean da07 = new DaxiaoBean(7, 20, 16, 1);
        DaxiaoBean da08 = new DaxiaoBean(8, 10, 10, 3);
        DaxiaoBean da09 = new DaxiaoBean(9, 7, 8, 2);
        DaxiaoBean da10 = new DaxiaoBean(10, 12, 14, 2);
        daXiaoBeans.add(da01);
        daXiaoBeans.add(da02);
        daXiaoBeans.add(da03);
        daXiaoBeans.add(da04);
        daXiaoBeans.add(da05);
        daXiaoBeans.add(da06);
        daXiaoBeans.add(da07);
        daXiaoBeans.add(da08);
        daXiaoBeans.add(da09);
        daXiaoBeans.add(da10);

    }

    public ArrayList<RenshuBean> getRenshuBeans() {
        return renshuBeans;
    }
    public static ArrayList<TestBean> getTestBeans() {
        return testBeans;
    }
    public void loadRenshuBeans() {
        renshuBeans = new ArrayList<>();
        RenshuBean ren00 = new RenshuBean(0, 0,
                "tu_00", "líng （点击听读音）", "0像鸡蛋圆又圆。");
        RenshuBean ren01 = new RenshuBean(1, 1,
                "tu_01", "yi （点击听读音）", "1像铅笔细又长。");
        RenshuBean ren02 = new RenshuBean(2, 2,
                "tu_02", "èr （点击听读音）", "2像小鸭水中游。");
        RenshuBean ren03 = new RenshuBean(3, 3,
                "tu_03", "sān （点击听读音）", "3像耳朵听声音。");
        RenshuBean ren04 = new RenshuBean(4, 4,
                "tu_04", "sì （点击听读音）", "4像彩旗随风飘。");
        RenshuBean ren05 = new RenshuBean(5, 5,
                "tu_05", "wǔ （点击听读音）", "5像挂钩能买菜。");
        RenshuBean ren06 = new RenshuBean(6, 6,
                "tu_06", "liù （点击听读音）", "6像哨子滴滴吹。");
        RenshuBean ren07 = new RenshuBean(7, 7,
                "tu_07", "qī （点击听读音）", "7像镰刀割青草。");
        RenshuBean ren08 = new RenshuBean(8, 8,
                "tu_08", "bā （点击听读音）", "8像葫芦能装酒。");
        RenshuBean ren09 = new RenshuBean(9, 9,
                "tu_09", "jiǔ （点击听读音）", "9像勺子能舀汤。");
        renshuBeans.add(ren00);
        renshuBeans.add(ren01);
        renshuBeans.add(ren02);
        renshuBeans.add(ren03);
        renshuBeans.add(ren04);
        renshuBeans.add(ren05);
        renshuBeans.add(ren06);
        renshuBeans.add(ren07);
        renshuBeans.add(ren08);
        renshuBeans.add(ren09);
    }

    private static void loadTestBeans() {
        testBeans = new ArrayList<>();
        TestBean s00 = new TestBean(0, "12÷3-3=?", new int[]{0, 1, 2, 3}, 2);
        TestBean s01 = new TestBean(1, "20+15-5=?", new int[]{20, 25, 30, 35}, 3);
        TestBean s02 = new TestBean(2, "10+15x2=?", new int[]{30, 40, 50, 60}, 2);
        TestBean s03 = new TestBean(3, "2x10÷5=?", new int[]{3, 4, 5, 6}, 2);
        TestBean s04 = new TestBean(4, "1x15x0=?", new int[]{0, 1, 15, 16}, 1);
        TestBean s05 = new TestBean(5, "5+13+12=?", new int[]{27, 28, 29, 30}, 4);
        TestBean s06 = new TestBean(6, "50÷10-5=?", new int[]{0, 10, 15, 20}, 1);
        TestBean s07 = new TestBean(7, "10x10+10=?", new int[]{100, 110, 120, 130}, 2);
        TestBean s08 = new TestBean(8, "3x7x3=?", new int[]{54, 58, 63, 70}, 3);
        TestBean s09 = new TestBean(9, "40-11-20=?", new int[]{3, 7, 8, 9}, 4);
        TestBean s10 = new TestBean(10, "26+15+15=?", new int[]{53, 55, 56, 57}, 3);
        TestBean s11 = new TestBean(11, "200x2-135=?", new int[]{265, 270, 272, 275}, 1);
        TestBean s12 = new TestBean(12, "30x15x2=?", new int[]{600, 700, 800, 900}, 4);
        TestBean s13 = new TestBean(13, "800÷40÷5=?", new int[]{3, 4, 5, 6}, 2);
        TestBean s14 = new TestBean(14, "965x15x0=?", new int[]{0, 1, 50, 76}, 1);
        TestBean s15 = new TestBean(15, "550+130-212=?", new int[]{427, 438, 459, 468}, 4);
        TestBean s16 = new TestBean(16, "350÷10-25=?", new int[]{0, 10, 15, 20}, 2);
        TestBean s17 = new TestBean(17, "130+220÷10=?", new int[]{35, 70, 152, 350}, 3);
        TestBean s18 = new TestBean(18, "200+15-55=?", new int[]{130, 150, 160, 170}, 3);
        TestBean s19 = new TestBean(19, "800+105-305=?", new int[]{500, 600, 700, 800}, 2);
        testBeans.add(s01);
        testBeans.add(s02);
        testBeans.add(s03);
        testBeans.add(s04);
        testBeans.add(s05);
        testBeans.add(s06);
        testBeans.add(s07);
        testBeans.add(s08);
        testBeans.add(s09);
        testBeans.add(s10);
        testBeans.add(s11);
        testBeans.add(s12);
        testBeans.add(s13);
        testBeans.add(s14);
        testBeans.add(s15);
        testBeans.add(s16);
        testBeans.add(s17);
        testBeans.add(s18);
        testBeans.add(s19);
        testBeans.add(s00);
    }

    public static ArrayList<DaxiaoBean> getDaXiaoBeans() {
        return daXiaoBeans;
    }

    public ArrayList<ShuShuBean> getShuShuBeans() {
        return shuShuBeans;
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();

        }
        return instance;
    }


    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

}
