package com.bsfy.superbluemodel.receiver;

import com.bsfy.superbluemodel.receiver.listener.BluetoothReceiverListener;

import java.util.List;

/**
 * Created by bsfy on 16/11/26.
 */

public interface IReceiverDispatcher {

    List<BluetoothReceiverListener> getListeners(Class<?> clazz);
}
