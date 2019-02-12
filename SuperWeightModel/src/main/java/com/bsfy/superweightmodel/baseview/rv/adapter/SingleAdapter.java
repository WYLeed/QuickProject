package com.bsfy.superweightmodel.baseview.rv.adapter;

import android.support.annotation.LayoutRes;

import java.util.List;

/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2017/08/22
 *     desc  :
 * </pre>
 *
 * @author Administrator
 */
public abstract class SingleAdapter<M> extends BaseAdapter<M> {

    private final int mLayoutId;

    public SingleAdapter(List<M> list, @LayoutRes int layoutId) {
        setData(list);
        mLayoutId = layoutId;
    }

    @Override
    protected int bindLayout(final int viewType) {
        return mLayoutId;
    }

}
