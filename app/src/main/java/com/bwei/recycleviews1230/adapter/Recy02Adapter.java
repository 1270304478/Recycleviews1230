package com.bwei.recycleviews1230.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bwei.recycleviews1230.R;
import com.bwei.recycleviews1230.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class Recy02Adapter extends RecyclerView.Adapter<Recy02Adapter.MyViewHolder>{

    List<Bean.DataBean.Ad5Bean> list;
    Context context;
    public Recy02Adapter(Context context){
        this.context = context;
    }

    public void addData(List<Bean.DataBean.Ad5Bean> data) {
        if (list==null){
            list= new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recy_01_grid,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.simpleDraweeView.setImageURI(list.get(position).getImage());
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simple_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
