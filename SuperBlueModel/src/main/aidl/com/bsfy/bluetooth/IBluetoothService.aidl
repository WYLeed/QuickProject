// IBluetoothManager.aidl
package com.bsfy.bluetooth;

// Declare any non-default types here with import statements

import com.bsfy.bluetooth.IResponse;

interface IBluetoothService {
    void callBluetoothApi(int code, inout Bundle args, IResponse response);
}
