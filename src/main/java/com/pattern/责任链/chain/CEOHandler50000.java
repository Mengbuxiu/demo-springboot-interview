package com.pattern.责任链.chain;

import java.math.BigDecimal;

public class CEOHandler50000 implements Handler {

	@Override
	public Boolean process(Request request) {
		if (request.getAmount().compareTo(BigDecimal.valueOf(50000)) > 0) {
			return Boolean.FALSE;
		}
		return !request.getName().equalsIgnoreCase("alice");
	}
}
