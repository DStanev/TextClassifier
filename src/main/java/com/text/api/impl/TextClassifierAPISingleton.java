package com.text.api.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.text.api.TextClassifierAPI;
import com.text.model.StringRepresentationStrategy;

public class TextClassifierAPISingleton implements TextClassifierAPI {

	private volatile static TextClassifierAPI textClassifierAPI;

	private Set<StringRepresentationStrategy> representationStrategies = new HashSet<StringRepresentationStrategy>();

	// use the getInstance() instead
	private TextClassifierAPISingleton() {
	}

	public static TextClassifierAPI getInstance() {
		TextClassifierAPI result = textClassifierAPI;
		if (result == null) {
			synchronized (TextClassifierAPISingleton.class) {
				result = textClassifierAPI;
				if (result == null) {
					result = new TextClassifierAPISingleton();
					textClassifierAPI = result;
				}
			}
		}
		return result;
	}

	@Override
	public void addRepresentationStrategies(Collection<StringRepresentationStrategy> newStrategies) {
		for (StringRepresentationStrategy strategy : newStrategies) {
			if (!representationStrategies.stream().map(s -> s.getClass()).collect(Collectors.toList())
					.contains(strategy.getClass())) {
				representationStrategies.add(strategy);
			}
		}
	}

	@Override
	public void printTextTypes(String text) {
		System.out.println(getTextTypes(text));
	}

	@Override
	public String getTextTypes(String text) {
		StringBuilder stringBuilder = new StringBuilder(text);
		stringBuilder.append(" types: ");
		boolean noneType = true;
		for (StringRepresentationStrategy stringRepresentor : representationStrategies) {
			if (stringRepresentor.isTypeOf(text)) {
				stringBuilder.append(stringRepresentor.getType());
				stringBuilder.append(";");
				noneType = false;
			}
		}
		if (noneType) {
			stringBuilder.append("none;");
		}
		return stringBuilder.toString();
	}

}
