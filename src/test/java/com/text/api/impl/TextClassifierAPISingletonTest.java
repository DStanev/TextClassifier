package com.text.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.text.api.TextClassifierAPI;
import com.text.api.impl.TextClassifierAPISingleton;
import com.text.model.EmptyStringRepresentationStrategy;
import com.text.model.NumberStringRepresentationStrategy;
import com.text.model.PalindromeStringRepresentationStrategy;
import com.text.model.StringRepresentationStrategy;
import com.text.model.TextStringRepresentationStrategy;

public class TextClassifierAPISingletonTest {

	static TextClassifierAPI textClassifier = TextClassifierAPISingleton.getInstance();

	@BeforeClass
	public static void setup() {
		Set<StringRepresentationStrategy> strategies = new HashSet<StringRepresentationStrategy>();
		strategies.add(new PalindromeStringRepresentationStrategy());
		strategies.add(new EmptyStringRepresentationStrategy());
		strategies.add(new TextStringRepresentationStrategy());
		strategies.add(new NumberStringRepresentationStrategy());

		textClassifier.addRepresentationStrategies(strategies);
	}

	@Test
	public void testPalindromeAndNumber() {
		String result = textClassifier.getTextTypes("12321");
		assertTrue(result.contains("palindrome"));
		assertTrue(result.contains("number"));
		assertTrue(!result.contains("text"));
		assertTrue(!result.contains("none"));
	}

	@Test
	public void testPalindromeAndText() {
		String result = textClassifier.getTextTypes("12asa21");
		assertTrue(result.contains("palindrome"));
		assertTrue(result.contains("text"));
		assertTrue(!result.contains("number"));
		assertTrue(!result.contains("none"));
	}

	@Test
	public void testEmpty() {
		assertEquals(" types: empty;", textClassifier.getTextTypes(""));
	}

	@Test
	public void testNotEmptyWhiteSpacesPalindrome() {
		assertEquals("  types: palindrome;", textClassifier.getTextTypes(" "));
	}

	@Test
	public void testOnlyText() {
		assertEquals("asdf--- types: text;", textClassifier.getTextTypes("asdf---"));
	}

	@Test
	public void testOnlyPalindrome() {
		String result = textClassifier.getTextTypes("---");
		assertTrue(result.contains("palindrome"));
		assertTrue(!result.contains("text"));
	}

	@Test
	public void testNone() {
		assertEquals("-+ types: none;", textClassifier.getTextTypes("-+"));
	}

}
