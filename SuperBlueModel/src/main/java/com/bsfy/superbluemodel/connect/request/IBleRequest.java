package com.bsfy.superbluemodel.connect.request;

import com.bsfy.superbluemodel.connect.IBleConnectDispatcher;

/**
 * Created by bsfy on 16/8/25.
 */
public interface IBleRequest {

    void process(IBleConnectDispatcher dispatcher);

    void cancel();
}
