package com.bwei.recycleviews1230.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.recycleviews1230.R;
import com.bwei.recycleviews1230.bean.Bean;
import com.bwei.recycleviews1230.imageload.GildeImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/30 10:48
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int ONE = 0;
    int TWO = 1;
    int THREE = 2;
    Context context;
    private List<Bean.DataBean> list;

    public RecyAdapter(Context context) {
        this.context = context;
    }
    public void addData(List<Bean.DataBean> data) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(data);
        //刷新适配器的方法
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View view = View.inflate(context, R.layout.recy_01, null);
            return new ViewHolder1(view);
        } else if (viewType == TWO) {
            View view = View.inflate(context, R.layout.recy_02, null);
            return new ViewHolder2(view);
        } else {
            View view = View.inflate(context, R.layout.recy_03, null);
            return new ViewHolder3(view);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //判断viewholder
        if (holder instanceof ViewHolder1) {
            List<String> images = new ArrayList<>();
            if (list != null && list.size() != 0) {
                images.add(list.get(0).getAd1().get(0).getImage());
                images.add(list.get(0).getAd1().get(1).getImage());
                images.add(list.get(0).getAd1().get(2).getImage());
                images.add(list.get(0).getAd1().get(3).getImage());
                ViewHolder1 holder1 = (ViewHolder1) holder;
                //设置图片加载器
                holder1.banner.setImageLoader(new GildeImageLoader());
                //设置图片集合
                holder1.banner.setImages(images);
                //banner设置方法全部调用完毕时最后调用
                holder1.banner.start();
            }
        } else if (holder instanceof ViewHolder2) {
            if (list != null) {
                ViewHolder2 holder2 = (ViewHolder2) holder;
                Recy02Adapter recy02Adapter = new Recy02Adapter(context);
                holder2.recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
                recy02Adapter.addData(list.get(0).getAd5());
                holder2.recyclerView.setAdapter(recy02Adapter);
            }
        }else{
            if (list!= null) {
                ViewHolder3 holder3 = (ViewHolder3) holder;
                Recy03Adapter recy03Adapter = new Recy03Adapter(context);
                holder3.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                recy03Adapter.addData(list.get(0).getAd5());
                holder3.recyclerView.setAdapter(recy03Adapter);
            }
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
    @Override
    public int getItemViewType(int position) {
        //判断是哪种条目类型
        if (position == 0) {
            return ONE;
        } else if (position == 1) {
            return TWO;
        } else {
            return THREE;
        }
    }


    static class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner banner;

        public ViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    static class ViewHolder2 extends RecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        public ViewHolder2(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy3_recyciew);
        }
    }
    static class ViewHolder3 extends RecyclerView.ViewHolder {
        private final RecyclerView recyclerView;
        public ViewHolder3(View itemView){
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy3_recyciew);
        }
    }
}
