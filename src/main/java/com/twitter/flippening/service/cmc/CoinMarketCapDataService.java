package com.twitter.flippening.service.cmc;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata.CmcTicker;
import org.knowm.xchange.coinmarketcap.pro.v1.service.CmcMarketDataService;
import org.knowm.xchange.currency.CurrencyPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoinMarketCapDataService extends CmcMarketDataService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CoinMarketCapDataService.class);

	public CoinMarketCapDataService(Exchange exchange) {
		super(exchange);
	}

	public CmcTicker getCmcTicker(CurrencyPair currencyPair) {
		try {
			return super.getCmcLatestQuote(currencyPair)
					.get(currencyPair.base.getCurrencyCode());
		} catch (IOException ex) {
			LOGGER.error("Failed to get CmcTicker for currency pair: {}",
					currencyPair, ex);
			return null;
		}
	}

}
