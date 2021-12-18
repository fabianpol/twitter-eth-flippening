package com.twitter.flippening.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.coinmarketcap.pro.v1.CmcExchange;
import org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata.CmcTicker;
import org.knowm.xchange.currency.CurrencyPair;

import com.twitter.flippening.service.cmc.CoinMarketCapDataService;
import com.twitter.flippening.service.cmc.CoinmarketcapExchange;

public class ExchangeService {

	private CoinMarketCapDataService cmcMarketDataService;

	public ExchangeService() {
		Exchange exchange = ExchangeFactory.INSTANCE
				.createExchangeWithoutSpecification(
						CoinmarketcapExchange.class);
		exchange.applySpecification(
				((CmcExchange) exchange).getDefaultExchangeSpecification());
		this.cmcMarketDataService = (CoinMarketCapDataService) exchange
				.getMarketDataService();
	}

	public CmcTicker getTicker(CurrencyPair pair) {
		return cmcMarketDataService.getCmcTicker(pair);
	}

}
