package com.text.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.text.model.NumberStringRepresentationStrategy;
import com.text.model.StringRepresentationStrategy;

public class NumberStringRepresentationStrategyTest {

	StringRepresentationStrategy strategy = new NumberStringRepresentationStrategy();

	@Test
	public void testOnlyDigits() {
		assertTrue(strategy.isTypeOf("123"));
	}

	@Test
	public void testDigitsAndLetters() {
		assertFalse(strategy.isTypeOf("123a"));
	}
	
	@Test
	public void testEmpty() {
		assertFalse(strategy.isTypeOf(""));
	}

}
