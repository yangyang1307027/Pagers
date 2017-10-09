package cn.deng.com.pagers.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.deng.com.pagers.Count;
import cn.deng.com.pagers.MainActivity;
import cn.deng.com.pagers.R;
import cn.deng.com.pagers.adapter.VipFragmentAdapter;

/**
 *
 * Created by Yan on 2017/9/30.
 */

public class VipFragment extends Fragment {
    private  Context mContext;
    private  View view;
    private TextView mTitleText;
    private  String mVipType;
    private RecyclerView   mCountView;




    public static VipFragment newInstance() {

        Bundle args = new Bundle();
        //args.putString(Count.VIP_TYPE,vipType);
        VipFragment fragment = new VipFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context.getApplicationContext();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // mVipType= (String) getArguments().get(Count.VIP_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if(null==view){
            view=inflater.inflate(R.layout.fragment_vip_permission,container,false);
            initView();
            initAdapter();
        }
        return view;

    }

    private void initAdapter() {
        List<String> datas=new ArrayList<String>();
        datas.add("调广告");
        datas.add("1080P");
        datas.add("下载加速");
        datas.add("杜比音效");
        datas.add("尊贵标识");
        datas.add("签到有奖");
        datas.add("成长任务");
        datas.add("专属活动");
        GridLayoutManager manger=new GridLayoutManager(mContext,4,GridLayoutManager.VERTICAL,false);
        mCountView.setLayoutManager(manger);
        mCountView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0,0,0,0);
            }
        });
        RecyclerView.RecycledViewPool viewPool=new RecyclerView.RecycledViewPool();
        mCountView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,20);
        VipFragmentAdapter adapter=new VipFragmentAdapter(datas);
        mCountView.setAdapter(adapter);
    }

    private void initView() {
        mTitleText=view.findViewById(R.id.fragment_vip_title);
        mCountView=view.findViewById(R.id.fragment_vip_count);
        if(null!=mVipType){
            mTitleText.setText(mVipType);
        }
    }
}
