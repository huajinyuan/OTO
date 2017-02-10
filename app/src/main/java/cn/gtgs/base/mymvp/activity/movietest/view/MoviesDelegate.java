package cn.gtgs.base.mymvp.activity.movietest.view;

import android.widget.TextView;

import butterknife.BindView;
import cn.gtgs.base.mymvp.R;
import cn.gtgs.base.mymvp.base.view.AppDelegate;

/**
 * Created by gtgs on 2017/1/13.
 */

public class MoviesDelegate extends AppDelegate {
    @BindView(R.id.tv_main_tip)
    TextView mTvTip;

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_movie_test;
    }

    public void setTip(String text) {
        mTvTip.setText(text);
    }

}
