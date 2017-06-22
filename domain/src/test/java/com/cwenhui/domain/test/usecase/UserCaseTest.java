package com.cwenhui.domain.test.usecase;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.model.response.Response;
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
        Response<User> response = new Response<>();
        response.setErro_code(200);
        response.setErro_msg("成功");
        final User user = new User();
        user.setUsername("gindoc");
        user.setPwd("123456");
        response.setData(user);
        when(userRepository.login(anyString(), anyString())).thenReturn(Observable.just(response));
        Observable<Response<User>> result = userCase.login(anyString(), anyString());
        verify(userRepository).login(anyString(), anyString());
        result.subscribe(new Action1<Response<User>>() {
            @Override
            public void call(Response<User> result) {
                Assert.assertEquals(result.getData().getUsername(), user.getUsername());
                Assert.assertEquals(result.getData().getPwd(), user.getPwd());
            }
        });
    }
}
