package com.bsfy.quickmodel.vm;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.bsfy.httpmodel.SuperHttpManager;
import com.bsfy.httpmodel.callback.SimpleCallBack;
import com.bsfy.httpmodel.exception.ApiException;
import com.bsfy.quickmodel.cache.login.LoginInfo;
import com.bsfy.quickmodel.entity.request.LoginRequest;
import com.bsfy.quickmodel.manager.HttpManager;
import com.bsfy.quickmodel.manager.token.AuthModel;
import com.bsfy.superutilsmodel.util.ToastUtils;
import com.bsfy.superweightmodel.baseview.BaseModel;

import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者: Created by wangyu on 2019/1/4.
 */

public class LoginModel extends BaseModel {

    private Application context;


    private LiveData<LoginInfo> loginInfoLiveData;

    public LoginModel(Application application) {
        super(application);
        context = application;
    }


    public void login(String account, String password) {

        SuperHttpManager.post(HttpManager.LOGIN_AUTHORI_ZATION)
                .addConverterFactory(GsonConverterFactory.create())
                .upObject(LoginRequest.Companion.generate())//这种方式会自己把对象转成json提交给服务器
                .execute(new SimpleCallBack<Response<AuthModel>>() {
                    @Override
                    public void onError(ApiException e) {
                        ToastUtils.showShort("登录失败！" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(Response<AuthModel> authModelResponse) {
                        ToastUtils.showShort("登录成功！");
                    }
                });


    }


}
