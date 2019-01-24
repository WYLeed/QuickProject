package com.bsfy.realproject.cache.login;


import com.bsfy.realproject.cache.ACache;
import com.bsfy.realproject.manager.FileManager;
import com.bsfy.superutilsmodel.util.Utils;


public class LoginCache {
    private final static String fileName = FileManager.SUPER_MAIN_CACHE_FILE;
    private static LoginCache instance = null;
    private ACache mAcache = null;

    public LoginCache() {
        if (Utils.getApp() != null) {
            mAcache = ACache.get(Utils.getApp(), fileName);
        }
    }

    public static LoginCache getInstance() {
        if (instance == null) {
            synchronized (LoginCache.class) {
                if (instance == null) {
                    instance = new LoginCache();
                }
            }
        }
        return instance;
    }

    public void save(String username, String password) {
        if (mAcache != null) {
            mAcache.put(this.getClass().getSimpleName(), new LoginInfo(username, password));
        } else {
            if (Utils.getApp() != null) {
                mAcache = ACache.get(Utils.getApp(), fileName);
                mAcache.put(this.getClass().getName(), new LoginInfo(username, password));
            }
        }
    }

    public LoginInfo get() {
        if (mAcache == null)
            return null;
        return (LoginInfo) mAcache.getAsObject(this.getClass().getSimpleName());
    }
}
