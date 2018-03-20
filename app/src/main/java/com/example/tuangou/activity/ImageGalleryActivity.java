package com.example.tuangou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuangou.R;
import com.example.tuangou.entity.DetailInfo;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImageGalleryActivity extends AppCompatActivity {

    @InjectView(R.id.pager_image)
    ViewPager mPagerImage;
    private MyAdapter mMyAdapter;
    private List<DetailInfo.ResultBean.ImagesBean> mImages;
    private List<String> mDetail_imags;
    private List<View> mViewList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        DetailInfo detailInfo = (DetailInfo) intent.getSerializableExtra("DetailInfo");
        mDetail_imags = detailInfo.getResult().getDetail_imags();
        for (int i = 0; i < mDetail_imags.size(); i++) {
            View inflate = getLayoutInflater().inflate(R.layout.pager_image_item, null);
            SimpleDraweeView ivItem = (SimpleDraweeView) inflate.findViewById(R.id.iv_item);
            ivItem.setImageURI(mDetail_imags.get(i));
            mViewList.add(inflate);
        }


        mMyAdapter = new MyAdapter();
        mPagerImage.setAdapter(mMyAdapter);
    }

    class MyAdapter extends PagerAdapter{
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
//            super.destroyItem(container, position, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View child = mViewList.get(position);
            container.addView(child);
            return child;
        }

        @Override
        public int getCount() {
            return mDetail_imags.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view== object;
        }
    }


}
