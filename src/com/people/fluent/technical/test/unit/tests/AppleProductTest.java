package com.people.fluent.technical.test.unit.tests;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;

import junit.framework.TestCase;

public class AppleProductTest extends TestCase {
	
	public void testAppleProductName () {
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		assertEquals("", "Apple", PeopleFluentTechnicalTest.APPLE_PRODUCT_NAME);
	}

	public void testAppleProductPrice () {
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		assertEquals("", 60.0d, PeopleFluentTechnicalTest.APPLE_PRODUCT_PRICE);
	}
}