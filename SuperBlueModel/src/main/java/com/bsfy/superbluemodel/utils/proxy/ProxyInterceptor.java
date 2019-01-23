package com.bsfy.superbluemodel.utils.proxy;

import java.lang.reflect.Method;

/**
 * Created by bsfy on 2016/9/18.
 */
public interface ProxyInterceptor {
    boolean onIntercept(Object object, Method method, Object[] args);
}
