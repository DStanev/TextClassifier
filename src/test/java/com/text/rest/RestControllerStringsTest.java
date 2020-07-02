package com.text.rest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

import com.text.main.Application;

public class RestControllerStringsTest {

	@BeforeClass
	public static void setup() {
		SpringApplication.run(Application.class);
	}

	@Test
	public void testPalindromeAndTextRest() {
		final String uri = "http://localhost:8080/text/+-+";

		RestTemplate restTemplate = new RestTemplate();
		assertEquals("+-+ types: palindrome;", restTemplate.getForObject(uri, String.class));
	}

	@Test
	public void testNoneRest() {
		final String uri = "http://localhost:8080/text/-+";

		RestTemplate restTemplate = new RestTemplate();
		assertEquals("-+ types: none;", restTemplate.getForObject(uri, String.class));
	}

	@Test
	public void testNumberRest() {
		final String uri = "http://localhost:8080/text/1234";

		RestTemplate restTemplate = new RestTemplate();
		assertEquals("1234 types: number;", restTemplate.getForObject(uri, String.class));
	}
}
