package com.cwenhui.meet.modules.login;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.model.response.Response;
import com.cwenhui.domain.usecase.UserCase;
import com.cwenhui.meet.base.BasePresenter;
import com.cwenhui.meet.utils.rx.RxResultHelper;
import com.cwenhui.meet.utils.rx.RxSubscriber;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: GIndoc on 2017/6/15 16:38
 * email : 735506583@qq.com
 * FOR   :
 */
public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {
    private UserCase userCase;

    @Inject
    public LoginPresenter(UserCase userCase) {
        this.userCase = userCase;
    }

    @Override
    public void login(String username, String pwd) {
        userCase.login(username, pwd)
                .compose(getView().<Response<User>>getBindToLifecycle())
                .compose(RxResultHelper.<Response<User>>handleResult())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscriber<Response<User>>() {
                    @Override
                    public void _onNext(Response<User> response) {
                        LoginContext.getLoginContext().setUserSate(new LoginState());
                        getView().loadResult(response.getData());
                    }

                    @Override
                    public void _onError(Throwable throwable) {
                        getView().showError(throwable.getMessage());
                    }
                });
    }
}