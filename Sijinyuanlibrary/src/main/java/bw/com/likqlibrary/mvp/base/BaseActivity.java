package bw.com.likqlibrary.mvp.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import bw.com.likqlibrary.R;
import bw.com.likqlibrary.mvp.ibase.IOnCreate;
import bw.com.likqlibrary.utils.NetUtils;
import bw.com.likqlibrary.utils.permissionutils.ActivityCollector;
import bw.com.likqlibrary.utils.permissionutils.PermissionListener;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by xueh on 2016/11/8.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements IOnCreate {
    private View mRootView;
    private static PermissionListener mListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 6.0权限封装
         */
        ActivityCollector.addActivity(this);

        if (bindLayout() != 0) {
            mRootView = View.inflate(this, bindLayout(), null);
            setContentView(bindLayout());
            //设置状态栏颜色
//          StatusBarUtil.setColor(this, Color.parseColor("#88FF7F00"),0);
            initViews(savedInstanceState);
            initData();
            loadData();
        } else {
            Log.e("Activity", "onCreate: 返回0");
        }
    }

    /**
     * 获取当前Activity
     *
     * @return
     */
    public BaseActivity getAct() {
        return BaseActivity.this;
    }

    /**
     * 返回根布局View
     *
     * @return
     */
    public View getmRootView() {
        return mRootView;
    }

    /**
     * 使用Okhttputils加载数据
     *
     * @param url
     * @param Callback
     */
    public void OkhttpUtilsLoadData(String url, StringCallback Callback) {
        if (NetUtils.isConnected(this)) {
            OkHttpUtils.get()
                    .url(url)
                    .build()
                    .execute(Callback);
        } else {
            ToastShow("网络不可用！");
        }
    }

    /**
     * 吐司
     *
     * @param text
     */
    public void ToastShow(CharSequence text) {
        Toast.makeText(this, text + "", Toast.LENGTH_SHORT).show();
    }

    /**
     * 跳转
     *
     * @param cls
     */
    public void startAct(Class cls) {
        Intent intent = new Intent(this, cls);

        startActivity(intent);

    }

    /**
     * 跳转
     *
     * @param cls
     * @param bundle
     */
    public void startAct(Class cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /**
     * 销毁的时候制为空
     */
    @Override
    protected void onDestroy() {
        mRootView = null;
        ActivityCollector.removeActivity(this);
        super.onDestroy();

    }

    /**
     * 找控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T findview(int viewId) {
        return (T) findViewById(viewId);
    }

    /**
     * 移除Fragment
     */
    public void removeFragment(BaseFragment baseFragment, int layout) {
        if(baseFragment!=null&&layout!=0){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(baseFragment);
            transaction.commit();
        }

    }

    /**
     * 添加Fragment
     */
    public void addFragment(BaseFragment baseFragment, int layout) {
        if(baseFragment!=null&&layout!=0){
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(layout, baseFragment);
            transaction.commit();
        }

    }

    /**
     * 替换Fragment
     */
    public void replaceFragment(BaseFragment baseFragment, int layout) {
        if(baseFragment!=null&&layout!=0){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layout, baseFragment);
        transaction.commit();
        }
    }

    /**
     *关闭所有Activity
     */
    public void killAll(){
        List<Activity> activitylist = ActivityCollector.getActivitylist();
        for (Activity activity:activitylist) {
            activity.finish();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 加载Toolbar
     * @param toolbar
     * @param title
     * @param color
     */
    protected void initToolbar(Toolbar toolbar, String title, int color){

        toolbar.setTitle(title);
        toolbar.setTitleTextColor(color);
        setSupportActionBar(toolbar);

    }

    /**
     * 初始化DrawerLayout
     * @param mDrawerLayout
     * @param mNavigationView
     * @param mToolbar
     * @param onNavigationItemSelectedListener
     */
    protected void initDrawerLayout(DrawerLayout mDrawerLayout, NavigationView mNavigationView,Toolbar mToolbar, NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mNavigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    /**
     * ***************************************6.0运行时权限***********************************
     */

    public static void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        Activity topActivity = ActivityCollector.getTopActivity();
        if (topActivity == null) {
            return;
        }
        mListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(topActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(topActivity, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            mListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * ***************************************使用Glide加载图片***********************************
     */


    /**
     * 使用Glide加载图片
     *
     * @param url
     * @param
     */
    public void ImgLoad(String url, int LoadImg, ImageView img) {
        Glide.with(this)
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
     * 使用Glide加载圆角图片
     *
     * @param url
     * @param
     */
    public void ImgLoadCircle(String url, int LoadImg, ImageView img) {
        Glide.with(this)
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
                .bitmapTransform(new CropCircleTransformation(this))//圆角
                .into(img);

    }

}
