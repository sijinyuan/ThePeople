package bw.com.likqlibrary.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import bw.com.likqlibrary.mvp.ibase.IOnCreate;

/**
 * Created by xueh on 2016/11/9.
 */

public abstract class BaseFragment extends Fragment implements IOnCreate {
    public Activity mActivity;//这个activity就是MainActivity
    private View view;

    /**
     * Fragment创建
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();// 获取当前fragment所依赖的activity
    }

    /**
     * 初始化fragment的布局
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (bindLayout() != 0) {
            view = View.inflate(mActivity, bindLayout(), null);
            initViews(savedInstanceState);
        } else {
            Log.e("Activity", "onCreate: 返回0");
        }

        return view;
    }

    /**
     * fragment所依赖的activity的onCreate方法执行结束
     */

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        loadData();
    }

    /**
     * 返回根布局View
     *
     * @return
     */
    public View getmRootView() {
        return view;
    }

    /**
     * 找控件
     */

    public <T extends View> T findview(int viewId) {
        return (T) view.findViewById(viewId);
    }

    /**
     * 吐司
     *
     * @param text
     */
    public void ToastShow(CharSequence text) {
        Toast.makeText(mActivity, text + "", Toast.LENGTH_SHORT).show();
    }

    /**
     * 使用Okhttputils加载数据
     *
     * @param url
     * @param Callback
     */
    public void OkhttpUtilsLoadData(String url, StringCallback Callback) {
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(Callback);
    }
/**
     * 使用Glide加载图片
     *
     * @param url
     * @param
     */
    public void ImgLoad(String url,int LoadImg,ImageView img){
        Glide.with(mActivity)
                .load(url)
                //缓存策略，默认不缓存原始图，只缓存结果图
                //现改为缓存所有图，否则断网时，类似于瀑布流效果（imageView长款不定时，glide本该去重新加载原始图，然后
                // 根据ImageView的目标尺寸进行相应调整）将无法正常显示；
                //若缓存了原始图，则glide可以从缓存加载原始图，并且进行相应尺寸调整了
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //用原图的1/10作为缩略图，如果缩略图先被加载出来则先显示缩略图
                .thumbnail(0.3f)
//                .fitCenter()
                .centerCrop()
                .crossFade()
                //解决加载出来的瞬间闪一下的问题
                .dontAnimate()
                .placeholder(LoadImg)
                .into(img);

    }
    /**
     * 销毁的时候制为空
     */
    @Override
    public void onDestroy() {
        view = null;
        super.onDestroy();
    }
    
}
