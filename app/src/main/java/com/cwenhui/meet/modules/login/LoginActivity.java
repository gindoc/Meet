package com.cwenhui.meet.modules.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cwenhui.domain.model.User;
import com.cwenhui.meet.R;
import com.cwenhui.meet.base.BaseActivity;
import com.cwenhui.meet.databinding.ActivityLoginBinding;
import com.cwenhui.meet.modules.register.RegisterActivity;
import com.cwenhui.meet.utils.StringUtils;
import com.cwenhui.meet.utils.ToastUtil;
import com.cwenhui.meet.utils.Validate;
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
        processStatusBar(mBinding.ivBanner, true, false);
        mBinding.setView(this);
        mBinding.setActivity(this);
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
        ToastUtil.show(this, error);
    }

    @Override
    public void loadResult(User user) {
//        LoginContext.getLoginContext().toMainActivity();
    }

    public void login() {
        String phone = mBinding.tilPhone.getEditText().getText().toString();
        String pwd = mBinding.tilPwd.getEditText().getText().toString();
        if (Validate.validatePhoneNum(phone)) {
            mBinding.tilPhone.setError("请输入正确的手机号");
        } else if (StringUtils.isSpace(pwd)) {
            mBinding.tilPwd.setError("请输入密码");
        } else {
            mBinding.tilPhone.setErrorEnabled(false);
            mBinding.tilPwd.setErrorEnabled(false);
            mPresenter.login(phone, pwd);
        }
    }

    public void register() {
        startActivity(RegisterActivity.getStartIntent(this));
    }
}