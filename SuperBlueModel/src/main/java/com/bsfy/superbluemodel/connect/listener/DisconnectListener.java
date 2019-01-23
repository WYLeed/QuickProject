package com.bsfy.superbluemodel.connect.listener;

/**
 * Created by bsfy on 2016/9/7.
 */
public interface DisconnectListener extends GattResponseListener {
    void onDisconnected();
}
