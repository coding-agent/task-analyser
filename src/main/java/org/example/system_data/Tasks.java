package org.example.system_data;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

public class Tasks {
    public void getTasks() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        operatingSystemMXBean.getAvailableProcessors();
        System.out.println(operatingSystemMXBean.getAvailableProcessors() + " processors");
        System.out.println(operatingSystemMXBean.getSystemLoadAverage() + " SystemLoadAverage");
        System.out.println(operatingSystemMXBean.getArch() + " Arch");
        System.out.println(operatingSystemMXBean.getVersion() + " Version");
        System.out.println(operatingSystemMXBean.getName() + " Name");
        System.out.println(runtimeMXBean.getSystemProperties().toString() + " getSystemProperties");
    };


}
