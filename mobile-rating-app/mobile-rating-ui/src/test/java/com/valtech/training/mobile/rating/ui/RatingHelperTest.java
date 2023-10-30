package com.valtech.training.mobile.rating.ui;


import org.junit.Test;

import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {

	@Test
	public void testGetRating() {

		RatingHelper helper=new RatingHelper();
		assertEquals(0, helper.getRanking("1234567890"));
	}

}
