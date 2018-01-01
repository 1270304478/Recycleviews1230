package com.bwei.recycleviews1230;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.bwei.recycleviews1230.fragment.Fragment01;
import com.bwei.recycleviews1230.fragment.Fragment02;
import com.bwei.recycleviews1230.fragment.Fragment03;
import com.bwei.recycleviews1230.fragment.Fragment04;
import com.hjm.bottomtabbar.BottomTabBar;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends FragmentActivity {
    @BindView(R.id.botton_tab_bar)
    BottomTabBar bottonTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottonTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(13)
                .setTabPadding(4,3,5)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.shou_ye02, Fragment01.class)
                .addTabItem("分类",R.drawable.fen_lei, Fragment02.class)
                .addTabItem("购物车",R.drawable.gouwu_che, Fragment03.class)
                .addTabItem("个人",R.drawable.wo_de, Fragment04.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                    }
                });
    }
}
