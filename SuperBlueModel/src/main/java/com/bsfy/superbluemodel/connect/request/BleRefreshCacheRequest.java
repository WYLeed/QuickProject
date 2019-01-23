package com.bsfy.superbluemodel.connect.request;

import com.bsfy.superbluemodel.Code;
import com.bsfy.superbluemodel.connect.response.BleGeneralResponse;

/**
 * Created by liwentian on 2017/2/15.
 */

public class BleRefreshCacheRequest extends BleRequest {

    public BleRefreshCacheRequest(BleGeneralResponse response) {
        super(response);
    }

    @Override
    public void processRequest() {
        refreshDeviceCache();

        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                onRequestCompleted(Code.REQUEST_SUCCESS);
            }
        }, 3000);
    }
}
