package com.bsfy.superbluemodel.connect;

import com.bsfy.superbluemodel.connect.request.BleRequest;

public interface IBleConnectDispatcher {

    void onRequestCompleted(BleRequest request);
}
