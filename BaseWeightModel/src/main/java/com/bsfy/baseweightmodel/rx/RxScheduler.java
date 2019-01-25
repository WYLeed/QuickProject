package com.bsfy.baseweightmodel.rx;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: Created by wangyu on 2019/1/10.
 */

public class RxScheduler {

    //主线程做操作

    public static void doOnUIThread(UITask uiTask) {
        Observable
                .just(uiTask)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(UITask::doOnUI);
    }

    //主线程做操作
    public static void doOnUIThreadDelay(UITask uiTask, int time) {
        Observable
                .just(uiTask)
                .delay(time, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(UITask::doOnUI);
    }

    //io线程做操作
    public static void doOnThread(ThreadTask threadTask) {
        Observable
                .just(threadTask)
                .observeOn(Schedulers.io())
                .subscribe(ThreadTask::doOnThread);
    }


    //io线程做操作
    public static void doOnThreadDelay(ThreadTask threadTask, int time) {
        Observable
                .just(threadTask)
                .delay(time, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io()).subscribe(ThreadTask::doOnThread);
    }


    public interface ThreadTask {
        void doOnThread();
    }

    public interface UITask {
        void doOnUI();
    }


}
