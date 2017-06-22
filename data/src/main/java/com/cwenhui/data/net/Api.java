package com.cwenhui.data.net;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.model.response.Response;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author: GIndoc on 2017/6/15 14:38
 * email : 735506583@qq.com
 * FOR   :
 */

public interface Api {

    @GET("user/{name}/{pwd}")
    Observable<Response<User>> login(@Path("name") String username, @Path("pwd") String pwd);

}
