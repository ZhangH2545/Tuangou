package com.example.tuangou.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tuangou.R;
import com.example.tuangou.adapter.CommenAdapter;
import com.example.tuangou.entity.FavorInfo;
import com.example.tuangou.listner.IBmobQueryListener;
import com.example.tuangou.utils.BmobUtils;

import java.util.List;

import cn.bmob.v3.exception.BmobException;


public class CollectActivity extends AppCompatActivity {

    private ListView mListCollect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        mListCollect = (ListView) findViewById(R.id.list_collect);

        BmobUtils.getInstance(new IBmobQueryListener() {
            @Override
            public void querySucess(final List<FavorInfo> object) {
                mListCollect.setAdapter(new CommenAdapter<FavorInfo>(object) {
                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View collectView = getLayoutInflater().inflate(R.layout.goods_list_item, null);
                        TextView tvTitle = (TextView) collectView.findViewById(R.id.title);
                        tvTitle.setText(object.get(i).getPruduct());
                        return collectView;
                    }
                });
            }
            @Override
            public void queryFailure(BmobException e) {
            }
        }).queryData(new FavorInfo(),"isFavor",true);

    }
}
