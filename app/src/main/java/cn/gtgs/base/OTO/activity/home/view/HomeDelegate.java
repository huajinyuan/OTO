package cn.gtgs.base.OTO.activity.home.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

/**
 * Created by gtgs on 2017/1/13.
 */

public class HomeDelegate extends AppDelegate {
    @BindView(R.id.nrc_home_content)
    NRecyclerView mNrecylerView;
    HomeAdatper adatper;
    ArrayList<String> mDatas = new ArrayList<>();

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_home;
    }

    public void setData(ArrayList<String> data) {
        mDatas.clear();
        mDatas.addAll(data);
        adatper = new HomeAdatper(mDatas);
        GridLayoutManager layoutManager = new GridLayoutManager(getRootView().getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNrecylerView.setLayoutManager(layoutManager);
        mNrecylerView.setAdapter(adatper);
        ViewGroup adVentureView = (ViewGroup) LayoutInflater.from(getRootView().getContext()).inflate(R.layout.adventure_layout, (ViewGroup) getRootView().findViewById(android.R.id.content), false);
        mNrecylerView.setAdtureView(adVentureView);
    }

    public NRecyclerView getmNrecylerView() {
        return mNrecylerView;
    }


}
