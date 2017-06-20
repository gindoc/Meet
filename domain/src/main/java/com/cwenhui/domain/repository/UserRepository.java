package com.cwenhui.domain.repository;

import com.cwenhui.domain.model.User;

import rx.Observable;

/**
 * Author: GIndoc on 2017/6/15 17:33
 * email : 735506583@qq.com
 * FOR   :
 */

public interface UserRepository {

    Observable<User> login(String username, String pwd);
}
