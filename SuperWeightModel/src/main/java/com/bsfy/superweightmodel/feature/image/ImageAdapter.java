package com.bsfy.superweightmodel.feature.image;

import android.support.annotation.LayoutRes;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsfy.superweightmodel.R;
import com.bsfy.superweightmodel.baseview.rv.BaseViewHolder;
import com.bsfy.superweightmodel.baseview.rv.adapter.SingleAdapter;

import java.util.List;

/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2017/09/18
 *     desc  : demo about ImageUtils
 * </pre>
 */
public class ImageAdapter extends SingleAdapter<ImageBean> {

    public ImageAdapter(List<ImageBean> list, @LayoutRes int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, ImageBean data) {
        TextView textView = holder.getView(R.id.tv_image_name);
        textView.setText(data.getName());
        ImageView image = holder.getView(R.id.iv_image);
        image.setImageBitmap(data.getImage());
    }
}
