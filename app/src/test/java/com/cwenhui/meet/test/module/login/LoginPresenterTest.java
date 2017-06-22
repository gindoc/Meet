package com.cwenhui.meet.test.module.login;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.model.response.Response;
import com.cwenhui.domain.usecase.UserCase;
import com.cwenhui.meet.modules.login.LoginContract;
import com.cwenhui.meet.modules.login.LoginPresenter;
import com.cwenhui.meet.utils.RxUnitTestTools;
import com.trello.rxlifecycle.LifecycleTransformer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.Observable;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginPresenterTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks        // 使用@InjectMocks就不用在setup()方法里面new了
    private LoginPresenter mPresenter;

    @Mock
    LoginContract.View loginView;

    @Mock
    UserCase userCase;

    @Mock
    LifecycleTransformer<Response<User>> lifecycleTransformer;

    @Before
    public void setup() {
        RxUnitTestTools.openRxTools();
//        mPresenter = new LoginPresenter(userCase);
        mPresenter.attachView(loginView);
    }

    @Test
    public void testLogin() {
        Response<User> response = new Response<>();
        User user = new User();
        user.setUsername("chenwenhui");
        user.setPwd("heihei");
        response.setData(user);
        Observable<Response<User>> observable = Observable.just(response);
        when(loginView.<Response<User>>getBindToLifecycle()).thenReturn(lifecycleTransformer);
        when(userCase.login(anyString(), anyString())).thenReturn(observable);
        when(observable.compose(lifecycleTransformer)).thenReturn(observable);
        mPresenter.login("111","222");

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        verify(loginView).getBindToLifecycle();
        verify(loginView).loadResult(/*any(User.class)*/captor.capture());

        User result = captor.getValue();
        Assert.assertEquals(result.getUsername(), user.getUsername());
        assertEquals(result.getPwd(), user.getPwd());

    }
}