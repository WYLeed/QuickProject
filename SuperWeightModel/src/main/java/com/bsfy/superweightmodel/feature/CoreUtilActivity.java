package com.bsfy.superweightmodel.feature;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.BSFY.utilcode.pkg.feature.adaptScreen.AdaptScreenActivity;
import com.BSFY.utilcode.pkg.feature.vibrate.VibrateActivity;
import com.bsfy.superutilsmodel.util.BusUtils;
import com.bsfy.superweightmodel.R;
import com.bsfy.superweightmodel.base.BaseBackActivity;
import com.bsfy.superweightmodel.feature.activity.ActivityActivity;
import com.bsfy.superweightmodel.feature.app.AppActivity;
import com.bsfy.superweightmodel.feature.bar.BarActivity;
import com.bsfy.superweightmodel.feature.blur.BlurActivity;
import com.bsfy.superweightmodel.feature.clean.CleanActivity;
import com.bsfy.superweightmodel.feature.device.DeviceActivity;
import com.bsfy.superweightmodel.feature.fragment.FragmentActivity;
import com.bsfy.superweightmodel.feature.image.ImageActivity;
import com.bsfy.superweightmodel.feature.keyboard.KeyboardActivity;
import com.bsfy.superweightmodel.feature.log.LogActivity;
import com.bsfy.superweightmodel.feature.metaData.MetaDataActivity;
import com.bsfy.superweightmodel.feature.network.NetworkActivity;
import com.bsfy.superweightmodel.feature.path.PathActivity;
import com.bsfy.superweightmodel.feature.permission.PermissionActivity;
import com.bsfy.superweightmodel.feature.phone.PhoneActivity;
import com.bsfy.superweightmodel.feature.process.ProcessActivity;
import com.bsfy.superweightmodel.feature.reflect.ReflectActivity;
import com.bsfy.superweightmodel.feature.resource.ResourceActivity;
import com.bsfy.superweightmodel.feature.sdcard.SDCardActivity;
import com.bsfy.superweightmodel.feature.snackbar.SnackbarActivity;
import com.bsfy.superweightmodel.feature.sp.SPActivity;
import com.bsfy.superweightmodel.feature.span.SpanActivity;
import com.bsfy.superweightmodel.feature.toast.ToastActivity;

/**
 * <pre>
 *     author: BSFY
 *
 *     time  : 2016/09/29
 *     desc  :
 * </pre>
 */
public class CoreUtilActivity extends BaseBackActivity {

    @BusUtils.Subscribe(name = "CoreUtilActivity#start")
    public static void start(Context context) {
        Intent starter = new Intent(context, CoreUtilActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_util_core;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        setTitle(R.string.core_util);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    public void coreUtilClick(View view) {

    }

    public void activityClick(View view) {
        ActivityActivity.start(this);
    }

    public void adaptScreenClick(View view) {
        AdaptScreenActivity.Companion.start(this);
    }

    public void appClick(View view) {
        AppActivity.start(this);
    }

    public void barClick(View view) {
        BarActivity.start(this);
    }

    public void blurClick(View view) {
        BlurActivity.start(this);
    }

    public void cleanClick(View view) {
        CleanActivity.start(this);
    }

    public void crashClick(View view) {
        throw new NullPointerException("crash test");
    }

    public void deviceClick(View view) {
        DeviceActivity.start(this);
    }

    public void fragmentClick(View view) {
        FragmentActivity.start(this);
    }

    public void imageClick(View view) {
        ImageActivity.start(this);
    }

    public void keyboardClick(View view) {
        KeyboardActivity.start(this);
    }

    public void logClick(View view) {
        LogActivity.start(this);
    }

    public void metaDataClick(View view) {
        MetaDataActivity.start(this);
    }

    public void networkClick(View view) {
        NetworkActivity.start(this);
    }

    public void pathClick(View view) {
        PathActivity.start(this);
    }

    public void permissionClick(View view) {
        PermissionActivity.start(this);
    }

    public void phoneClick(View view) {
        PhoneActivity.start(this);
    }

    public void processClick(View view) {
        ProcessActivity.start(this);
    }

    public void reflectClick(View view) {
        ReflectActivity.start(this);
    }

    public void resourceClick(View view) {
        ResourceActivity.start(this);
    }

    public void sdcardClick(View view) {
        SDCardActivity.start(this);
    }

    public void snackbarClick(View view) {
        SnackbarActivity.start(this);
    }

    public void spClick(View view) {
        SPActivity.start(this);
    }

    public void spannableClick(View view) {
        SpanActivity.start(this);
    }

    public void toastClick(View view) {
        ToastActivity.start(this);
    }

    public void vibrateClick(View view) {
        VibrateActivity.Companion.start(this);
    }
}
