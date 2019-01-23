package com.people.fluent.technical.test.products;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;

public class OrangeProduct implements IProduct {

	@Override
	public String getProductName() {
		return PeopleFluentTechnicalTest.ORANGE_PRODUCT_NAME;
	}

	@Override
	public Double getProductPrice() {
		return PeopleFluentTechnicalTest.ORANGE_PRODUCT_PRICE;
	}
}