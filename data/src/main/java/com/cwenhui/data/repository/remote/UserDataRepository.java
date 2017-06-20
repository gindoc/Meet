package com.cwenhui.data.repository.remote;

import com.cwenhui.data.net.Api;
import com.cwenhui.domain.model.User;
import com.cwenhui.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Author: GIndoc on 2017/6/15 17:50
 * email : 735506583@qq.com
 * FOR   :
 */

public class UserDataRepository implements UserRepository {
    private Api api;

    @Inject
    public UserDataRepository(Api api) {
        this.api = api;
    }

    @Override
    public Observable<User> login(String username, String pwd) {
        return api.login(username, pwd);
    }
}
