package com.people.fluent.technical.test.products;

import com.people.fluent.technical.test.PeopleFluentTechnicalTest;
import com.people.fluent.technical.test.interfaces.IProduct;

public class OrangeProduct implements IProduct {

	private int boughtSoFar = 0;

	@Override
	public String getProductName() {
		return PeopleFluentTechnicalTest.ORANGE_PRODUCT_NAME;
	}

	@Override
	public Double getProductPrice() {
		return PeopleFluentTechnicalTest.ORANGE_PRODUCT_PRICE;
	}

	@Override
	public boolean isUnderOffer() {
		boughtSoFar++;
		boolean offerApplies = doesOfferApply(PeopleFluentTechnicalTest.ORANGE_PRODUCT_OFFER, boughtSoFar);
		if (offerApplies) {
			boughtSoFar = 0;
		}
		return offerApplies;
	}
}