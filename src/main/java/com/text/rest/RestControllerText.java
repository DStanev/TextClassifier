package com.text.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.api.TextClassifierAPI;

@RestController
@RequestMapping(path = "/text")
public class RestControllerText {

	@Autowired
	TextClassifierAPI textClassifier;

	@GetMapping(path = "/{text}", produces = "text/plain")
	public String getEmployees(@PathVariable String text) {
		return textClassifier.getTextTypes(text);
	}
}
