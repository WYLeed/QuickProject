package com.bsfy.superbluemodel.search.response;

import com.bsfy.superbluemodel.search.SearchResult;

public interface BluetoothSearchResponse {
    void onSearchStarted();

    void onDeviceFounded(SearchResult device);

    void onSearchStopped();

    void onSearchCanceled();
}
