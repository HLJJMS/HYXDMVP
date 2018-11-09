package com.example.administrator.hyxdmvp.bean;

import java.util.List;

public class UserManagerBean  {

    /**
     * code : 0
     * data :
     * detial : null
     * message : 操作成功
     * myDynamicData : [{"F0001":10008,"F0002":"HY0001","F0003":"浩业","F0087":null,"F0031":""},{"F0001":10008,"F0002":"E00011","F0003":"赵锦涛","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0002","F0003":"葛小伦","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0003","F0003":"李白","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0004","F0003":"王小龙","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0005","F0003":"钱一多","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0006","F0003":"林凤","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0007","F0003":"白居士","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0008","F0003":"刘明","F0087":null,"F0031":""},{"F0001":10008,"F0002":"HY0009","F0003":"房建伟","F0087":null,"F0031":""},{"F0001":10008,"F0002":"xintest","F0003":"xintest","F0087":null,"F0031":""},{"F0001":10008,"F0002":"xinother","F0003":"xinother","F0087":null,"F0031":""}]
     */

    private String code;
    private String data;
    private Object detial;
    private String message;
    private List<MyDynamicDataBean> myDynamicData;

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

    public static class MyDynamicDataBean {
        /**
         * F0001 : 10008
         * F0002 : HY0001
         * F0003 : 浩业
         * F0087 : null
         * F0031 :
         */

        private String F0024;
        private String F0002;
        private String F0003;
        private String F0087;
        private String F0032;
        private String F0054;
        public String getF0024() {
            return F0024;
        }

        public void setF0024(String F0024) {
            this.F0024 = F0024;
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

        public String getF0087() {
            return F0087;
        }

        public void setF0087(String F0087) {
            this.F0087 = F0087;
        }

        public String getF0032() {
            return F0032;
        }

        public void setF0032(String F0032) {
            this.F0032 = F0032;
        }

        public String getF0054() {
            return F0054;
        }

        public void setF0054(String f0054) {
            F0054 = f0054;
        }
    }
}
