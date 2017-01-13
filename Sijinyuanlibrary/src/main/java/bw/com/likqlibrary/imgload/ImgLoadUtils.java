package bw.com.likqlibrary.imgload;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * 1：类的用途
 * 2:@author:XueHao
 * 3:@ 2016/11/25.
 */

public class ImgLoadUtils {
    private static ImgLoadUtils imgLoadUtils;

    public static ImgLoadUtils getInstance() {
        if (imgLoadUtils == null) {
            synchronized (ImgLoadUtils.class) {
                if (imgLoadUtils == null) {
                    imgLoadUtils = new ImgLoadUtils();
                }
            }
        }
        return imgLoadUtils;
    }

    /**
     * 使用Glide加载图片
     *
     * @param url
     * @param
     */
    public void Load(String url, ImageView img) {

            Glide.with(img.getContext())
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
                    .into(img);

    }

    public void Load(String url, int LoadImg, ImageView img) {

            Glide.with(img.getContext())
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

    public void Load(String url, int LoadImg, int ErrorImg, ImageView img) {

            Glide.with(img.getContext())
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
                    .error(ErrorImg)//图片加载失败时显示图片
                    .into(img);

    }

    /**
     * 使用Glide加载圆角图片
     *
     * @param url
     * @param
     */
    public void LoadCircle(String url, int LoadImg, ImageView img) {

            Glide.with(img.getContext())
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
                    .bitmapTransform(new CropCircleTransformation(img.getContext()))//圆角
                    .into(img);

    }

    public void LoadCircle(String url, int LoadImg, int ErrorImg, ImageView img) {

            Glide.with(img.getContext())
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
                    .error(ErrorImg)//图片加载失败时显示图片
                    .bitmapTransform(new CropCircleTransformation(img.getContext()))//圆角
                    .into(img);

    }

    public void LoadRound(String url, ImageView img) {

            Glide.with(img.getContext())
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
                    .bitmapTransform(new RoundedCornersTransformation(img.getContext(), 8, 8))//圆角
                    .into(img);

    }

    public void LoadRound(String url, int LoadImg, ImageView img) {

            Glide.with(img.getContext())
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
                    .bitmapTransform(new RoundedCornersTransformation(img.getContext(), 8, 8))//圆角
                    .into(img);


    }

    public void LoadRound(String url, int LoadImg, int ErrorImg, ImageView img) {

            Glide.with(img.getContext())
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
                    .error(ErrorImg)//图片加载失败时显示图片
                    .bitmapTransform(new RoundedCornersTransformation(img.getContext(), 8, 8))//圆角
                    .into(img);

    }
}
