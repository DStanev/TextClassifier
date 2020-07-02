package com.text.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.text.api.TextClassifierAPI;
import com.text.api.impl.TextClassifierAPISingleton;
import com.text.model.EmptyStringRepresentationStrategy;
import com.text.model.NumberStringRepresentationStrategy;
import com.text.model.PalindromeStringRepresentationStrategy;
import com.text.model.StringRepresentationStrategy;
import com.text.model.TextStringRepresentationStrategy;

public class Main {

	public static void main(String[] args) {
		TextClassifierAPI textClassifierAPI = TextClassifierAPISingleton.getInstance();
		addRepresentationStrategis(textClassifierAPI);

		try (BufferedReader buf = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String nextString = buf.readLine();
				textClassifierAPI.printTextTypes(nextString);

			}
		} catch (IOException e) {
			System.out.println("error while reading from stdin " + e);
		}
	}

	private static void addRepresentationStrategis(TextClassifierAPI textClassifierAPI) {
		Set<StringRepresentationStrategy> strategies = new HashSet<StringRepresentationStrategy>();
		strategies.add(new PalindromeStringRepresentationStrategy());
		strategies.add(new EmptyStringRepresentationStrategy());
		strategies.add(new TextStringRepresentationStrategy());
		strategies.add(new NumberStringRepresentationStrategy());

		textClassifierAPI.addRepresentationStrategies(strategies);
	}
}