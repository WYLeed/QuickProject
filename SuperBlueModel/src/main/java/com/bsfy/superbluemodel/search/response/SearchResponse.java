package com.bsfy.superbluemodel.search.response;

import com.bsfy.superbluemodel.search.SearchResult;

/**
 * Created by bsfy on 2016/9/1.
 */
public interface SearchResponse {

    void onSearchStarted();

    void onDeviceFounded(SearchResult device);

    void onSearchStopped();

    void onSearchCanceled();
}
