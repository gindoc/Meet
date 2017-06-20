package com.cwenhui.domain.usecase;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Author: GIndoc on 2017/6/15 17:27
 * email : 735506583@qq.com
 * FOR   :
 */

public class UserCase {
    private UserRepository userRepository;

    @Inject
    public UserCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Observable<User> login(String username, String pwd) {
        return userRepository.login(username, pwd);
    }
}
