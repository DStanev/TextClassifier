package com.text.model;

import org.springframework.stereotype.Component;

@Component
public class TextStringRepresentationStrategy implements StringRepresentationStrategy {

	@Override
	public boolean isTypeOf(String text) {
		if (text.isEmpty()) {
			return false;
		}
		char[] chars = text.toCharArray();

		for (char c : chars) {
			if (Character.isLetter(c)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getType() {
		return "text";
	}

}
