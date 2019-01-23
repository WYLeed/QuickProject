package com.bsfy.superbluemodel.connect.listener;

/**
 * Created by bsfy on 2016/8/25.
 */
public interface ReadRssiListener extends GattResponseListener {
    void onReadRemoteRssi(int rssi, int status);
}
