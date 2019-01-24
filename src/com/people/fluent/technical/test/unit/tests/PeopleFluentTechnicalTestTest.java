package com.people.fluent.technical.test.unit.tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.people.fluent.technical.test.PeopleFluentTechnicalTest;

import junit.framework.TestCase;

public class PeopleFluentTechnicalTestTest extends TestCase {

	public void testTotalPrice () {
		JsonParser parser = new JsonParser();
		PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
		JsonArray jsonArray = new JsonArray();
		jsonArray.add("Apple");
		jsonArray.add("Apple");
		jsonArray.add("Orange");
		jsonArray.add("Apple");
		jsonArray.add("Orange");
		jsonArray.add("Orange");
		jsonArray.add("Apple");
		JsonObject input = new JsonObject();
		input.add("products", jsonArray);
		String output = pftt.findTotalPrice(input.toString());
		JsonObject outputObj = parser.parse(output).getAsJsonObject();
		Double price = (Double)outputObj.get("totalPrice").getAsDouble();
		assertEquals("Total Price not correct", 170.0d, price);
	}
}