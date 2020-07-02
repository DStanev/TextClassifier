package com.text.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.text.model.StringRepresentationStrategy;
import com.text.model.TextStringRepresentationStrategy;

public class TextStringRepresentationStrategyTest {

	StringRepresentationStrategy strategy = new TextStringRepresentationStrategy();

	@Test
	public void testDigitsAndLetters() {
		assertTrue(strategy.isTypeOf("123asdf"));
	}

	@Test
	public void testNoLetters() {
		assertFalse(strategy.isTypeOf("--"));
	}

}
