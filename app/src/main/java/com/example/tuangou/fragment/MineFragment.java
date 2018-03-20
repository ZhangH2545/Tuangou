package com.example.tuangou.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tuangou.R;
import com.example.tuangou.activity.CollectActivity;
import com.example.tuangou.activity.LoginActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    @InjectView(R.id.btn_login)
    Button mBtnLogin;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, inflate);
        return inflate;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.btn_login,R.id.tv_collect, R.id.tv_recent_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;

            case R.id.tv_collect:
                startActivity(new Intent(getActivity(), CollectActivity.class));

                break;
            case R.id.tv_recent_view:
                break;
        }
    }
}
