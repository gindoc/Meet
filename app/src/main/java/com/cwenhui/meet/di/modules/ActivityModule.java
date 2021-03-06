package com.cwenhui.meet.di.modules;

import android.support.v4.app.FragmentManager;

import com.cwenhui.meet.base.BaseActivity;

import java.lang.ref.WeakReference;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: 陈文辉
 * 日期: 2017/1/17 23:39
 * 作用:
 */
@Module
public class ActivityModule {
    private WeakReference<BaseActivity> mActivity;
    public ActivityModule(BaseActivity activity){
        mActivity = new WeakReference<BaseActivity>(activity);
    }

    @Provides
    public BaseActivity  providesActivity(){
        return mActivity.get();
    }

    @Provides
    public FragmentManager providesFragmentManager(){
        return mActivity.get().getSupportFragmentManager();
    }

    /*@Provides
    public HttpUrl providesApiUrl(*//*Resources resources*//*) {
        return HttpUrl.parse(*//*resources.getString(R.string.api)*//*"http://www.baidu.com");
    }*/
}
