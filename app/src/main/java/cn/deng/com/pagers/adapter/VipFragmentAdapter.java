package cn.deng.com.pagers.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.deng.com.pagers.R;

/**
 *
 * Created by Yan on 2017/9/30.
 */

public class VipFragmentAdapter extends RecyclerView.Adapter<VipFragmentAdapter.MyViewHolder> {
    private List<String>  datas;

    public VipFragmentAdapter(List<String>  datas) {
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_vip_permission,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mVipName.setText(datas.get(position));

    }

    @Override
    public int getItemCount(){
        int size=datas.size();
        return size==0?0:size;
    }

     class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView mVipName;

        public MyViewHolder(View itemView) {
            super(itemView);
            mVipName=itemView.findViewById(R.id.item_vip_names);
        }
    }
}
