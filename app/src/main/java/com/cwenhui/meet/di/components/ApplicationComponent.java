package com.cwenhui.meet.di.components;

import android.content.Context;

import com.cwenhui.meet.base.BaseApplication;
import com.cwenhui.meet.di.modules.ActivityModule;
import com.cwenhui.meet.di.modules.ApplicationModule;
import com.cwenhui.meet.di.modules.DataManagerModule;
import com.cwenhui.meet.di.modules.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者: 陈文辉
 * 日期: 2017/1/17 23:39
 * 作用:
 */
@Singleton
@Component(modules = {ApplicationModule.class, DataManagerModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(BaseApplication application);

    ActivityComponent plus(ActivityModule module);

    Context getContext();
}
