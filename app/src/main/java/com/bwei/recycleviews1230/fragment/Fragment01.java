package com.bwei.recycleviews1230.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.recycleviews1230.R;
import com.bwei.recycleviews1230.adapter.RecyAdapter;
import com.bwei.recycleviews1230.bean.Bean;
import com.bwei.recycleviews1230.presenter.MyPresenter;
import com.bwei.recycleviews1230.view.ViewCallBack;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/30 9:43
 */
public class Fragment01 extends Fragment implements ViewCallBack {
    @BindView(R.id.shouye_recy)
    RecyclerView shouyeRecy;
    Unbinder unbinder;
    private MyPresenter myPresenter;
    private RecyAdapter recyAdapter;
    private List<Bean.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myPresenter = new MyPresenter(this);
        //调用p层的方法
        myPresenter.getData();
        recyAdapter = new RecyAdapter(getActivity());
        shouyeRecy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        shouyeRecy.setAdapter(recyAdapter);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(Bean bean) {
        if (list==null){
            list = new ArrayList<>();
        }
        list.add(bean.getData());
        recyAdapter.addData(list);
    }

    @Override
    public void failure() {

    }
    //防止内存泄漏
    @Override
    public void onDestroy() {
        super.onDestroy();
        myPresenter.detach();
    }
}
