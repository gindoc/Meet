package com.cwenhui.data.test.remote;

import com.cwenhui.data.net.Api;
import com.cwenhui.data.repository.remote.UserDataRepository;
import com.cwenhui.data.utils.MockRetrofitHelper;
import com.cwenhui.domain.model.User;
import com.cwenhui.domain.model.response.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.observers.TestSubscriber;

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

    Api testApi;
    MockRetrofitHelper retrofit;

    @Before
    public void setup() {
        retrofit = new MockRetrofitHelper();
        testApi = retrofit.create(Api.class);
    }
    @Test
    public void testLogin() {
//        final User user = new User();
//        user.setPwd("12345");
//        user.setUsername("chenwenhui");
//        when(api.login(anyString(), anyString())).thenReturn(Observable.just(user));
//        Observable<User> result = userRepository.login(anyString(), anyString());
//        verify(api).login(anyString(), anyString());
//        result.subscribe(new Action1<User>() {
//            @Override
//            public void call(User result) {
//                Assert.assertEquals(result.getUsername(), user.getUsername());
//                Assert.assertEquals(result.getPwd(), user.getPwd());
////                Assert.assertEquals(result, user);
//            }
//        });
        retrofit.setPath("user.json");

        TestSubscriber<Response<User>> testSubscriber = new TestSubscriber<>();

//        testApi.login("gindoc", "123456")
//                .subscribe(new Action1<Response<User>>() {
//                    @Override
//                    public void call(Response<User> response) {
//                        Assert.assertEquals(response.getData().getUsername(), "gindoc");
//                        Assert.assertEquals(response.getData().getPwd(), "123456");
//                    }
//                });

        testApi.login("chenwenhui", "123456")
                .toBlocking()
                .subscribe(testSubscriber);

        Response<User> user = testSubscriber.getOnNextEvents()
                .get(0);

        Assert.assertEquals(user.getData().getUsername(), "gindoc");
        Assert.assertEquals(user.getData().getPwd(), "123456");
    }
}
