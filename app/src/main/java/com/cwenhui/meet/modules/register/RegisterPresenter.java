package com.cwenhui.meet.modules.register;

import com.cwenhui.domain.usecase.UserCase;
import com.cwenhui.meet.base.BasePresenter;

import javax.inject.Inject;

/**
 * Author: GIndoc on 2017/6/20 15:09
 * email : 735506583@qq.com
 * FOR   :
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter {

    private UserCase userCase;

    @Inject
    public RegisterPresenter(UserCase userCase) {
        this.userCase = userCase;
    }

    @Override
    public void getCaptcha(String phone) {

    }

    @Override
    public void register(String phone, String captcha, String password) {

    }
}