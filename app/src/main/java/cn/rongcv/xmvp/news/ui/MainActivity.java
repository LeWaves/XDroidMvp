package cn.rongcv.xmvp.news.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.rongcv.xmvp.news.R;
import cn.waves.xmvp.base.XFragmentAdapter;
import cn.waves.xmvp.mvp.XActivity;


/**
 * Created by wanglei on 2016/12/22.
 */

public class MainActivity extends XActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    List<Fragment> fragmentList = new ArrayList<>();
    String[] tabName = {"首页", "干货", "美图"};
    int[] tab_img = {R.drawable.tab_home_img,R.drawable.tab_home_img, R.drawable.tab_home_img};

    XFragmentAdapter adapter;



    @Override
    public void initData(Bundle savedInstanceState) {

        fragmentList.clear();
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(GanhuoFragment.newInstance());
        fragmentList.add(GirlFragment.newInstance());
        setTabs(tabName,tab_img);
        if (adapter == null) {
            adapter = new XFragmentAdapter(getSupportFragmentManager(), fragmentList);
        }
        viewPager.setAdapter(adapter);
        //TabLayout与ViewPager的绑定
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public Object newP() {
        return null;
    }

    /**
     * 设置添加Tab
     * @param tab_titles tab条目名字
     * @param tab_imgs tab上条目上的图片
     */
    private void setTabs(String[] tab_titles, int[] tab_imgs){
        for (int i = 0; i < tab_titles.length; i++) {
            //获取TabLayout的tab
            TabLayout.Tab tab = tabLayout.newTab();
            //初始化条目布局view
            View tabItemView = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
            tab.setCustomView(tabItemView);
            //tab的文字
            TextView tvTitle = tabItemView.findViewById(R.id.tab_name);
            tvTitle.setText(tab_titles[i]);
            //tab的图片
            ImageView imgTab =  tabItemView.findViewById(R.id.tab_img);
            imgTab.setImageResource(tab_imgs[i]);
            if (i==0){
                //设置第一个默认选中
                tabLayout.addTab(tab,true);
            }else {
                tabLayout.addTab(tab,false);
            }
        }
    }

}
