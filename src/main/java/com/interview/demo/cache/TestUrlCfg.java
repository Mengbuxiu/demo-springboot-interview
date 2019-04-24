package com.interview.demo.cache;

import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.generator.ConfigurationSource;

import java.net.URL;

import static net.sf.ehcache.config.ConfigurationFactory.parseConfiguration;

/**
 * @author king_zl
 * @version 1.0
 * @description // TODO
 * @date 2019/4/23 14:46
 */
public class TestUrlCfg {
    public static void main(String[] args) {
        URL url = TestUrlCfg.class.getResource("/ehcache.xml");
        Configuration configuration = parseConfiguration(url);
        configuration.setSource(ConfigurationSource.getConfigurationSource());
    }
}
