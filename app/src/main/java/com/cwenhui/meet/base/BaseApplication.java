package com.cwenhui.meet.base;

import android.app.Application;
import android.os.StrictMode;

import com.cwenhui.meet.BuildConfig;
import com.cwenhui.meet.di.components.ApplicationComponent;
import com.cwenhui.meet.di.components.DaggerApplicationComponent;
import com.cwenhui.meet.di.modules.ApplicationModule;
import com.cwenhui.meet.utils.ComponentHolder;
import com.cwenhui.meet.utils.Saver;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * 作者: 陈文辉
 * 日期: 2017/1/17 23:39
 * 作用:
 */
public class BaseApplication extends Application {
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //内存泄漏分析
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
//        enabledStrictMode();
        Saver.initSaver(this);

        getApplicationComponent().inject(this);

        //初始化Timber
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
            Timber.plant(new Timber.DebugTree());
        }

        //替换系统默认异常处理Handler
//        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }

    public ApplicationComponent getApplicationComponent() {
        if (mComponent == null) {
            mComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
//                    .dataManagerModule()
                    .build();
        }
        ComponentHolder.setAppComponent(mComponent);
        return mComponent;
    }

    public void setComponent(ApplicationComponent component) {
        mComponent = component;
    }


}
