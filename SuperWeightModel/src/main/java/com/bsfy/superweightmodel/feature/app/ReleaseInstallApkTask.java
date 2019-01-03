package com.bsfy.superweightmodel.feature.app;


import com.bsfy.superutilsmodel.util.ResourceUtils;
import com.bsfy.superutilsmodel.util.ThreadUtils;
import com.bsfy.superweightmodel.Config;

/**
 * <pre>
 *     author: Blankj
 *
 *     time  : 2018/05/23
 *     desc  :
 * </pre>
 */
public class ReleaseInstallApkTask extends ThreadUtils.SimpleTask<Void> {

    private OnReleasedListener mListener;

    public ReleaseInstallApkTask(final OnReleasedListener listener) {
        mListener = listener;
    }

    @Override
    public Void doInBackground() {
        ResourceUtils.copyFileFromAssets("test_install", Config.TEST_APK_PATH);
        return null;
    }

    @Override
    public void onSuccess(Void result) {
        if (mListener != null) {
            mListener.onReleased();
        }
    }

    public void execute() {
        ThreadUtils.executeByIo(this);
    }
}
