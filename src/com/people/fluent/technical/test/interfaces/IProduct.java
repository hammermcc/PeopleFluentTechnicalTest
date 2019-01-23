package com.people.fluent.technical.test.interfaces;

public interface IProduct {

	public final static String APPLE_PRODUCT_NAME_PARAM   = "appleProductNameParam";
	public final static String APPLE_PRODUCT_PRICE_PARAM  = "appleProductPriceParam";

	public final static String ORANGE_PRODUCT_NAME_PARAM  = "orangeProductNameParam";
	public final static String ORANGE_PRODUCT_PRICE_PARAM = "orangeProductPriceParam";

	public String getProductName();

	public Double getProductPrice();
}