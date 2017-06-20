package com.cwenhui.data.test.remote;

import com.cwenhui.data.net.Api;
import com.cwenhui.data.repository.remote.UserDataRepository;
import com.cwenhui.domain.model.User;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.Observable;
import rx.functions.Action1;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author: GIndoc on 2017/6/17 9:57
 * email : 735506583@qq.com
 * FOR   :
 */

public class UserDataRepositoryTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    UserDataRepository userRepository;
//    UserRepository userRepository;

    @Mock
    Api api;

    @Test
    public void testLogin() {

        final User user = new User();
        user.setPwd("12345");
        user.setUsername("chenwenhui");
        when(api.login(anyString(), anyString())).thenReturn(Observable.just(user));
        Observable<User> result = userRepository.login(anyString(), anyString());
        verify(api).login(anyString(), anyString());
        result.subscribe(new Action1<User>() {
            @Override
            public void call(User result) {
                Assert.assertEquals(result.getUsername(), user.getUsername());
                Assert.assertEquals(result.getPwd(), user.getPwd());
//                Assert.assertEquals(result, user);
            }
        });
    }
}
