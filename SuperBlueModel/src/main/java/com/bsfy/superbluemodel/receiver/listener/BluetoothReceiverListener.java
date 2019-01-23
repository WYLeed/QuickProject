package com.bsfy.superbluemodel.receiver.listener;

/**
 * Created by bsfy on 17/1/14.
 */

public abstract class BluetoothReceiverListener extends AbsBluetoothListener {

    abstract public String getName();

    @Override
    final public void onSyncInvoke(Object... args) {
        throw new UnsupportedOperationException();
    }
}
