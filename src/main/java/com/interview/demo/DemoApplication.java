package com.interview.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class);
        SpringApplication run = new SpringApplication(DemoApplication.class);
        run.setBannerMode(Banner.Mode.OFF);
        run.addListeners();
        run.run(args);
//        ---------------------------------------
//        new SpringApplicationBuilder()
//                .sources(notNull)
//                .child(DemoApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
    }

}

