package com.example.administrator.hyxdmvp;

public class AppConfig {
    //测试服
    public  static String Url = "http://tst.zhongqizhiyun.com:8020/api/ZQZYBasicsApi/";
    public  static String UrlApp = "http://192.168.1.137:8666/api/ZQZYBasicsApi/";
    //正式服通用查询
    public final static String General = "CommonList?";
    //水处理服
//    public final static String Url = "https://www.yunerpoa.com/api/WaterTreatApi/";
    //公司编码
    public static String CPCode = "";
    //账号
    public static String UserId = "";
    //员工编号
    public static String Id = "";
    //账号在SharedPreferences
    public static final String UserIdSharedPreferences = "UserId";
    //密码在SharedPreferences
    public static final String PassWordSharedPreferences = "PassWord";
    //测试树形列表
    public static final String TreeMenuTest = "CommonList?a=utree(%27hyadmin%27)&b=3|4|5|6|8|9|10";
    //工作计划
    public static final String ProjectPlan = "CommonList?a=TR0003&b=0|12|10|9|4&d=1::";
}
