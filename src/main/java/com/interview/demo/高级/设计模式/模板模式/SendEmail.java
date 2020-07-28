package com.interview.demo.高级.设计模式.模板模式;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class SendEmail extends SendCustom {
    @Override
    public void to() {
        System.out.println("to: god");
    }

    @Override
    public void from() {
        System.out.println("from: satan");
    }

    @Override
    public void content() {
        System.out.println("\thello, world");
    }

    @Override
    public void send() {
        System.out.println(" send now");
    }

    @Override
    public void date() {
        System.out.println(LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
