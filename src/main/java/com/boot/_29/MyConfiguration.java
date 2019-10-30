package com.boot._29;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

//@Configuration
public class MyConfiguration {

	//@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = null;
		HttpMessageConverter<?> another = null;
		return new HttpMessageConverters(additional, another);
	}

}