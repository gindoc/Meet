package com.cwenhui.meet.modules.login;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.usecase.UserCase;
import com.cwenhui.meet.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

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
                .compose(getView().<User>getBindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                    }

                    @Override
                    public void onNext(User user) {
                        getView().loadResult(user);
                    }
                });
    }
}