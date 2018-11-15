package com.example.administrator.hyxdmvp.fragment.presenter.home;

import android.support.v7.widget.RecyclerView;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.adapter.TreeAdapter;
import com.example.administrator.hyxdmvp.adapter.nodeAdapter.WorkPlanAdapter;
import com.example.administrator.hyxdmvp.adapter.nodeAdapter.UserManageAdapter;
import com.example.administrator.hyxdmvp.base.BaseOkHttp;
import com.example.administrator.hyxdmvp.bean.DropDownItem;
import com.example.administrator.hyxdmvp.bean.MenuTreeBean;
import com.example.administrator.hyxdmvp.bean.UserDataBean;
import com.example.administrator.hyxdmvp.bean.UserManagerBean;
import com.example.administrator.hyxdmvp.bean.list.WorkPlanBean;
import com.example.administrator.hyxdmvp.fragment.view.home.IHomeFragment;

import java.util.LinkedList;

public class HomePresenter implements IHomePresenter {
    private IHomeFragment view;
    private RecyclerView listData;

    public HomePresenter(IHomeFragment view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getProjectPlan(String url, BaseOkHttp baseOkHttp) {
    }

    public void sendRecycleView(RecyclerView listData) {
        this.listData = listData;
    }

    public void getTreeList(final TreeAdapter treeAdapter) {
        MenuTreeBean menuBean = new MenuTreeBean();
        BaseOkHttp<MenuTreeBean> baseOkHttp;
        baseOkHttp = new BaseOkHttp<MenuTreeBean>(menuBean, MenuTreeBean.class);
        baseOkHttp.getData(AppConfig.TreeMenuTestUrl(), new BaseOkHttp.CallBack<MenuTreeBean>() {
            @Override
            public void success(MenuTreeBean bean) {
                treeAdapter.setData(bean.getMyDynamicData());
            }

            @Override
            public void fail(String s) {
                view.showToast(s);
            }
        });
        menuBean = null;
    }

    //    获取工作计划列表
    public void getWorkPlanList(final WorkPlanAdapter workPlanAdapter, String projectSearchAddUrl) {
        WorkPlanBean workPlanBean = new WorkPlanBean();
        BaseOkHttp<WorkPlanBean> projectPlanBaseOkhttp = new BaseOkHttp<WorkPlanBean>(workPlanBean, WorkPlanBean.class);
        projectPlanBaseOkhttp.getData(AppConfig.WorkPlanUrl() + projectSearchAddUrl, new BaseOkHttp.CallBack<WorkPlanBean>() {
            @Override
            public void success(WorkPlanBean bean) {
                workPlanAdapter.setData(bean.getMyDynamicData());
                listData.setAdapter(workPlanAdapter);
            }

            @Override
            public void fail(String s) {
                view.showToast(s);
            }
        });
        workPlanBean = null;
    }

    // 获取下拉列表(人名)
    public void getSpinnerForUser(final WorkPlanAdapter workPlanAdapter) {
        UserDataBean userBean = new UserDataBean();
        BaseOkHttp<UserDataBean> baseOkHttp;
        baseOkHttp = new BaseOkHttp<UserDataBean>(userBean, UserDataBean.class);
        baseOkHttp.getData(AppConfig.SpinnerForUserUrl(), new BaseOkHttp.CallBack<UserDataBean>() {
            @Override
            public void success(UserDataBean bean) {
                LinkedList<DropDownItem> mData = new LinkedList<DropDownItem>();
                for (int i = 0; i < bean.getMyDynamicData().size(); i++) {
                    mData.add(new DropDownItem(bean.getMyDynamicData().get(i).getF0002(), bean.getMyDynamicData().get(i).getF0002()));
                }
                workPlanAdapter.setDownList(mData);
            }

            @Override
            public void fail(String s) {
                view.showToast(s);
            }
        });
        userBean = null;
    }

    //获取用户列表
    public void getUserManagerBean(final UserManageAdapter userManageAdapter, String userManagerSearchAddUrl) {
        UserManagerBean userManagerBean = new UserManagerBean();
        BaseOkHttp<UserManagerBean> userManagerBaseOkhttp = new BaseOkHttp<UserManagerBean>(userManagerBean, UserManagerBean.class);
        userManagerBaseOkhttp.getData(AppConfig.UserManagerUrl() + userManagerSearchAddUrl, new BaseOkHttp.CallBack<UserManagerBean>() {

            @Override
            public void success(UserManagerBean bean) {
                userManageAdapter.setData(bean.getMyDynamicData());
                listData.setAdapter(userManageAdapter);
            }

            @Override
            public void fail(String s) {
                view.showToast(s);
            }
        });
        userManagerBean = null;
    }


}
