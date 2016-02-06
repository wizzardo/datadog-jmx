package com.wizzardo.jmx;

import java.lang.management.GarbageCollectorMXBean;

/**
 * Created by wizzardo on 06.02.16.
 */
public class GcStats implements GcStatsMBean {
    private GarbageCollectorMXBean collector;
    private volatile long collectionCount;
    private volatile long collectionTime;

    public GcStats(GarbageCollectorMXBean collector) {
        this.collector = collector;
    }

    public synchronized long getCollectionCountDiff() {
        long l = collector.getCollectionCount();
        long result = l - collectionCount;
        collectionCount = l;
        return result;
    }

    public synchronized long getCollectionTimeDiff() {
        long l = collector.getCollectionTime();
        long result = l - collectionTime;
        collectionTime = l;
        return result;
    }
}
