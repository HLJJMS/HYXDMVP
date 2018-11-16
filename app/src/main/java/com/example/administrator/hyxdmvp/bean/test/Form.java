package com.example.administrator.hyxdmvp.bean.test;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;

import java.util.List;

public class Form {

    /**
     * code : 0
     * data :
     * detial : null
     * message : 操作成功
     * myDynamicData : [{"F0001":1000,"F0002":"P000115","F0003":2206215,"F0004":"作概要","F0009":0.5,"F0010":"14","F0015":"2018-03-29T13:32:40"},{"F0001":1000,"F0002":"P000116","F0003":4192346,"F0004":"1","F0009":1,"F0010":"14","F0015":"2018-03-30T09:30:33"},{"F0001":1000,"F0002":"P000117","F0003":5404883,"F0004":"首页设计图","F0009":2,"F0010":"14","F0015":"2018-03-29T02:22:33"},{"F0001":1000,"F0002":"P000117","F0003":4132251,"F0004":"项目轮播图","F0009":0.3,"F0010":"14","F0015":"2018-03-30T09:00:00"},{"F0001":1000,"F0002":"P000118","F0003":3496680,"F0004":"上课备课可取消选中","F0009":1,"F0010":"14","F0015":"2018-03-30T00:00:00"},{"F0001":1000,"F0002":"P000119","F0003":318423,"F0004":"支付系统","F0009":1,"F0010":"erpys","F0015":"2018-03-30T00:00:00"},{"F0001":1000,"F0002":"P000121","F0003":8560077,"F0004":"测计划1","F0009":1,"F0010":"erpys","F0015":"2018-03-31T00:00:00"},{"F0001":1000,"F0002":"P000120","F0003":8085437,"F0004":"123","F0009":1,"F0010":"erpys","F0015":"2018-03-31T00:00:00"},{"F0001":1000,"F0002":"P000130","F0003":3215721,"F0004":"姜全海计划信息\u2014\u2014新建计划信息","F0009":0.1,"F0010":"erpys","F0015":"2018-03-31T00:00:00"},{"F0001":10008,"F0002":"P000133","F0003":4085015,"F0004":"测试一项工作计划工作反反复复","F0009":1,"F0010":"hy1adm","F0015":"2018-04-11T00:00:00"},{"F0001":10008,"F0002":"P000133","F0003":2723069,"F0004":"策划一个工作计划这是工作概要","F0009":1,"F0010":"hyadmin","F0015":"2018-04-11T00:00:00"},{"F0001":10008,"F0002":"P000133","F0003":9445098,"F0004":"工作概要测试","F0009":1,"F0010":"hyadmin","F0015":"2018-04-11T00:00:00"},{"F0001":10008,"F0002":"P000133","F0003":2657204,"F0004":"123123","F0009":1,"F0010":"hyadmin","F0015":"2018-04-11T00:00:00"},{"F0001":10008,"F0002":"P000132","F0003":919757,"F0004":" 去工作吧工作计划进","F0009":2,"F0010":"hy4adm","F0015":"2018-04-12T00:00:00"},{"F0001":10008,"F0002":"P000132","F0003":2000617,"F0004":"你要测试吗","F0009":2,"F0010":"hy4adm","F0015":"2018-04-11T00:00:00"},{"F0001":10008,"F0002":"P000133","F0003":3318753,"F0004":"好好工作","F0009":234234,"F0010":"hy4adm","F0015":"2018-04-13T00:00:00"},{"F0001":10008,"F0002":"P000132","F0003":6566385,"F0004":"工作计划二","F0009":1,"F0010":"zhaojt","F0015":"2018-04-19T00:00:00"},{"F0001":10008,"F0002":"P000135","F0003":8569074,"F0004":"测试数据一百","F0009":123,"F0010":"zhaojt","F0015":"2018-04-19T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":5389013,"F0004":"新建一个工作计划","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":2793760,"F0004":"测试数据三","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":121573,"F0004":"测试数据四","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":4005824,"F0004":"测试首页接口数据","F0009":1,"F0010":"zhaojt","F0015":"2018-04-19T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":4486930,"F0004":"你好吗这是以一个测试数据","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":3376284,"F0004":"这是测试数据","F0009":1,"F0010":"zhaojt","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000137","F0003":6546906,"F0004":"号好好","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000137","F0003":7315005,"F0004":"测试首页接口数据完整性","F0009":111,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000137","F0003":9438829,"F0004":"456","F0009":1,"F0010":"hyadmin","F0015":"2018-04-21T00:00:00"},{"F0001":10008,"F0002":"P000138","F0003":7722460,"F0004":"测试状态","F0009":1,"F0010":"zhaojt","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000139","F0003":9005633,"F0004":"测试 负责人","F0009":1,"F0010":"zhaojt","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000140","F0003":2435610,"F0004":"1.8测试","F0009":1,"F0010":"zhaojt","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000137","F0003":6597394,"F0004":"1.8测试","F0009":1,"F0010":"hyadmin","F0015":"2018-04-20T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":4944983,"F0004":"找回密码","F0009":1,"F0010":"zhaojt","F0015":"2018-06-15T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":5520336,"F0004":"找回密码","F0009":323,"F0010":"zhaojt","F0015":"2018-06-14T00:00:00"},{"F0001":10008,"F0002":"P000189","F0003":3640050,"F0004":"会议讨论","F0009":1,"F0010":"hy5adm","F0015":"2018-06-19T00:00:00"},{"F0001":10008,"F0002":"P000189","F0003":9367222,"F0004":"2345","F0009":1,"F0010":"hy2adm","F0015":"2018-06-21T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":3669920,"F0004":"工作概要","F0009":432,"F0010":"hy1adm","F0015":"2018-06-30T00:00:00"},{"F0001":10008,"F0002":"P000141","F0003":4974507,"F0004":"1","F0009":2,"F0010":"hyadmin","F0015":"2018-06-21T00:00:00"},{"F0001":10008,"F0002":"P000141","F0003":2894687,"F0004":"1","F0009":1,"F0010":"hyadmin","F0015":"2018-06-21T00:00:00"},{"F0001":10008,"F0002":"P000136","F0003":212833,"F0004":"11","F0009":1,"F0010":"hyadmin","F0015":"2018-06-25T00:00:00"},{"F0001":10008,"F0002":"P000189","F0003":1203984,"F0004":"1","F0009":1,"F0010":"hy1adm","F0015":"2018-07-05T00:00:00"},{"F0001":10008,"F0002":"P000225","F0003":5495211,"F0004":"更新环境，外出演示","F0009":1.5,"F0010":"hy2adm","F0015":"2018-07-27T00:00:00"},{"F0001":10008,"F0002":"P000126","F0003":227094,"F0004":"更新环境，外出演示","F0009":1,"F0010":"hy2adm","F0015":"2018-07-28T00:00:00"},{"F0001":10008,"F0002":"P000126","F0003":418599,"F0004":"更新环境，外出演示","F0009":1,"F0010":"hyadmin","F0015":"2018-07-28T00:00:00"},{"F0001":10008,"F0002":"P000224","F0003":4894296,"F0004":"更新环境，外出演示","F0009":0.5,"F0010":"hy2adm","F0015":"2018-07-30T00:00:00"},{"F0001":10008,"F0002":"P000224","F0003":6733191,"F0004":"林强测试 ","F0009":0.5,"F0010":"hy2adm","F0015":"2018-07-30T00:00:00"},{"F0001":10008,"F0002":"P000190","F0003":4617432,"F0004":"123","F0009":1,"F0010":"hyadmin","F0015":"2018-07-29T00:00:00"},{"F0001":10008,"F0002":"P000168","F0003":8557560,"F0004":"林强测试-人力","F0009":1,"F0010":"hy2adm","F0015":"2018-08-22T00:00:00"},{"F0001":10008,"F0002":"P000172","F0003":8006001,"F0004":"林强测试-人力1","F0009":1,"F0010":"hy2adm","F0015":"2018-08-22T00:00:00"},{"F0001":10008,"F0002":"P000224","F0003":2010311,"F0004":"测试","F0009":1,"F0010":"hyadmin","F0015":"2018-08-21T00:00:00"},{"F0001":10008,"F0002":"P000134","F0003":3227028,"F0004":"2018-08-20","F0009":111,"F0010":"hy1adm","F0015":"2018-09-06T00:00:00"},{"F0001":10008,"F0002":"P000134","F0003":3327417,"F0004":"测试1","F0009":1,"F0010":"hyadmin","F0015":"2018-08-21T00:00:00"},{"F0001":10008,"F0002":"P000134","F0003":10040868,"F0004":"供应商数据报表","F0009":2,"F0010":"hy2adm","F0015":"2018-08-22T00:00:00"},{"F0001":10008,"F0002":"P000187","F0003":2647313,"F0004":"123123","F0009":1,"F0010":"hyadmin","F0015":"2018-08-21T00:00:00"},{"F0001":10008,"F0002":"P000187","F0003":5536537,"F0004":"12312","F0009":1,"F0010":"hyadmin","F0015":"2018-08-21T00:00:00"},{"F0001":10008,"F0002":"P000187","F0003":448517,"F0004":"123","F0009":1,"F0010":"hyadmin","F0015":"2018-08-21T00:00:00"},{"F0001":0,"F0002":"P000191","F0003":5336297,"F0004":"撒的发生的","F0009":1,"F0010":"apkgy","F0015":"2018-08-31T00:00:00"},{"F0001":10008,"F0002":"P000224","F0003":7547551,"F0004":"水处理09-06","F0009":1,"F0010":"hyadmin","F0015":"2018-09-06T00:00:00"},{"F0001":null,"F0002":null,"F0003":null,"F0004":null,"F0009":null,"F0010":null,"F0015":null},{"F0001":10008,"F0002":"P000232","F0003":1425059,"F0004":"1","F0009":4,"F0010":"hyadmin","F0015":"2018-09-14T00:00:00"},{"F0001":0,"F0002":"P000231","F0003":7404626,"F0004":"1111","F0009":9,"F0010":"wqe1","F0015":"2018-09-21T00:00:00"},{"F0001":0,"F0002":"P000233","F0003":415257,"F0004":"1111","F0009":1,"F0010":"wqe1","F0015":"2018-09-14T00:00:00"},{"F0001":10008,"F0002":"P000228","F0003":7490558,"F0004":"111","F0009":4,"F0010":"hyadmin","F0015":"2018-09-10T00:00:00"},{"F0001":10008,"F0002":"P000248","F0003":1418022,"F0004":"1","F0009":1,"F0010":"hyadmin","F0015":"2018-09-19T00:00:00"}]
     */

    private String code;
    private String data;
    private Object detial;
    private String message;
    public List<MyDynamicDataBean> myDynamicData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getDetial() {
        return detial;
    }

    public void setDetial(Object detial) {
        this.detial = detial;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MyDynamicDataBean> getMyDynamicData() {
        return myDynamicData;
    }

    public void setMyDynamicData(List<MyDynamicDataBean> myDynamicData) {
        this.myDynamicData = myDynamicData;
    }
    @SmartTable(name = "工作计划", count = true)
    public class MyDynamicDataBean {
        public MyDynamicDataBean(String f0001, String f0002, String f0003, String f0004, String f0009, String f0010, String f0015) {
            F0001 = f0001;
            F0002 = f0002;
            F0003 = f0003;
            F0004 = f0004;
            F0009 = f0009;
            F0010 = f0010;
            F0015 = f0015;
        }

        /**
         * F0001 : 1000
         * F0002 : P000115
         * F0003 : 2206215
         * F0004 : 作概要
         * F0009 : 0.5
         * F0010 : 14
         * F0015 : 2018-03-29T13:32:40
         */
        @SmartColumn(id = 1, name = "公司编码", fixed = true)
        private String F0001;
        @SmartColumn(id = 2, name = "项目编号")
        private String F0002;
        @SmartColumn(id = 3, name = "节点编号")
        private String F0003;
        @SmartColumn(id = 4, name = "工作概要")
        private String F0004;
        @SmartColumn(id = 5, name = "工作量")
        private String F0009;
        @SmartColumn(id = 6, name = "负责人")
        private String F0010;
        @SmartColumn(id = 7, name = "要求完成日期")
        private String F0015;


        public String getF0001() {
            return F0001;
        }

        public void setF0001(String F0001) {
            this.F0001 = F0001;
        }

        public String getF0002() {
            return F0002;
        }

        public void setF0002(String F0002) {
            this.F0002 = F0002;
        }

        public String getF0003() {
            return F0003;
        }

        public void setF0003(String F0003) {
            this.F0003 = F0003;
        }

        public String getF0004() {
            return F0004;
        }

        public void setF0004(String F0004) {
            this.F0004 = F0004;
        }

        public String getF0009() {
            return F0009;
        }

        public void setF0009(String F0009) {
            this.F0009 = F0009;
        }

        public String getF0010() {
            return F0010;
        }

        public void setF0010(String F0010) {
            this.F0010 = F0010;
        }

        public String getF0015() {
            return F0015;
        }

        public void setF0015(String F0015) {
            this.F0015 = F0015;
        }
    }
}
