package com.people.fluent.technical.test.unit.tests;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;

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

	public void testOrangeProductOffer () {
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		assertEquals("", IProduct.THREE_FOR_TWO_OFFER, PeopleFluentTechnicalTest.ORANGE_PRODUCT_OFFER);
	}
}