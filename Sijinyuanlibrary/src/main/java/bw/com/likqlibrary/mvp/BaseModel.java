package bw.com.likqlibrary.mvp;


import java.net.SocketTimeoutException;

import bw.com.likqlibrary.bean.ResponseBean;
import bw.com.likqlibrary.mvp.ibase.IBaseModel;
import bw.com.likqlibrary.netutils.ICallback;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：
 * 创建人：xueh
 * 创建时间：2016/7/11 13:29
 */
public abstract class BaseModel<E> implements IBaseModel {
    private E api;
    private Subscription mSubscription;

    private Observable threadControl(Observable observable){
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public void setApi(E api) {
        this.api = api;
    }

    public E getApi() {
        return api;
    }

    private Subscription subscribe(Observable observable,
                                   final ICallback callback){
        return observable
                .subscribe(new Subscriber<ResponseBean>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(ResponseBean response) {
                        if(callback!=null) {
                                callback.onCompleted(response);
                        }
                    }
                });
    }

    protected Subscription deploy(Observable observable, final ICallback callback){
        mSubscription = subscribe(threadControl(observable),callback);
        return mSubscription;
    }


    @Override
    public void onDestroy() {
        if (null != mSubscription && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
