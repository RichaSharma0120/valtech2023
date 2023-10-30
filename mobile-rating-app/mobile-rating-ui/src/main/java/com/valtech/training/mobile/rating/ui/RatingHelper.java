package com.valtech.training.mobile.rating.ui;

import com.valtech.training.mobile.rating.MobileRankingService;
import com.valtech.training.mobile.rating.MobileRankingServiceImpl;

public class RatingHelper {

	private MobileRankingService mobileRankingService = new MobileRankingServiceImpl();
	
	public int getRanking(String mobile) {
		
		return mobileRankingService.rankMobile(mobile);
	}
}
