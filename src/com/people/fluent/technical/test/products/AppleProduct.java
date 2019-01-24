package com.people.fluent.technical.test.products;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;

public class AppleProduct implements IProduct {

	private int boughtSoFar = 0;

	@Override
	public String getProductName() {
		return PeopleFluentTechnicalTest.APPLE_PRODUCT_NAME;
	}

	@Override
	public Double getProductPrice() {
		return PeopleFluentTechnicalTest.APPLE_PRODUCT_PRICE;
	}

	@Override
	public boolean isUnderOffer() {
		boughtSoFar++;
		boolean offerApplies = doesOfferApply(PeopleFluentTechnicalTest.APPLE_PRODUCT_OFFER, boughtSoFar);
		if (offerApplies) {
			boughtSoFar = 0;
		}
		return offerApplies;
	}
}