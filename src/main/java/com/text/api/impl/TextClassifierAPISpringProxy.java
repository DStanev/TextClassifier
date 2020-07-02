package com.text.api.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.text.api.TextClassifierAPI;
import com.text.model.StringRepresentationStrategy;

@Component
@ComponentScan("com.text.*")
public class TextClassifierAPISpringProxy implements TextClassifierAPI {

	TextClassifierAPI textClassifierAPI = TextClassifierAPISingleton.getInstance();

	@Autowired
	Set<StringRepresentationStrategy> representationStrategies;

	@PostConstruct
	public void init() {
		textClassifierAPI.addRepresentationStrategies(representationStrategies);
	}

	@Override
	public void printTextTypes(String text) {
		textClassifierAPI.printTextTypes(text);
	}

	@Override
	public String getTextTypes(String text) {
		return textClassifierAPI.getTextTypes(text);
	}

	@Override
	public void addRepresentationStrategies(Collection<StringRepresentationStrategy> strategies) {
		// do nothing
	}
}
