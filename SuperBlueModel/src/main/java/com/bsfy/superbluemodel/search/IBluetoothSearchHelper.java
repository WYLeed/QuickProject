package com.bsfy.superbluemodel.search;

import com.bsfy.superbluemodel.search.response.BluetoothSearchResponse;

/**
 * Created by bsfy on 2016/8/28.
 */
public interface IBluetoothSearchHelper {

    void startSearch(BluetoothSearchRequest request, BluetoothSearchResponse response);

    void stopSearch();
}
