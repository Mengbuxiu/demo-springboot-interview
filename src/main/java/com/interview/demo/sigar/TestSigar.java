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
public class TestSigar {
    @Test
    void testSigar() throws SigarException {
        Sigar sigar = new Sigar();
        NetInterfaceConfig cfg = sigar.getNetInterfaceConfig();
        System.out.println(cfg.getAddress());
    }
}
