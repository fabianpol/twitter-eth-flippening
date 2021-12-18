package com.twitter.flippening.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata.CmcQuote;
import org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata.CmcTicker;
import org.knowm.xchange.currency.Currency;

public class MessageFormatter {

	public String getMessage(CmcTicker btc, CmcTicker eth) {
		CmcQuote btcQuote = btc.getQuote().get(Currency.USD.toString());
		CmcQuote ethQuote = eth.getQuote().get(Currency.USD.toString());

		BigDecimal ethMarketCap = ethQuote.getMarketCap();

		double ethPrice = ethQuote.getPrice().doubleValue();
		double ratio = ethMarketCap.doubleValue()
				/ btcQuote.getMarketCap().doubleValue();

		return getMessage(ethMarketCap, ethPrice, ratio);
	}

	private String getMessage(BigDecimal ethMarketCap, double ethPrice,
			double ratio) {
		return String.format(
				"Flippening Status: %.2f%% 🐬\n" + "%s\n" + "\n"
						+ "ETH Price: $%.2f \n" + "ETH Market Cap: $%s",
				ratio * 100, getProgress(ratio), ethPrice,
				prettyPrintBigDecimal(ethMarketCap));
	}

	private String getProgress(double ratio) {
		String result = "";
		int progres = (int) (ratio * 20);
		for (int i = 0; i < 20; i++) {
			result += i < progres ? "▓" : "░";
		}
		return result;
	}

	private String prettyPrintBigDecimal(BigDecimal value) {
		return NumberFormat.getNumberInstance(Locale.US).format(value);
	}

}
