package com.bsfy.glidemodel.progress;

/**
 * @author by bsfy on 2017/6/14.
 */
public interface OnProgressListener {
    void onProgress(boolean isComplete, int percentage, long bytesRead, long totalBytes);
}
