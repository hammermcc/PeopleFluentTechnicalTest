package com.people.fluent.technical.test.unit.tests;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;

import junit.framework.TestCase;

public class OrangeProductTest extends TestCase {

	public void testOrangeProductName () {
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		assertEquals("", "Orange", PeopleFluentTechnicalTest.ORANGE_PRODUCT_NAME);
	}

	public void testOrangeProductPrice () {
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		assertEquals("", 25.0d, PeopleFluentTechnicalTest.ORANGE_PRODUCT_PRICE);
	}
}