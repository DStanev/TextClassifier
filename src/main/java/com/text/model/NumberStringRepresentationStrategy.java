package com.text.model;

import org.springframework.stereotype.Component;

@Component
public class NumberStringRepresentationStrategy implements StringRepresentationStrategy {

	@Override
	public boolean isTypeOf(String text) {
		if (text.isEmpty()) {
			return false;
		}
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isDigit(chars[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getType() {
		return "number";
	}

}
