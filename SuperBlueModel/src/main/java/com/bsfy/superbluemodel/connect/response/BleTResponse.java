package com.bsfy.superbluemodel.connect.response;

/**
 * Created by bsfy on 2016/8/28.
 */
public interface BleTResponse<T> {
    void onResponse(int code, T data);
}
