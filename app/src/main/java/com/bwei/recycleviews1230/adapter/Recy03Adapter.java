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
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/12/30 17:21
 */
public class Recy03Adapter extends RecyclerView.Adapter<Recy03Adapter.MyDataViewHolder> {
    List<Bean.DataBean.Ad5Bean> list;
    Context context;
    public Recy03Adapter(Context context) {
        this.context = context;
    }
    public void addData(List<Bean.DataBean.Ad5Bean> data) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public MyDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recy_03item, null);
        return new MyDataViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyDataViewHolder holder, int position) {
        holder.simpleDraweeView.setImageURI(list.get(position).getImage());
        holder.textIdd.setText(list.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
    static class MyDataViewHolder extends RecyclerView.ViewHolder{
       @BindView(R.id.simpledraweeview)
        SimpleDraweeView simpleDraweeView;
        @BindView(R.id.text_idd)
        TextView textIdd;
        MyDataViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
