package com.interview.demo.boot_new_feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class MyBean {

    @Autowired
    public MyBean(ApplicationArguments arguments){
        System.out.println(arguments.containsOption("debug"));
        List<String> nonOptionArgs = arguments.getNonOptionArgs();
        System.out.println(nonOptionArgs.toString());
        Iterator<String> iterator = arguments.getOptionNames().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
