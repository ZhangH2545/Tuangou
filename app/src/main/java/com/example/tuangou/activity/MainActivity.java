package com.example.tuangou.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuangou.R;
import com.example.tuangou.bean.Config;
import com.example.tuangou.fragment.AroundFragment;
import com.example.tuangou.fragment.MainFragment;
import com.example.tuangou.fragment.MineFragment;
import com.example.tuangou.fragment.MoreFragment;
import com.igexin.sdk.PushManager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements Config {
    @InjectView(R.id.tabHost)
    FragmentTabHost mTabHost;
    private Class[] fragments = new Class[]{
            MainFragment.class,
            AroundFragment.class,
            MineFragment.class,
            MoreFragment.class};
    private int[] imgRes = new int[]{
            R.drawable.ic_tab_artists_selector,
            R.drawable.ic_tab_albums_selector,
            R.drawable.ic_tab_songs_selector,
            R.drawable.ic_tab_playlists_selector
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //个推的初始化
        PushManager.getInstance().initialize(this.getApplicationContext());
        ButterKnife.inject(this);
        initFragmentTabhost();
    }


    private void initFragmentTabhost() {
        //初始化
        mTabHost.setup(MainActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

        for (int i = 0; i < title.length; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.tab_item, null);
            ImageView ivTab = (ImageView) inflate.findViewById(R.id.iv_tab);
            TextView tvTab = (TextView) inflate.findViewById(R.id.tv_tab);
            ivTab.setImageResource(imgRes[i]);
            tvTab.setText(title[i]);
            mTabHost.addTab(mTabHost.newTabSpec(Config.title[i]).setIndicator(inflate), fragments[i], null);
        }
    }
}
