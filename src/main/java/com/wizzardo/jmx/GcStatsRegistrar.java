package com.wizzardo.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

/**
 * Created by wizzardo on 06.02.16.
 */
public class GcStatsRegistrar {

    public static void registerBeans() {
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
                GcStats bean = new GcStats(gc);
                mbs.registerMBean(bean, new ObjectName(GcStats.class.getPackage().getName() + ":type=" + GcStats.class.getSimpleName() + ",name=" + gc.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
