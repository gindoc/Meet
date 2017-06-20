package com.cwenhui.meet.modules.navigation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cwenhui.meet.R;
import com.cwenhui.meet.base.BaseActivity;
import com.cwenhui.meet.databinding.ActivityNavigationBinding;
import com.trello.rxlifecycle.LifecycleTransformer;

import javax.inject.Inject;


/**
 * Author: GIndoc on 2017/6/15 15:50
 * email : 735506583@qq.com
 * FOR   :
 */
public class NavigationActivity extends BaseActivity<NavigationContract.View, NavigationPresenter>
        implements NavigationContract.View {
    private ActivityNavigationBinding mBinding;

//    @Inject
//    IndexFragment indexFragment;

    @Inject
    NavigationPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent().inject(this);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
//        loadRootFragment(R.id.rl_content, indexFragment);
    }

    @Override
    protected NavigationPresenter createPresent() {
        return mPresenter;
    }

    @Override
    public <T> LifecycleTransformer<T> getBindToLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public void showError(String error) {

    }

}