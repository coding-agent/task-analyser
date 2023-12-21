package org.example.system_data;

import java.lang.management.*;
import java.util.HashMap;

public class Performance {

    MemoryUsage memUsage;
    MemoryUsage nonHeapMemUsage;
    int processors;
    int threadCount;

    public Performance(){
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        this.memUsage = memBean.getHeapMemoryUsage();
        this.nonHeapMemUsage = memBean.getNonHeapMemoryUsage();

        this.processors = osBean.getAvailableProcessors();

        this.threadCount = threadBean.getThreadCount();

    }


    public HashMap<String, String> getPerformaceMap(){
        HashMap<String, String> performance = new HashMap<>();

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();

        performance.put("processors", String.valueOf(this.processors));
        performance.put("usedMemory", formatSize(this.getTotalMemoryUsage()));
        performance.put("maxMemory", formatSize(this.getTotalMemoryCapacity()));
        performance.put("threadCount", String.valueOf(this.threadCount));

        return performance;
    }


    private long getTotalMemoryUsage(){
        return Math.addExact(this.memUsage.getUsed(), this.nonHeapMemUsage.getUsed());
    }

    private long getTotalMemoryCapacity(){
        return Math.addExact(this.memUsage.getMax(), this.nonHeapMemUsage.getMax());
    }


    private String formatSize(long size) {
        long kb = size / 1024;
        long mb = kb / 1024;
        return mb + " MB";
    }

    private String formatSize(double size) {
        double kb = size / 1024;
        double mb = kb / 1024;
        return mb + " MB";
    }
}
