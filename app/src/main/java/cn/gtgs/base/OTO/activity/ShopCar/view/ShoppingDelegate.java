package cn.gtgs.base.OTO.activity.ShopCar.view;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

/**
 * Created by gtgs on 2017/1/13.
 */

public class ShoppingDelegate extends AppDelegate {
    @BindView(R.id.nrec_shopping_car_content)
    NRecyclerView mNrecylerView;
    @BindView(R.id.tv_shopping_car_totalfree)
    TextView mTvTotalFree;

    ShoppingCarAdatper adatper;
    ArrayList<String> mDatas = new ArrayList<>();

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_shopping_car;
    }

    public void setmTvTotalFree(String totalFree) {
        this.mTvTotalFree.setText(totalFree);
    }

    public void setData(ArrayList<String> data) {
//        mDatas.clear();
//        mDatas.addAll(data);
        adatper = new ShoppingCarAdatper();
        GridLayoutManager layoutManager = new GridLayoutManager(getRootView().getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNrecylerView.setLayoutManager(layoutManager);
        mNrecylerView.setAdapter(adatper);
        Paint paint = new Paint();
        paint.setStrokeWidth(50);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
        mNrecylerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getRootView().getContext()).paint(paint).build(), 1);
//        ViewGroup adVentureView = (ViewGroup) LayoutInflater.from(getRootView().getContext()).inflate(R.layout.adventure_layout, (ViewGroup) getRootView().findViewById(android.R.id.content), false);
//        mNrecylerView.setAdtureView(adVentureView);
    }

    public NRecyclerView getmNrecylerView() {
        return mNrecylerView;
    }


}
