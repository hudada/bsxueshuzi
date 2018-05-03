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
        ShuShuBean s01 = new ShuShuBean(1, 5, new int[]{5, 4, 7, 6}, 1);
        ShuShuBean s02 = new ShuShuBean(2, 3, new int[]{5, 4, 2, 3}, 4);
        ShuShuBean s03 = new ShuShuBean(3, 1, new int[]{3, 4, 1, 2}, 3);
        ShuShuBean s04 = new ShuShuBean(4, 2, new int[]{3, 5, 1, 2}, 4);
        ShuShuBean s05 = new ShuShuBean(5, 6, new int[]{3, 6, 7, 9}, 2);
        ShuShuBean s06 = new ShuShuBean(6, 4, new int[]{3, 5, 4, 7}, 3);
        ShuShuBean s07 = new ShuShuBean(8, 9, new int[]{11, 6, 7, 9}, 4);
        ShuShuBean s08 = new ShuShuBean(8, 15, new int[]{13, 15, 17, 19}, 2);
        ShuShuBean s09 = new ShuShuBean(9, 7, new int[]{13, 5, 7, 8}, 3);
        ShuShuBean s10 = new ShuShuBean(10, 10, new int[]{10, 7, 11, 9}, 1);
        ShuShuBean s11 = new ShuShuBean(11, 12, new int[]{13, 15, 10, 12}, 4);
        ShuShuBean s12 = new ShuShuBean(12, 14, new int[]{13, 15, 14, 19}, 3);
        ShuShuBean s13 = new ShuShuBean(13, 11, new int[]{11, 10, 12, 13}, 1);
        ShuShuBean s14 = new ShuShuBean(14, 13, new int[]{11, 13, 12, 10}, 2);
        ShuShuBean s15 = new ShuShuBean(15, 15, new int[]{13, 14, 15, 16}, 3);
        ShuShuBean s16 = new ShuShuBean(16, 17, new int[]{13, 15, 16, 17}, 4);
        ShuShuBean s17 = new ShuShuBean(17, 19, new int[]{15, 19, 17, 16}, 2);
        ShuShuBean s18 = new ShuShuBean(18, 16, new int[]{13, 17, 16, 14}, 3);
        ShuShuBean s19 = new ShuShuBean(19, 20, new int[]{16, 15, 17, 20}, 4);
        ShuShuBean s20 = new ShuShuBean(20, 18, new int[]{18, 15, 16, 19}, 1);
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
        shuShuBeans.add(s11);
        shuShuBeans.add(s12);
        shuShuBeans.add(s13);
        shuShuBeans.add(s14);
        shuShuBeans.add(s15);
        shuShuBeans.add(s16);
        shuShuBeans.add(s17);
        shuShuBeans.add(s18);
        shuShuBeans.add(s19);
        shuShuBeans.add(s20);
    }

    private static void loadDaxiaoBeans() {
        daXiaoBeans = new ArrayList<>();
        DaxiaoBean da01 = new DaxiaoBean(1, 2, 4, 2);
        DaxiaoBean da02 = new DaxiaoBean(2, 5, 3, 1);
        DaxiaoBean da03 = new DaxiaoBean(3, 4, 4, 3);
        DaxiaoBean da04 = new DaxiaoBean(4, 6, 1, 1);
        DaxiaoBean da05 = new DaxiaoBean(5, 8, 5, 1);
        DaxiaoBean da06 = new DaxiaoBean(6, 7, 9, 2);
        DaxiaoBean da07 = new DaxiaoBean(7, 4, 6, 2);
        DaxiaoBean da08 = new DaxiaoBean(8, 8, 8, 3);
        DaxiaoBean da09 = new DaxiaoBean(9, 10, 7, 1);
        DaxiaoBean da10 = new DaxiaoBean(10, 9, 5, 1);
        DaxiaoBean da11 = new DaxiaoBean(11, 10, 11, 2);
        DaxiaoBean da12 = new DaxiaoBean(12, 13, 11, 1);
        DaxiaoBean da13 = new DaxiaoBean(13, 12, 14, 2);
        DaxiaoBean da14 = new DaxiaoBean(14, 15, 15, 3);
        DaxiaoBean da15 = new DaxiaoBean(15, 16, 13, 1);
        DaxiaoBean da16 = new DaxiaoBean(16, 15, 16, 2);
        DaxiaoBean da17 = new DaxiaoBean(17, 14, 17, 2);
        DaxiaoBean da18 = new DaxiaoBean(18, 18, 16, 1);
        DaxiaoBean da19 = new DaxiaoBean(19, 19, 19, 3);
        DaxiaoBean da20 = new DaxiaoBean(20, 20, 19, 1);
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
        daXiaoBeans.add(da11);
        daXiaoBeans.add(da12);
        daXiaoBeans.add(da13);
        daXiaoBeans.add(da14);
        daXiaoBeans.add(da15);
        daXiaoBeans.add(da16);
        daXiaoBeans.add(da17);
        daXiaoBeans.add(da18);
        daXiaoBeans.add(da19);
        daXiaoBeans.add(da20);

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
        TestBean s00 = new TestBean(1, "13+9=?", new int[]{20, 22, 24, 21}, 2);
        TestBean s01 = new TestBean(2, "10+25=?", new int[]{45, 46, 35, 37}, 3);
        TestBean s02 = new TestBean(3, "21+55=?", new int[]{76, 66, 78, 68}, 1);
        TestBean s03 = new TestBean(4, "23+41=?", new int[]{56, 54, 62, 64}, 4);
        TestBean s04 = new TestBean(5, "11+23=?", new int[]{45, 44, 34, 36}, 3);
        TestBean s05 = new TestBean(6, "30+18=?", new int[]{46, 48, 54, 45}, 2);
        TestBean s06 = new TestBean(7, "29+71=?", new int[]{100, 99, 101, 103}, 1);
        TestBean s07 = new TestBean(8, "47+36=?", new int[]{85, 82, 84, 83}, 4);
        TestBean s08 = new TestBean(9, "72+7=?", new int[]{80, 79, 81, 78}, 2);
        TestBean s09 = new TestBean(10, "66+34=?", new int[]{100, 99, 101, 98}, 1);
        TestBean s10 = new TestBean(11, "15-5=?", new int[]{9, 10, 7, 11}, 2);
        TestBean s11 = new TestBean(12, "12-12=?", new int[]{0, 1, 10, 2}, 1);
        TestBean s12 = new TestBean(13, "31-20=?", new int[]{10, 11, 9, 12}, 2);
        TestBean s13 = new TestBean(14, "41-11=?", new int[]{29, 31, 30, 20}, 3);
        TestBean s14 = new TestBean(15, "53-32=?", new int[]{31, 22, 20, 21}, 4);
        TestBean s15 = new TestBean(16, "44-37=?", new int[]{8, 7, 9, 10}, 2);
        TestBean s16 = new TestBean(17, "75-14=?", new int[]{61, 60, 59, 80}, 1);
        TestBean s17 = new TestBean(18, "61-55=?", new int[]{5, 8, 7, 6}, 4);
        TestBean s18 = new TestBean(19, "80-38=?", new int[]{41, 40, 42, 43}, 3);
        TestBean s19 = new TestBean(20, "100-25=?", new int[]{74, 75, 70, 76}, 2);
        TestBean s20 = new TestBean(21, "10+5-6=?", new int[]{10, 9, 7, 8}, 2);
        TestBean s21 = new TestBean(22, "15+23-20=?", new int[]{18, 20, 19, 21}, 1);
        TestBean s22 = new TestBean(23, "21+10+35=?", new int[]{65, 56, 66, 67}, 3);
        TestBean s23 = new TestBean(24, "19+11-25=?", new int[]{6, 5, 7, 8}, 2);
        TestBean s24 = new TestBean(25, "35+43-40=?", new int[]{39, 38, 40, 37}, 2);
        TestBean s25 = new TestBean(26, "53-40+60=?", new int[]{72, 71, 70, 73}, 4);
        TestBean s26 = new TestBean(27, "75+25-30=?", new int[]{72, 70, 71, 69}, 2);
        TestBean s27 = new TestBean(28, "86-15-55=?", new int[]{14, 15, 16, 17}, 3);
        TestBean s28 = new TestBean(29, "98-45+34=?", new int[]{86, 85, 87, 88}, 3);
        TestBean s29 = new TestBean(30, "87+10-77=?", new int[]{20, 22, 19, 23}, 1);
        TestBean s30 = new TestBean(31, "3×6=?", new int[]{17, 18, 19, 16}, 2);
        TestBean s31 = new TestBean(32, "7×8=?", new int[]{50, 57, 55, 56}, 4);
        TestBean s32 = new TestBean(33, "10×4=?", new int[]{41, 40, 42, 43}, 2);
        TestBean s33 = new TestBean(34, "5×4=?", new int[]{25, 16, 20, 21}, 3);
        TestBean s34 = new TestBean(35, "10×9=?", new int[]{80, 90, 72, 85}, 2);
        TestBean s35 = new TestBean(36, "9×9=?", new int[]{81, 82, 79, 84}, 1);
        TestBean s36 = new TestBean(37, "8×6=?", new int[]{42, 60,50, 48}, 4);
        TestBean s37 = new TestBean(38, "10×9=?", new int[]{81, 89, 90, 80}, 3);
        TestBean s38 = new TestBean(39, "11×9=?", new int[]{99, 98, 18, 89}, 1);
        TestBean s39 = new TestBean(40, "12×10=?", new int[]{112, 120, 92, 22}, 2);
        TestBean s40 = new TestBean(41, "10÷2=?", new int[]{8, 7, 5, 6}, 3);
        TestBean s41 = new TestBean(42, "18÷6=?", new int[]{6, 4, 5, 3}, 4);
        TestBean s42 = new TestBean(43, "25÷5=?", new int[]{6, 5, 7, 8}, 2);
        TestBean s43 = new TestBean(44, "42÷7=?", new int[]{6, 7, 8, 5}, 1);
        TestBean s44 = new TestBean(45, "54÷6=?", new int[]{5, 7, 9, 8}, 3);
        TestBean s45 = new TestBean(46, "60÷6=?", new int[]{7, 9, 10, 8}, 3);
        TestBean s46 = new TestBean(47, "72÷8=?", new int[]{5, 8, 7, 9}, 4);
        TestBean s47 = new TestBean(48, "56÷7=?", new int[]{7, 8, 9, 6}, 2);
        TestBean s48 = new TestBean(49, "48÷8=?", new int[]{6, 5, 7, 8}, 1);
        TestBean s49 = new TestBean(50, "110÷10=?", new int[]{9, 11, 10, 8}, 2);
        TestBean s50 = new TestBean(51, "2×6÷3=?", new int[]{3, 4, 7, 8}, 2);
        TestBean s51 = new TestBean(52, "4×9÷6=?", new int[]{4, 5, 6, 8}, 3);
        TestBean s52 = new TestBean(53, "5×4÷10=?", new int[]{2, 6, 7, 4}, 1);
        TestBean s53 = new TestBean(54, "8×6÷3=?", new int[]{15, 10, 20, 16}, 4);
        TestBean s54 = new TestBean(55, "7×9÷3=?", new int[]{20, 21, 19, 33}, 2);
        TestBean s55 = new TestBean(56, "7×8÷4=?", new int[]{10, 15, 14, 13}, 3);
        TestBean s56 = new TestBean(57, "9×6÷6=?", new int[]{8, 9, 7, 10}, 2);
        TestBean s57 = new TestBean(58, "5×9÷3=?", new int[]{15, 16, 21, 12}, 1);
        TestBean s58 = new TestBean(59, "10×6÷3=?", new int[]{18, 30, 19, 20}, 4);
        TestBean s59 = new TestBean(60, "12×10÷6=?", new int[]{30, 20, 22, 60}, 2);
        TestBean s60 = new TestBean(61, "(12+12)÷4=?", new int[]{5, 7, 6, 8}, 3);
        TestBean s61 = new TestBean(62, "(35-10)÷5=?", new int[]{8, 5, 6, 7}, 2);
        TestBean s62 = new TestBean(63, "(77-5)÷8=?", new int[]{9, 6, 7, 8}, 1);
        TestBean s63 = new TestBean(64, "48÷8+20=?", new int[]{52, 25, 27, 26}, 4);
        TestBean s64 = new TestBean(65, "12÷4+3×4=?", new int[]{10, 16, 15, 18}, 3);
        TestBean s65 = new TestBean(66, "36÷6-15÷3=?", new int[]{1, 6, 0, 20}, 1);
        TestBean s66 = new TestBean(67, "6×7-22+5=?", new int[]{52, 25, 71, 35}, 2);
        TestBean s67 = new TestBean(68, "81÷9×4-16=?", new int[]{30, 24, 25, 20}, 4);
        TestBean s68 = new TestBean(69, "56×1÷7+13=?", new int[]{25, 26, 21, 28}, 3);
        TestBean s69 = new TestBean(70, "72÷8+35÷7=?", new int[]{14, 16, 17, 18}, 1);
        testBeans.add(s00);
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
        testBeans.add(s20);
        testBeans.add(s21);
        testBeans.add(s22);
        testBeans.add(s23);
        testBeans.add(s24);
        testBeans.add(s25);
        testBeans.add(s26);
        testBeans.add(s27);
        testBeans.add(s28);
        testBeans.add(s29);
        testBeans.add(s30);
        testBeans.add(s31);
        testBeans.add(s32);
        testBeans.add(s33);
        testBeans.add(s34);
        testBeans.add(s35);
        testBeans.add(s36);
        testBeans.add(s37);
        testBeans.add(s38);
        testBeans.add(s39);
        testBeans.add(s40);
        testBeans.add(s41);
        testBeans.add(s42);
        testBeans.add(s43);
        testBeans.add(s44);
        testBeans.add(s45);
        testBeans.add(s46);
        testBeans.add(s47);
        testBeans.add(s48);
        testBeans.add(s49);
        testBeans.add(s50);
        testBeans.add(s51);
        testBeans.add(s52);
        testBeans.add(s53);
        testBeans.add(s54);
        testBeans.add(s55);
        testBeans.add(s56);
        testBeans.add(s57);
        testBeans.add(s58);
        testBeans.add(s59);
        testBeans.add(s60);
        testBeans.add(s61);
        testBeans.add(s62);
        testBeans.add(s63);
        testBeans.add(s64);
        testBeans.add(s65);
        testBeans.add(s66);
        testBeans.add(s67);
        testBeans.add(s68);
        testBeans.add(s69);
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
