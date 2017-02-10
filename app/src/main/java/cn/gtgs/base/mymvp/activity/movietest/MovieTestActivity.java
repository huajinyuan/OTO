package cn.gtgs.base.mymvp.activity.movietest;

import android.os.Bundle;

import cn.gtgs.base.mymvp.R;
import cn.gtgs.base.mymvp.activity.login.view.LoginDelegate;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBindActivity;
import cn.gtgs.base.mymvp.base.presenter.databind.DataBinder;

public class MovieTestActivity extends DataBindActivity<LoginDelegate> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_test);
    }

    @Override
    protected Class<LoginDelegate> getDelegateClass() {
        return null;
    }

    @Override
    public DataBinder getDataBinder() {
        return null;
    }
}
