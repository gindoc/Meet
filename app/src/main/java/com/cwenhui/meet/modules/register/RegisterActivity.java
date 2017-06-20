package com.cwenhui.meet.modules.register;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cwenhui.meet.R;
import com.cwenhui.meet.base.BaseActivity;
import com.cwenhui.meet.databinding.ActivityRegisterBinding;
import com.trello.rxlifecycle.LifecycleTransformer;

import javax.inject.Inject;


/**
 * Author: GIndoc on 2017/6/20 15:12
 * email : 735506583@qq.com
 * FOR   :
 */
public class RegisterActivity extends BaseActivity<RegisterContract.View, RegisterPresenter>
        implements RegisterContract.View {
    private ActivityRegisterBinding mBinding;

    @Inject
    RegisterPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent().inject(this);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        processStatusBar(mBinding.rlTitle, true, false);
    }

    @Override
    protected RegisterPresenter createPresent() {
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