package com.interview.demo.高级.设计模式.模板模式;

/**
 *模板方法的派生类
 */
class SendSms extends SendCustom {

	@Override
	public void to() {
		System.out.println("to: Mark");

	}

	@Override
	public void from() {
		System.out.println("from: Bill");

	}

	@Override
	public void content() {
		System.out.println("\tHello world");

	}

	@Override
	public void send() {
		System.out.println(" Send sms");

	}

}
