package com.people.fluent.technical.test.interfaces;

public interface IProduct {

	public final static String APPLE_PRODUCT_NAME_PARAM   = "appleProductNameParam";
	public final static String APPLE_PRODUCT_PRICE_PARAM  = "appleProductPriceParam";
	public final static String APPLE_PRODUCT_OFFER_PARAM  = "appleProductOfferParam";

	public final static String ORANGE_PRODUCT_NAME_PARAM  = "orangeProductNameParam";
	public final static String ORANGE_PRODUCT_PRICE_PARAM = "orangeProductPriceParam";
	public final static String ORANGE_PRODUCT_OFFER_PARAM = "orangeProductOfferParam";
	
	public final static String TWO_FOR_ONE_OFFER          = "2for1";
	public final static String THREE_FOR_TWO_OFFER        = "3for2";

	public String getProductName();

	public Double getProductPrice();
	
	public boolean isUnderOffer();
	
	default boolean doesOfferApply (String currentOffer, int boughtSoFar) {
		boolean offerApplies = false;
		
		if (currentOffer != null && currentOffer.equalsIgnoreCase(TWO_FOR_ONE_OFFER)) {
			if (boughtSoFar == 2) {
				offerApplies = true;
			}
		}
		else {
			if (currentOffer != null && currentOffer.equalsIgnoreCase(THREE_FOR_TWO_OFFER)) {
				if (boughtSoFar == 3) {
					offerApplies = true;
				}
			}
		}
		
		
		return offerApplies;
	}
}