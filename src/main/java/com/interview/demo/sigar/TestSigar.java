package com.interview.demo.sigar;

import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.jupiter.api.Test;

/**
 * @author Alin
 * @version 1.0
 * @description // TODO
 * @date 2019/7/9 16:22
 */
class TestSigar {
    @Test
    void testSigar() throws SigarException {
        Sigar sigar = new Sigar();
        NetInterfaceConfig cfg = sigar.getNetInterfaceConfig();
        System.out.println(cfg.getAddress());
    }

    @Test
    void testCPU() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 6000;
        long index = 0;
        while (true) {
            double x = Math.sqrt(index);
            long now = System.currentTimeMillis();
            if (now > endTime) {
                break;
            }
            index++;
        }
        System.out.println(index + " Loops in 6 seconds");

    }
}
