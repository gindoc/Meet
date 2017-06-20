package com.cwenhui.meet.modules.navigation.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cwenhui.meet.base.BaseFragment;
import com.cwenhui.meet.databinding.FragmentNavigationIndexBinding;
import com.trello.rxlifecycle.LifecycleTransformer;

import javax.inject.Inject;


/**
 * Author: GIndoc on 2017/6/15 16:23
 * email : 735506583@qq.com
 * FOR   :
 */
public class IndexFragment extends BaseFragment<IndexContract.View, IndexPresenter>
        implements IndexContract.View {
    private FragmentNavigationIndexBinding mBinding;

    @Inject
    IndexPresenter mPresenter;

    @Inject
    public IndexFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        mBinding = FragmentNavigationIndexBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    protected IndexPresenter createPresent() {
        return mPresenter;
    }

    @Override
    public <T> LifecycleTransformer<T> getBindToLifecycle() {
        return bindToLifecycle();
    }

    @Override
    public void showError(String error) {

    }

}