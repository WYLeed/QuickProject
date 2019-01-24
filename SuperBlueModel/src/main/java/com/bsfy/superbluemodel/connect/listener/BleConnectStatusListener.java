package com.bsfy.superbluemodel.connect.listener;

import com.bsfy.superbluemodel.receiver.listener.BluetoothClientListener;

/**
 * Created by bsfy on 16/11/26.
 */

public abstract class BleConnectStatusListener extends BluetoothClientListener {

    public abstract void onConnectStatusChanged(String mac, int status);

    @Override
    public void onSyncInvoke(Object... args) {
        String mac = (String) args[0];
        int status = (int) args[1];
        onConnectStatusChanged(mac, status);
    }
}