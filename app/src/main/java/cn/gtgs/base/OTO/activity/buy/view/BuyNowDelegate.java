package cn.gtgs.base.OTO.activity.buy.view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;
import cn.gtgs.base.OTO.widget.AmountView;
import cn.gtgs.base.OTO.widget.LineBreakLayout;

/**
 * Created by gtgs on 2017/1/13.
 */

public class BuyNowDelegate extends AppDelegate {
    @BindView(R.id.tv_topbar_title)
    TextView mTvTitle;
    @BindView(R.id.tv_buy_totalfree)
    TextView mTvTotalfree;
    @BindView(R.id.img_layout_buy_icon)
    ImageView mImgGoodsIcon;
    @BindView(R.id.tv_layout_buy_name)
    TextView mTvGoodsName;
    @BindView(R.id.tv_layout_buy_price)
    TextView mTvGoodsPrice;
    @BindView(R.id.amount_layout_buy_count)
    AmountView mAmountGoodsPrice;
    @BindView(R.id.linebreaklayout_buy_size_choose)
    LineBreakLayout mSizeChoose;
    @BindView(R.id.linebreaklayout_buy_color_choose)
    LineBreakLayout mColorChoose;
    @BindView(R.id.checkbox_buy_delivery_choose)
    CheckBox mCheckboxDelivery;
    @BindView(R.id.layout_buy_select_address_select1)
    View mAddressSelect1;
    @BindView(R.id.layout_buy_select_address_select2)
    View mAddressSelect2;


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_buy_now_info;
    }


    public void setTitle() {
        mTvTitle.setText("Buy Now");
    }

    public void setSizeData(ArrayList<String> datas) {
        mSizeChoose.setLables(datas, true, null);
    }

    public void setColorData(ArrayList<String> datas) {
        mColorChoose.setLables(datas, true, null);
    }


}
