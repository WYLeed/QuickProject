package com.bsfy.superbluemodel.connect.listener;

import android.bluetooth.BluetoothGattDescriptor;

/**
 * Created by bsfy on 2016/8/25.
 */
public interface ReadDescriptorListener extends GattResponseListener {

    void onDescriptorRead(BluetoothGattDescriptor descriptor, int status, byte[] value);
}
