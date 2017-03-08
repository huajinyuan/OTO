package cn.gtgs.base.OTO.activity.ShopCar.view;

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
import cn.gtgs.base.OTO.activity.ShopCar.model.ShopCarGoods;
import cn.gtgs.base.OTO.activity.ShopCar.presenter.IChooseChanged;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.MyRecycle.NRecyclerView;

import static cn.gtgs.base.OTO.R.id.tv_shopping_car_totalfree;

/**
 * Created by gtgs on 2017/1/13.
 */

public class ShoppingDelegate extends AppDelegate implements IChooseChanged {
    @BindView(R.id.tv_shoppingcar_allchoose)
    TextView mTvAllChooseAction;
    @BindView(R.id.nrec_shopping_car_content)
    NRecyclerView mNrecylerView;
    @BindView(tv_shopping_car_totalfree)
    TextView mTvTotalFree;
    private boolean mAllChoose = false;
    ShoppingCarAdatper adatper;
    ArrayList<ShopCarGoods> mDatas = new ArrayList<>();

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_shopping_car;
    }

    public void setmTvTotalFree(String totalFree) {
        this.mTvTotalFree.setText(totalFree);
    }

    public void setData(ArrayList<ShopCarGoods> data) {
        mDatas.clear();
        mDatas.addAll(data);
        adatper = new ShoppingCarAdatper(data, this);
        mTvTotalFree.setText("$ " + getAllPrice(mDatas));
        GridLayoutManager layoutManager = new GridLayoutManager(getRootView().getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNrecylerView.setLayoutManager(layoutManager);
        mNrecylerView.setAdapter(adatper);
        Paint paint = new Paint();
        paint.setStrokeWidth(50);
        paint.setColor(Color.parseColor("#F1F1F1"));
        paint.setAntiAlias(true);
        paint.setPathEffect(new DashPathEffect(new float[]{25.0f, 25.0f}, 0));
        mNrecylerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getRootView().getContext()).paint(paint).build(), 1);
        if (mDatas.isEmpty()) {
            ViewGroup errorView = (ViewGroup) LayoutInflater.from(getRootView().getContext()).inflate(R.layout.layout_shopping_car_error, null);
            mNrecylerView.setEntryView(errorView);

        }
    }

    public void setAllChooseOrUnChoose() {
        mAllChoose = !mAllChoose;
        for (ShopCarGoods good : mDatas) {
            good.setChoose(mAllChoose);
        }
        adatper.notifyDataSetChanged();
        mTvAllChooseAction.setText(mAllChoose ? "Clean" : "All");
    }

    public NRecyclerView getmNrecylerView() {
        return mNrecylerView;
    }

    @Override
    public void change(ArrayList<ShopCarGoods> mDatas) {
        mTvTotalFree.setText("$ " + getAllPrice(mDatas));
    }

    public int getAllPrice(ArrayList<ShopCarGoods> mDatas) {
        int allPrice = 0;
        for (ShopCarGoods goods : mDatas) {
            if (goods.isChoose()) {
                allPrice += goods.getPrice() * goods.getQty();
            }
        }
        return allPrice;
    }

    public boolean isChooseNothing(ArrayList<ShopCarGoods> mDatas) {
        boolean chooseNothing = true;
        for (ShopCarGoods goods : mDatas) {
            if (goods.isChoose()) {
                chooseNothing = false;
                break;
            }
        }
        return chooseNothing;
    }
}
