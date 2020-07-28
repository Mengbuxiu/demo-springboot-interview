package com.interview.demo.高级.设计模式.模板模式;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *模板方法的父类
 */
abstract class SendCustom {
	
	public abstract void to();
	public abstract void from();
	public abstract void content();
	public void date() {
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
	public abstract void send();

	/**
	 * 模板方法
	 * 可以加入参数控制是否在子类中执行
	 */
	public final void sendMessage() {
		to();
		from();
		content();
		date();
		send();
	}

}
