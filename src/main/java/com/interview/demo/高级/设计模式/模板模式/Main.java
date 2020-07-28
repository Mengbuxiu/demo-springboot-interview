package com.interview.demo.高级.设计模式.模板模式;

class Main {
    public static void main(String[] args) {
        final SendCustom sendSms = new SendSms();
        sendSms.sendMessage();
        System.out.println("--------------------------------------");
        final SendCustom sendEmail = new SendEmail();
        sendEmail.sendMessage();
    }
}
