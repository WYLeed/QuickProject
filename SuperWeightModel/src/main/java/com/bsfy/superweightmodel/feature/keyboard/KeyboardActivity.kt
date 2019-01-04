package com.bsfy.superweightmodel.feature.keyboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.bsfy.superutilsmodel.util.KeyboardUtils
import com.bsfy.superutilsmodel.util.SpanUtils
import com.bsfy.superweightmodel.R
import com.bsfy.superweightmodel.baseview.BaseBackActivity
import com.bsfy.superweightmodel.helper.DialogHelper


/**
 * <pre>
 * author: BSFY
 *
 * time  : 2016/09/27
 * desc  : demo about KeyboardUtils
</pre> *
 */
class KeyboardActivity : BaseBackActivity() {

    internal lateinit var tvAboutKeyboard: TextView
    internal lateinit var etInput: EditText
    private val dialog: AlertDialog? = null

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_keyboard
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        KeyboardUtils.fixAndroidBug5497(this)
        etInput = findViewById(R.id.et_input)
        findViewById<View>(R.id.btn_hide_soft_input).setOnClickListener(this)
        findViewById<View>(R.id.btn_show_soft_input).setOnClickListener(this)
        findViewById<View>(R.id.btn_toggle_soft_input).setOnClickListener(this)
        findViewById<View>(R.id.btn_keyboard_in_fragment).setOnClickListener(this)
        tvAboutKeyboard = findViewById(R.id.tv_about_keyboard)

        KeyboardUtils.registerSoftInputChangedListener(this
        ) { height ->
            tvAboutKeyboard.text = SpanUtils()
                    .appendLine("isSoftInputVisible: " + KeyboardUtils.isSoftInputVisible(this@KeyboardActivity))
                    .append("height: " + height)
                    .create()
        }
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {
        val i = view.id
        if (i == R.id.btn_hide_soft_input) {
            KeyboardUtils.hideSoftInput(this)

        } else if (i == R.id.btn_show_soft_input) {
            KeyboardUtils.showSoftInput(this)

        } else if (i == R.id.btn_toggle_soft_input) {
            KeyboardUtils.toggleSoftInput()

        } else if (i == R.id.btn_keyboard_in_fragment) {
            DialogHelper.showKeyboardDialog()
            KeyboardUtils.showSoftInput(this)

        }
    }

    //    @Override
    //    public boolean dispatchTouchEvent(MotionEvent ev) {
    //        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
    //            View v = getCurrentFocus();
    //            if (isShouldHideKeyboard(v, ev)) {
    //                InputMethodManager imm =
    //                        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    //                if (imm == null) return super.dispatchTouchEvent(ev);
    //                imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    //            }
    //        }
    //        return super.dispatchTouchEvent(ev);
    //    }
    //
    //    // 根据 EditText 所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘
    //    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
    //        if (v != null && (v instanceof EditText)) {
    //            int[] l = {0, 0};
    //            v.getLocationInWindow(l);
    //            int left = l[0],
    //                    top = l[1],
    //                    bottom = top + v.getHeight(),
    //                    right = left + v.getWidth();
    //            return !(event.getX() > left && event.getX() < right
    //                    && event.getY() > top && event.getY() < bottom);
    //        }
    //        return false;
    //    }

    override fun onDestroy() {
        KeyboardUtils.unregisterSoftInputChangedListener(this)
        super.onDestroy()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, KeyboardActivity::class.java)
            context.startActivity(starter)
        }
    }
}
