package com.people.fluent.technical.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.people.fluent.technical.test.interfaces.IPeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;
import com.people.fluent.technical.test.products.AppleProduct;
import com.people.fluent.technical.test.products.OrangeProduct;

public class PeopleFluentTechnicalTest implements IPeopleFluentTechnicalTest {

	public static String APPLE_PRODUCT_NAME   = null;
	public static Double APPLE_PRODUCT_PRICE  = null;
	public static String APPLE_PRODUCT_OFFER  = null;
	public static String ORANGE_PRODUCT_NAME  = null;
	public static Double ORANGE_PRODUCT_PRICE = null;
	public static String ORANGE_PRODUCT_OFFER  = null;
	
	private AppleProduct  appleProduct  = null;
	private OrangeProduct orangeProduct = null;
	
	public PeopleFluentTechnicalTest (String propsFile) {
		getProperties(propsFile);
		
		this.appleProduct = new AppleProduct();
		this.orangeProduct = new OrangeProduct();
	}
	
	public String findTotalPrice (String incommingData) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = parser.parse(incommingData).getAsJsonObject();
		JsonObject jsonRtn = new JsonObject ();
		
		jsonRtn.addProperty("totalPrice", getTotalPrice(jsonObj));
		
		return jsonRtn.toString();
	}
	
	private Double getTotalPrice(JsonObject jsonObj) {
		Double totalPrice = 0.d;
		JsonArray products = (JsonArray)jsonObj.get("products");
		
		if (products != null && products.size() > 0) {
			String product = null;
			for (int i = 0; i < products.size(); i++) {
				product = products.get(i).getAsString();
				if (product.equalsIgnoreCase(this.appleProduct.getProductName())) {
					if (!this.appleProduct.isUnderOffer()) {
						totalPrice += addDouble(this.appleProduct.getProductPrice());
					}
				}
				else {
					if (product.equalsIgnoreCase(this.orangeProduct.getProductName())) {
						if (!this.orangeProduct.isUnderOffer()) {
							totalPrice += addDouble(this.orangeProduct.getProductPrice());
						}
					}
					else {
						System.out.println("No matching Product found for : " + product);
					}
				}
			}
		}
		return totalPrice;
	}
	
	private Double addDouble (Double price) {
		return new BigDecimal(price).doubleValue();
	}
	
	private boolean getProperties (String fileName) {
		Properties props = new Properties();
		
		try (InputStream input = new FileInputStream(fileName)) {
			props.load(input);
			
			APPLE_PRODUCT_NAME   = (String)props.getProperty(IProduct.APPLE_PRODUCT_NAME_PARAM);
			APPLE_PRODUCT_PRICE  = Double.valueOf(props.getProperty(IProduct.APPLE_PRODUCT_PRICE_PARAM));
			APPLE_PRODUCT_OFFER  = (String)props.getProperty(IProduct.APPLE_PRODUCT_OFFER_PARAM);
			ORANGE_PRODUCT_NAME  = props.getProperty(IProduct.ORANGE_PRODUCT_NAME_PARAM);
			ORANGE_PRODUCT_PRICE = Double.valueOf(props.getProperty(IProduct.ORANGE_PRODUCT_PRICE_PARAM));
			ORANGE_PRODUCT_OFFER = (String)props.getProperty(IProduct.ORANGE_PRODUCT_OFFER_PARAM);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	public static void main (String[] args) {
		try {
			JsonParser parser = new JsonParser();
			PeopleFluentTechnicalTest pftt = new PeopleFluentTechnicalTest("resources/properties.txt");
			JsonArray jsonArray = new JsonArray();
			jsonArray.add("Apple");
			jsonArray.add("Apple");
			jsonArray.add("Orange");
			jsonArray.add("Apple");
			JsonObject input = new JsonObject();
			input.add("products", jsonArray);
			String output = pftt.findTotalPrice(input.toString());
			JsonObject outputObj = parser.parse(output).getAsJsonObject();
			Double price = (Double)outputObj.get("totalPrice").getAsDouble();
			System.out.println("Total Price is : " + price);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}