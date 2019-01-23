package com.bsfy.superbluemodel;

import com.bsfy.superbluemodel.connect.listener.BleConnectStatusListener;
import com.bsfy.superbluemodel.connect.listener.BluetoothStateListener;
import com.bsfy.superbluemodel.connect.response.BleNotifyResponse;
import com.bsfy.superbluemodel.receiver.listener.BluetoothBondListener;

import java.util.HashMap;
import java.util.List;

/**
 * Created by liwentian on 2017/1/13.
 */

public class BluetoothClientReceiver {

    private HashMap<String, HashMap<String, List<BleNotifyResponse>>> mNotifyResponses;
    private HashMap<String, List<BleConnectStatusListener>> mConnectStatusListeners;
    private List<BluetoothStateListener> mBluetoothStateListeners;
    private List<BluetoothBondListener> mBluetoothBondListeners;
}
