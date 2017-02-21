package cn.gtgs.base.OTO.activity.center.view;

import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class CenterDelegate extends AppDelegate {
    @BindView(R.id.tv_center_count)
    TextView mTvCount;
    @BindView(R.id.img_cemter_personal_icon)
    ImageView mImgPersonalIcon;
    @BindView(R.id.tv_center_name)
    TextView mTvName;
    @BindView(R.id.tv_center_phone)
    TextView mTvPhone;


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_center;
    }


}
