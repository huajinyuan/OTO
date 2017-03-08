package cn.gtgs.base.OTO.activity.Address.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.activity.Address.model.Address;
import cn.gtgs.base.OTO.activity.Address.presenter.IAddressActionLisenter;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

/**
 * Created by gtgs on 2017/1/13.
 */

public class AddressManageDelegate extends AppDelegate {
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    @BindView(R.id.nrec_address_manage_content)
    NRecyclerView mRecyclerView;
    AddressAdatper adatper;
    ArrayList<Address> mDatas = new ArrayList<>();
    boolean isSetLayout = false;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_address_manage;
    }

    public void setData(ArrayList<Address> data, IAddressActionLisenter lisenter) {
        if (data == null || data.isEmpty()) {
            ViewGroup errorView = (ViewGroup) LayoutInflater.from(getRootView().getContext()).inflate(R.layout.layout_shopping_car_error, null);
            mRecyclerView.setEntryView(errorView);
        } else {
            mDatas.clear();
            mDatas.addAll(data);
            adatper = new AddressAdatper(data, lisenter);
            if (!isSetLayout) {
                GridLayoutManager layoutManager = new GridLayoutManager(getRootView().getContext(), 1);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(layoutManager);
                isSetLayout = true;
            }
            mRecyclerView.setAdapter(adatper);
            Paint paint = new Paint();
            paint.setStrokeWidth(50);
            paint.setColor(Color.parseColor("#F1F1F1"));
            paint.setAntiAlias(true);
            paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
            mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getRootView().getContext()).paint(paint).build(), 1);
        }


    }

    public NRecyclerView getmNrecylerView() {
        return mRecyclerView;
    }

    public void setTitle() {
        mTvTitle.setText("Address Management");
    }


}
