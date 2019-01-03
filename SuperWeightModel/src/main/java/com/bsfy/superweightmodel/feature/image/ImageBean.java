package com.bsfy.superweightmodel.feature.image;

import android.graphics.Bitmap;
import android.support.annotation.StringRes;

import com.bsfy.superutilsmodel.util.Utils;


/**
 * <pre>
 *     author: Blankj
 *
 *     time  : 2017/09/18
 *     desc  : demo about ImageUtils
 * </pre>
 */
public class ImageBean {

    int    resId;
    String name;
    Bitmap image;

    public ImageBean(@StringRes int resId, Bitmap image) {
        name = Utils.getApp().getString(resId);
        this.image = image;
    }

    public ImageBean(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
