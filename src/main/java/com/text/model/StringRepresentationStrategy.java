package com.text.model;

public interface StringRepresentationStrategy {

	/**
	 * Checks weather text is of the type of this strategy
	 * 
	 * @param text
	 * @return
	 */
	public boolean isTypeOf(String text);

	/**
	 * 
	 * @return the type of this strategy
	 */
	public String getType();

}