package com.text.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.text.model.EmptyStringRepresentationStrategy;
import com.text.model.StringRepresentationStrategy;

public class EmptyStringRepresentationStrategyTest {

	StringRepresentationStrategy strategy = new EmptyStringRepresentationStrategy();

	@Test
	public void testEmpty() {
		assertTrue(strategy.isTypeOf(""));
	}

	@Test
	public void testNotEmpty() {
		assertFalse(strategy.isTypeOf("a"));
	}

}
