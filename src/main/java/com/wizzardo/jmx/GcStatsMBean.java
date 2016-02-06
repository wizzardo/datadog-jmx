package com.wizzardo.jmx;

/**
 * Created by wizzardo on 06.02.16.
 */
public interface GcStatsMBean {
    long getCollectionCountDiff();

    long getCollectionTimeDiff();
}
