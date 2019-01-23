package com.bsfy.superbluemodel.connect.listener;

import android.bluetooth.BluetoothGattCharacteristic;

/**
 * Created by bsfy on 2016/8/25.
 */
public interface ReadCharacterListener extends GattResponseListener {
    void onCharacteristicRead(BluetoothGattCharacteristic characteristic, int status, byte[] value);
}
