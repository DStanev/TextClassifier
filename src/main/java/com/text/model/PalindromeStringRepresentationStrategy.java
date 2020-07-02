package com.text.model;

import org.springframework.stereotype.Component;

@Component
public class PalindromeStringRepresentationStrategy implements StringRepresentationStrategy {

	@Override
	public boolean isTypeOf(String text) {
		if (text.isEmpty()) {
			return false;
		}
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[chars.length - i - 1]) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getType() {
		return "palindrome";
	}

}
