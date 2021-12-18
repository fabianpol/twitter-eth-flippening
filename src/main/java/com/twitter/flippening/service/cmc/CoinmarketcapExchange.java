package com.twitter.flippening.service.cmc;

import org.knowm.xchange.coinmarketcap.pro.v1.CmcExchange;

public class CoinmarketcapExchange extends CmcExchange {

	@Override
	protected void initServices() {
		if (this.marketDataService == null) {
			this.marketDataService = new CoinMarketCapDataService(this);
		}
	}

}
