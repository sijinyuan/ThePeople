package bw.com.likqlibrary.mvp;

import android.os.Bundle;

import bw.com.likqlibrary.mvp.base.BaseActivity;
import bw.com.likqlibrary.mvp.ibase.IBasePresenter;
import bw.com.likqlibrary.mvp.ibase.IBaseView;


/**
 * 类描述：MVP架构下的Activity基类
 * 创建人：xueh
 * 创建时间：2016/7/6 10:27
 */
public abstract class MvpActivity<P extends IBasePresenter> extends BaseActivity implements IBaseView {


    private P mPresenter;

    protected abstract P createPresenter(IBaseView view);

    @Override
    public void initViews(Bundle bundle) {
        mPresenter = createPresenter(this);
        if (mPresenter == null) {
            throw new RuntimeException("presenter muse be in createPresenter");
        }
    }

    @Override
    protected void onDestroy() {
        //避免Presenter持有该对象，先销毁Presenter
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        mPresenter = null;
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }
}