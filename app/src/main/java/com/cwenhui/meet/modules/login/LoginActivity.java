package com.cwenhui.meet.modules.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cwenhui.domain.model.User;
import com.cwenhui.meet.R;
import com.cwenhui.meet.base.BaseActivity;
import com.cwenhui.meet.databinding.ActivityLoginBinding;
import com.trello.rxlifecycle.LifecycleTransformer;

import javax.inject.Inject;


/**
 * Author: GIndoc on 2017/6/15 16:38
 * email : 735506583@qq.com
 * FOR   :
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginPresenter>
        implements LoginContract.View {
    private ActivityLoginBinding mBinding;

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent().inject(this);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mPresenter.login("1111", "2222");
        processStatusBar(mBinding.ivBanner, true, false);
    }

    @Override
    protected LoginPresenter createPresent() {
        return mPresenter;
    }

    @Override
    public <T> LifecycleTransformer<T> getBindToLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void loadResult(User user) {
//        mBinding.btnLogin.setText(user.getUsername());
    }
}