package com.twitter.flippening;

import java.util.TimerTask;

import org.knowm.xchange.coinmarketcap.pro.v1.dto.marketdata.CmcTicker;
import org.knowm.xchange.currency.CurrencyPair;

import com.twitter.flippening.service.ExchangeService;
import com.twitter.flippening.service.MessageFormatter;
import com.twitter.flippening.service.TwitterService;

public class TwitterTimerTask extends TimerTask {

	private ExchangeService exchangeService;
	private TwitterService twitterService;
	private MessageFormatter messageFormatter;

	public TwitterTimerTask() {
		this.exchangeService = new ExchangeService();
		this.twitterService = new TwitterService();
		this.messageFormatter = new MessageFormatter();
	}

	@Override
	public void run() {
		CmcTicker btcTicker = exchangeService.getTicker(CurrencyPair.BTC_USD);
		CmcTicker ethTicker = exchangeService.getTicker(CurrencyPair.ETH_USD);
		String message = messageFormatter.getMessage(btcTicker, ethTicker);
		twitterService.tweet(message);
	}

}
