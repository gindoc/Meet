package com.cwenhui.domain.test.usecase;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.repository.UserRepository;
import com.cwenhui.domain.usecase.UserCase;

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
 * Author: GIndoc on 2017/6/16 17:41
 * email : 735506583@qq.com
 * FOR   :
 */

public class UserCaseTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    UserCase userCase;

    @Mock
    UserRepository userRepository;

    @Test
    public void testLogin() {
        final User user = new User();
        user.setUsername("chenwenhui");
        user.setPwd("heihei");
        when(userRepository.login(anyString(), anyString())).thenReturn(Observable.just(user));
        Observable<User> result = userCase.login(anyString(), anyString());
        verify(userRepository).login(anyString(), anyString());
        result.subscribe(new Action1<User>() {
            @Override
            public void call(User result) {
                Assert.assertEquals(result.getUsername(), user.getUsername());
                Assert.assertEquals(result.getPwd(), user.getPwd());
            }
        });
    }
}
