package com.bsfy.realproject.vm;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.bsfy.httpmodel.SuperHttpManager;
import com.bsfy.httpmodel.callback.NormalCallBack;
import com.bsfy.httpmodel.exception.ApiException;
import com.bsfy.httpmodel.model.HttpHeaders;
import com.bsfy.realproject.cache.login.LoginInfo;
import com.bsfy.realproject.manager.HttpManager;
import com.bsfy.superutilsmodel.util.ToastUtils;
import com.bsfy.superweightmodel.baseview.BaseModel;
import com.shuyu.github.kotlin.model.bean.AccountUser;

import retrofit2.Response;

/**
 * 作者: Created by bsfy on 2019/1/4.
 */

public class LoginModel extends BaseModel {

    private Application context;


    private LiveData<LoginInfo> loginInfoLiveData;

    public LoginModel(Application application) {
        super(application);
        context = application;
    }


    public void login(String account, String password) {
//        HttpHeaders httpHeaders = new HttpHeaders();

//        SuperHttpManager.post(HttpManager.LOGIN_AUTHORI_ZATION)
//                .headers(httpHeaders)
//                .upJson(GsonUtils.toJson(LoginRequest.Companion.generate()))//这种方式会自己把对象转成json提交给服务器
//                .execute(new NormalCallBack<Response<AuthModel>>() {
//                    @Override
//                    public void onError(ApiException e) {
//                        ToastUtils.showShort("登录失败！" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(Response<AuthModel> authModelResponse) {
//                        ToastUtils.showShort("登录成功！");
//                    }
//                });


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("forceNetWork",true+"");

        SuperHttpManager.post(HttpManager.ACCOUNT_INFO_USER)
                .headers(httpHeaders)
                .execute(new NormalCallBack<Response<AccountUser>>() {
                    @Override
                    public void onSuccess(Response<AccountUser> authModelResponse) {
                        ToastUtils.showShort("登录成功！");
                    }


                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort("登录失败！" + e.getMessage());
                    }
                });


    }


}
