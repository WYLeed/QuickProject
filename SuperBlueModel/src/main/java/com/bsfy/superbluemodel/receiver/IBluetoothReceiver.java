package com.bsfy.superbluemodel.receiver;

import com.bsfy.superbluemodel.receiver.listener.BluetoothReceiverListener;

/**
 * Created by bsfy on 2016/11/25.
 */

public interface IBluetoothReceiver {

    void register(BluetoothReceiverListener listener);
}
