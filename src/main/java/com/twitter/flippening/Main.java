package com.twitter.flippening;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	private static final long PERIODIC = TimeUnit.MILLISECONDS.convert(6,
			TimeUnit.HOURS);

	public static void main(String[] args) {
		LOGGER.info("The application is running");
		new Timer().schedule(new TwitterTimerTask(), new Date(), PERIODIC);
	}

}
