package com.people.fluent.technical.test.products;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;

public class AppleProduct implements IProduct {

	@Override
	public String getProductName() {
		return PeopleFluentTechnicalTest.APPLE_PRODUCT_NAME;
	}

	@Override
	public Double getProductPrice() {
		return PeopleFluentTechnicalTest.APPLE_PRODUCT_PRICE;
	}
}