package com.example.administrator.hyxdmvp.fragment.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.adapter.TreeAdapter;
import com.example.administrator.hyxdmvp.adapter.nodeAdapter.WorkPlanAdapter;
import com.example.administrator.hyxdmvp.adapter.nodeAdapter.UserManageAdapter;
import com.example.administrator.hyxdmvp.fragment.presenter.home.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment implements IHomeFragment {

    Unbinder unbinder;
    @BindView(R.id.tree)
    RecyclerView tree;
    @BindView(R.id.list_data)
    RecyclerView listData;
    @BindView(R.id.menu)
    DrawerLayout menu;
    @BindView(R.id.title)
    TextView title;
    private WorkPlanAdapter workPlanAdapter;
    private UserManageAdapter userManageAdapter;
    private HomePresenter presenter;
    private TreeAdapter treeAdapter;
    private String projectSearchAddUrl = "", userManagerSearchAddUrl = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapterToNew();
        presenter = new HomePresenter(this);
//        给纽带传recycle对象
        presenter.sendRecycleView(listData);
        //获取树形列表数据
        presenter.getTreeList(treeAdapter);
        tree.setAdapter(treeAdapter);
        getRecyclerData("M000118", "");
    }


    //        adapter集合声明
    private void adapterToNew() {
        treeAdapter = new TreeAdapter(this);
        tree.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        tree.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        workPlanAdapter = new WorkPlanAdapter(this, getContext());
        userManageAdapter = new UserManageAdapter(this);
        listData.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        listData.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
        unbinder.unbind();
    }

    //    树形列表点击事件
    public void getRecyclerData(String data, String urlAdd) {
        switch (data) {
            case "M000181":
                title.setText("工作计划");
                listData.setAdapter(workPlanAdapter);
                presenter.getSpinnerForUser(workPlanAdapter);
                presenter.getWorkPlanList(workPlanAdapter, urlAdd);
                projectSearchAddUrl = "";
                break;
            case "M000118":
                title.setText("员工管理");
                listData.setAdapter(userManageAdapter);
                presenter.getUserManagerBean(userManageAdapter, urlAdd);
                userManagerSearchAddUrl = "";
                break;
            default:
                showToast("正在努力开发中.....");
        }
    }

    public void closeDrawerLayout() {
        menu.closeDrawers();
    }

    public void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }
}
