package es.source.code.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import es.source.code.AppGlobal;
import es.source.code.Fragment.BaseFragment;
import es.source.code.Fragment.ColdFoodFragment;
import es.source.code.Fragment.DrinkFoodFragment;
import es.source.code.Fragment.BaseFoodFragment;
import es.source.code.Fragment.HotFoodFragment;
import es.source.code.Fragment.SeaFoodFragment;
import es.source.code.R;
import es.source.code.adapter.FragmentViewPagerAdapter;
import es.source.code.model.User;

public class FoodView extends BaseActivity {

    private TextView textLable;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private List<BaseFragment> fragmentList;
    private User user;
    private String userString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);

        initView();

    }

    private void initView(){
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        textLable = (TextView)findViewById(R.id.title);

        textLable.setText("点餐");

        Intent intent = getIntent();
        userString = intent.getStringExtra(AppGlobal.IntentKey.USER_INFO);
        Gson gson = new Gson();
        user = gson.fromJson(userString,User.class);
        System.out.println(userString);
        fragmentList = new ArrayList<>();

        ColdFoodFragment coldFoodFragment = new ColdFoodFragment();
        HotFoodFragment hotFoodFragment = new HotFoodFragment();
        SeaFoodFragment seaFoodFragment = new SeaFoodFragment();
        DrinkFoodFragment drinkingFragment = new DrinkFoodFragment();

        fragmentList.add(coldFoodFragment);
        fragmentList.add(hotFoodFragment);
        fragmentList.add(seaFoodFragment);
        fragmentList.add(drinkingFragment);

        setSupportActionBar(toolbar);
        ActionBar actionBar =  getSupportActionBar();
        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        initToolbar();
        FragmentViewPagerAdapter fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(),fragmentList);

        viewPager.setAdapter(fragmentViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }


    private void initToolbar(){
        toolbar.inflateMenu(R.menu.menu_order);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                switch(menuItemId){
                    case R.id.action_order:
                        Intent intent = new Intent(mContext,FoodOrderView.class);
                        intent.putExtra(AppGlobal.IntentKey.USER_INFO,userString);
                        intent.putExtra(AppGlobal.IntentKey.CURRENT_INDEX, AppGlobal.Lable.UNORDER_LABLE);
                        startActivity(intent);
                        break;
                    case R.id.action_bill:
                        Intent intent1 = new Intent(mContext,FoodOrderView.class);
                        intent1.putExtra(AppGlobal.IntentKey.USER_INFO,userString);
                        intent1.putExtra(AppGlobal.IntentKey.CURRENT_INDEX, AppGlobal.Lable.ORDERED_LABLE);
                        startActivity(intent1);
                        break;
                    case R.id.action_serve:
                        break;
                }
                return true;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    //设置menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_order, menu); //解析menu布局文件到menu
        return true;
    }
}
