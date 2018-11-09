package com.example.administrator.hyxdmvp.ui.view.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.administrator.hyxdmvp.AppConfig;
import com.example.administrator.hyxdmvp.R;
import com.example.administrator.hyxdmvp.adapter.TabAdapter;
import com.example.administrator.hyxdmvp.base.Quit;
import com.example.administrator.hyxdmvp.base.XinGePush;
import com.example.administrator.hyxdmvp.bean.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.gms.common.internal.StringResourceValueReader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.flyco)
    CommonTabLayout flyco;
    private Quit quit = new Quit();
    private Context context;
    private XinGePush xinGePush = new XinGePush();
    private String[] mTitles = {"首页", "订单", "月亮", "我的"};
    private ArrayList<CustomTabEntity> tabBean = new ArrayList<CustomTabEntity>();
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        xinGePush.resigter(MainActivity.this, AppConfig.UserId);
        context = this;
        flycoTab();
        aboutAdapter();
    }

    //    关于适配器方面
    private void aboutAdapter() {
        adapter = new TabAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(3);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }
//            监听view改变tab也跟着改变
            @Override
            public void onPageSelected(int i) {
                flyco.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    //关于flycoTab的设置
    private void flycoTab() {
        for (int i = 0; i < 4; i++) {
            tabBean.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        flyco.setTabData(tabBean);
        //  点击tab绑定
        flyco.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            quit.ClickTwiceQuit(context);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
