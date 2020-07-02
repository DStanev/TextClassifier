package com.text.model;

import org.springframework.stereotype.Component;

@Component
public class EmptyStringRepresentationStrategy implements StringRepresentationStrategy {

	@Override
	public boolean isTypeOf(String text) {
		return text.isEmpty();
	}

	@Override
	public String getType() {
		return "empty";
	}

}
