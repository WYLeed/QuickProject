package com.bsfy.superbluemodel.connect.listener;

import com.bsfy.superbluemodel.model.BleGattProfile;

/**
 * Created by bsfy on 2016/8/25.
 */
public interface ServiceDiscoverListener extends GattResponseListener {
    void onServicesDiscovered(int status, BleGattProfile profile);
}
