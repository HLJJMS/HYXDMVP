package com.example.administrator.hyxdmvp;

public class AppConfig {
    //测试服
//    public static String Url = "http://tst.zhongqizhiyun.com:8020/api/ZQZYBasicsApi/";
    public static String UrlApp() {
        return Url + AfterUrl;
    }

    public static String Url = "http://192.168.1.137:8666";
    public static String AfterUrl = "/api/ZQZYBasicsApi/";
//    正式服
//    public static String UrlApp = " https://www.yunerpoa.com/api/ZQZYBasicsApi/";

    //正式服通用查询
    public final static String General = "CommonList?";
    //水处理服
//    public final static String Url = "https://www.yunerpoa.com/api/WaterTreatApi/";
    //公司编码
    public static String CPCode = "";
    //账号
    public static String UserId;
    //员工编号
    public static String Id = "";
    //账号在SharedPreferences
    public static final String UserIdSharedPreferences = "UserId";
    //密码在SharedPreferences
    public static final String PassWordSharedPreferences = "PassWord";
    //服务器在SharedPreferences
    public static final String ServiceSharedPreferences = "Service";

    //    树形列表
    public static String TreeMenuTestUrl() {
        return new StringBuffer().append(UrlApp()).append(General).append("a=utree(%27").append(UserId).append("%27)&b=3|4|5|6|8|9|10|12").toString();
    }

    //工作计划

    public static final String WorkPlanUrl(){
        return new StringBuffer().append(UrlApp()).append(General).append("a=TR0003&b=0|12|10|9|4&d=1::").append(CPCode).toString();
    }
    //员工人名下拉

    public static String SpinnerForUserUrl(){
        return new StringBuffer().append(UrlApp()).append(General).append( "a=t50000&b=2&d=1::").append(AppConfig.CPCode).toString();
    }
    //获取用户列表
    public static String UserManagerUrl() {
        return new StringBuffer().append(UrlApp()).append(General).append("a=TP0000&b=53|24|2|3|87|32&d=1::").append(CPCode).toString();
    }
}
