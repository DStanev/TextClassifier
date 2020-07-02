package com.text.api;

import java.util.Collection;

import com.text.model.StringRepresentationStrategy;

public interface TextClassifierAPI {

	/**
	 * Prints all types of the text in the standard output using the following
	 * pattern: text type: type1; type2;
	 * 
	 * @param text
	 */
	public void printTextTypes(String text);

	/**
	 * returns string representing all types of the text using the following
	 * pattern: text type: type1; type2;
	 * 
	 * @param text
	 */
	public String getTextTypes(String text);

	/**
	 * Adds new StringRepresentationStrategy for the text classifier
	 * 
	 * @see {@link com.text.model.StringRepresentationStrategy}
	 * @param strategies
	 */
	public void addRepresentationStrategies(Collection<StringRepresentationStrategy> strategies);

}
