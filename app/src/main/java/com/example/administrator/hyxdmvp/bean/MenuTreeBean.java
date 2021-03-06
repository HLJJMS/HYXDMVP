package com.example.administrator.hyxdmvp.bean;

import java.util.List;

public class MenuTreeBean {

    /**
     * code : 0
     * data :
     * detial : null
     * message : 操作成功
     * myDynamicData : [{"F0003":"M000006","F0004":"一级菜单","F0005":"M000007","F0006":"销售管理","F0008":10,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000010","F0006":"库存管理","F0008":20,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000135","F0006":"VMI库房管理","F0008":99,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000175","F0006":"文档管理","F0008":125,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000182","F0006":"PO跟踪","F0008":120,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000219","F0006":"发货信息跟踪","F0008":0,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000235","F0006":"会员管理","F0008":10,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000260","F0006":"培训管理","F0008":0,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000078","F0006":"工业水处理平台","F0008":320,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000080","F0006":"测试菜单","F0008":1000,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000092","F0006":"备货计划管理","F0008":99,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000099","F0006":"会议管理","F0008":90,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000130","F0006":"供方绩效","F0008":100,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000040","F0006":"生产管理","F0008":40,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000042","F0006":"人力资源","F0008":50,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000049","F0006":"微信商城","F0008":80,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000052","F0006":"系统设置","F0008":100,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000056","F0006":"配置管理","F0008":990,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000071","F0006":"项目管理","F0008":123,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000026","F0006":"采购管理","F0008":30,"F0010":0},{"F0003":"M000006","F0004":"一级菜单","F0005":"M000039","F0006":"基础数据","F0008":70,"F0010":0},{"F0003":"M000007","F0004":"销售管理","F0005":"M000008","F0006":"销售订单","F0008":10,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000009","F0006":"发货申请","F0008":20,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000012","F0006":"出库管理","F0008":30,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000013","F0006":"回款管理","F0008":40,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000014","F0006":"销售发票","F0008":50,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000015","F0006":"销售报表","F0008":60,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000016","F0006":"销售基础数据","F0008":110,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000017","F0006":"货运单管理","F0008":35,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000018","F0006":"服务完成","F0008":90,"F0010":1},{"F0003":"M000007","F0004":"销售管理","F0005":"M000126","F0006":"销售订单确认","F0008":70,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000011","F0006":"其他入库","F0008":10,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000019","F0006":"盘盈入库","F0008":20,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000020","F0006":"期初入库","F0008":30,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000021","F0006":"赠品出库","F0008":40,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000268","F0006":"商品组合","F0008":110,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000269","F0006":"商品拆装","F0008":120,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000096","F0006":"我的VMI库存","F0008":200,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000022","F0006":"盘亏出库","F0008":50,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000023","F0006":"其他出库","F0008":60,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000024","F0006":"库间调拨","F0008":70,"F0010":1},{"F0003":"M000010","F0004":"库存管理","F0005":"M000025","F0006":"库存报表","F0008":80,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000027","F0006":"MRP管理","F0008":10,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000028","F0006":"请购管理","F0008":20,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000033","F0006":"采购订单","F0008":30,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000034","F0006":"入库管理","F0008":40,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000035","F0006":"付款管理","F0008":50,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000037","F0006":"采购发票","F0008":60,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000038","F0006":"采购基础数据","F0008":70,"F0010":1},{"F0003":"M000026","F0004":"采购管理","F0005":"M000061","F0006":"采购报表","F0008":65,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000045","F0006":"存货基础数据","F0008":10,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000046","F0006":"客户基础数据","F0008":20,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000047","F0006":"客户类型数据","F0008":30,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000048","F0006":"供应商数据","F0008":40,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000063","F0006":"库房基础数据","F0008":50,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000129","F0006":"客户信息绑定","F0008":39,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000179","F0006":"税率设置","F0008":100,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000180","F0006":"客户设备绑定","F0008":40,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000275","F0006":"供应商资质审核","F0008":10,"F0010":1},{"F0003":"M000039","F0004":"基础数据","F0005":"M000284","F0006":"供应商基本信息","F0008":10,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000041","F0006":"基础数据(PM)","F0008":990,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000155","F0006":"物料清单管理","F0008":10,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000156","F0006":"生产订单管理","F0008":20,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000157","F0006":"生产子件管理","F0008":30,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000158","F0006":"子件出库管理","F0008":40,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000159","F0006":"成品入库管理","F0008":50,"F0010":1},{"F0003":"M000040","F0004":"生产管理","F0005":"M000169","F0006":"生产成本报表","F0008":100,"F0010":1},{"F0003":"M000042","F0004":"人力资源","F0005":"M000044","F0006":"用户管理","F0008":20,"F0010":1},{"F0003":"M000042","F0004":"人力资源","F0005":"M000062","F0006":"销售员管理","F0008":30,"F0010":1},{"F0003":"M000042","F0004":"人力资源","F0005":"M000118","F0006":"员工管理","F0008":30,"F0010":1},{"F0003":"M000042","F0004":"人力资源","F0005":"M000119","F0006":"部门管理","F0008":70,"F0010":1},{"F0003":"M000049","F0004":"微信商城","F0005":"M000050","F0006":"公众号管理","F0008":40,"F0010":1},{"F0003":"M000049","F0004":"微信商城","F0005":"M000051","F0006":"绑定设备清单","F0008":50,"F0010":1},{"F0003":"M000049","F0004":"微信商城","F0005":"M000064","F0006":"Banner管理","F0008":70,"F0010":1},{"F0003":"M000049","F0004":"微信商城","F0005":"M000065","F0006":"商品分类管理","F0008":80,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000043","F0006":"公司管理","F0008":10,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000053","F0006":"菜单管理","F0008":10,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000054","F0006":"角色管理","F0008":20,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000055","F0006":"菜单权限","F0008":30,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000066","F0006":"货币基础数据","F0008":60,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000146","F0006":"首页管理","F0008":66,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000168","F0006":"群发邮件","F0008":110,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000257","F0006":"业务编号管理","F0008":130,"F0010":1},{"F0003":"M000052","F0004":"系统设置","F0005":"M000272","F0006":"公司资质审核","F0008":10,"F0010":1},{"F0003":"M000056","F0004":"配置管理","F0005":"M000057","F0006":"通用列表","F0008":10,"F0010":1},{"F0003":"M000056","F0004":"配置管理","F0005":"M000058","F0006":"通用表单","F0008":20,"F0010":1},{"F0003":"M000056","F0004":"配置管理","F0005":"M000059","F0006":"基础信息","F0008":30,"F0010":1},{"F0003":"M000056","F0004":"配置管理","F0005":"M000060","F0006":"数据字典","F0008":40,"F0010":1},{"F0003":"M000056","F0004":"配置管理","F0005":"M000242","F0006":"数据初始化","F0008":50,"F0010":1},{"F0003":"M000059","F0004":"基础信息","F0005":"M000275","F0006":"供应商资质审核","F0008":0,"F0010":2},{"F0003":"M000071","F0004":"项目管理","F0005":"M000072","F0006":"主项目信息","F0008":1,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000073","F0006":"确认工作计划","F0008":50,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000074","F0006":"内容标识","F0008":130,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000085","F0006":"项目管理报表","F0008":120,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000101","F0006":"项目管理列表","F0008":20,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000104","F0006":"更新测试环境","F0008":60,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000181","F0006":"工作计划","F0008":0,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000244","F0006":"项目需求查询","F0008":45,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000110","F0006":"内部整体测试","F0008":80,"F0010":1},{"F0003":"M000071","F0004":"项目管理","F0005":"M000117","F0006":"项目需求确认","F0008":50,"F0010":1}]
     */

    private String code;
    private String data;
    private String detial;
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

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
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
         * F0003 : M000006
         * F0004 : 一级菜单
         * F0005 : M000007
         * F0006 : 销售管理
         * F0008 : 10
         * F0010 : 0
         */
        private boolean showChild = false;
        private String F0003;
        private String F0004;
        private String F0005;
        private String F0006;
        private int F0008;
        private String F0009;
        private int F0010;
        private String F0012;

        public boolean isShowChild() {
            return showChild;
        }

        public void setShowChild(boolean showChild) {
            this.showChild = showChild;
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

        public String getF0005() {
            return F0005;
        }

        public void setF0005(String F0005) {
            this.F0005 = F0005;
        }

        public String getF0006() {
            return F0006;
        }

        public void setF0006(String F0006) {
            this.F0006 = F0006;
        }

        public int getF0008() {
            return F0008;
        }

        public void setF0008(int F0008) {
            this.F0008 = F0008;
        }

        public String getF0009() {
            return F0009;
        }

        public void setF0009(String f0009) {
            F0009 = f0009;
        }

        public int getF0010() {
            return F0010;
        }

        public void setF0010(int F0010) {
            this.F0010 = F0010;
        }

        public String getF0012() {
            return F0012;
        }

        public void setF0012(String f0012) {
            F0012 = f0012;
        }
    }
}
