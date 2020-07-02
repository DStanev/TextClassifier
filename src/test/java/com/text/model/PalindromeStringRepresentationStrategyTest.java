package com.text.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.text.model.PalindromeStringRepresentationStrategy;
import com.text.model.StringRepresentationStrategy;

public class PalindromeStringRepresentationStrategyTest {

	StringRepresentationStrategy strategy = new PalindromeStringRepresentationStrategy();

	@Test
	public void testDigitsPalindrome() {
		assertTrue(strategy.isTypeOf("12321"));
	}

	@Test
	public void testLettersPalindrome() {
		assertTrue(strategy.isTypeOf("asdsa"));
	}

	@Test
	public void noPalindrome() {
		assertFalse(strategy.isTypeOf("asdf"));
	}

}
