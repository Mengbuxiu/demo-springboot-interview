package com.pattern.责任链.chain;

import java.math.BigDecimal;

import com.pattern.责任链.chain.*;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		HandlerChain chain = new HandlerChain();
		// 先入先出
		chain.addHandler(new ManagerHandler1000());
		chain.addHandler(new DirectorHandler10000());
		chain.addHandler(new CEOHandler50000());

		chain.process(new Request("大于1百", new BigDecimal("123.45")));
		chain.process(new Request("大于1k", new BigDecimal("1234.56")));
		chain.process(new Request("大于5w", new BigDecimal("123456.78")));
		chain.process(new Request("大于1w", new BigDecimal("12345.67")));
	}
}
