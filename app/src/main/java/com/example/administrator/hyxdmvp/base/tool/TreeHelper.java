package com.example.administrator.hyxdmvp.base.tool;

import com.example.administrator.hyxdmvp.bean.MenuTreeBean;

import java.util.ArrayList;
import java.util.List;

//树形列表工具类
public class TreeHelper {
    private int sum;
    private List<MenuTreeBean.MyDynamicDataBean> allNode = new ArrayList<>();

    //    获取根节点
    public List<MenuTreeBean.MyDynamicDataBean> getRoot(List<MenuTreeBean.MyDynamicDataBean> allNode) {
        this.allNode.addAll(allNode);
        sum = allNode.size();
        List<MenuTreeBean.MyDynamicDataBean> rootNode = new ArrayList<MenuTreeBean.MyDynamicDataBean>();
        for (int i = 0; i < allNode.size(); i++) {
            if (allNode.get(i).getF0010() == 0) {
                rootNode.add(allNode.get(i));
            }
        }
        return rootNode;
    }

    //    获取子节点
    public List<MenuTreeBean.MyDynamicDataBean> getChild(String id) {
        List<MenuTreeBean.MyDynamicDataBean> child = new ArrayList<>();
        for (int j = 0; j < sum; j++) {
            if (allNode.get(j).getF0003().equals(id)) {
                child.add(allNode.get(j));
            }
        }
        return child;
    }

    //    关闭子节点
    public List<MenuTreeBean.MyDynamicDataBean> colseChild(String id, int position, List<MenuTreeBean.MyDynamicDataBean> showNode) {
        List<MenuTreeBean.MyDynamicDataBean> closeNode = new ArrayList<>();
        while (position < showNode.size()) {
            if (id.equals(showNode.get(position).getF0003())) {
                closeNode.add(showNode.get(position));
            }
            position++;
        }
        return closeNode;
    }

    //    排序
    public List<MenuTreeBean.MyDynamicDataBean> oderby(List<MenuTreeBean.MyDynamicDataBean> list) {

        return list;
    }

}
