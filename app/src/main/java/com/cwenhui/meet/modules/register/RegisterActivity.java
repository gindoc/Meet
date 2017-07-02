package com.cwenhui.meet.modules.register;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cwenhui.meet.R;
import com.cwenhui.meet.base.BaseActivity;
import com.cwenhui.meet.databinding.ActivityRegisterBinding;
import com.cwenhui.meet.utils.StringUtils;
import com.cwenhui.meet.utils.ToastUtil;
import com.cwenhui.meet.utils.Validate;
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
//        mBinding.set
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

    public static Intent getStartIntent(Context context) {
        return new Intent(context, RegisterActivity.class);
    }

    public void sendCaptcha() {
        String phone = mBinding.etPhone.getText().toString();
        if (!Validate.validatePhoneNum(phone)) {
            ToastUtil.show(this, "请输入正确的手机号");
        } else {
            mPresenter.getCaptcha(phone);
        }
    }

    public void register() {
        String phone = mBinding.etPhone.getText().toString();
        String captcha = mBinding.etCaptcha.getText().toString();
        String pwd = mBinding.etPwd.getText().toString();
        if (!Validate.validatePhoneNum(phone)) {
            ToastUtil.show(this, "请输入正确的手机号");
        } else if (StringUtils.isSpace(captcha)) {
            ToastUtil.show(this, "请输入验证码");
        } else if (StringUtils.isSpace(pwd)) {
            ToastUtil.show(this, "请输入密码");
        } else {
            mPresenter.register(phone, captcha, pwd);
        }
    }

}