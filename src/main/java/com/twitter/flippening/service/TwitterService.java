package com.twitter.flippening.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TwitterService.class);

	public void tweet(String message) {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			LOGGER.info("Sending a tweet with message: {}", message);
			Status status = twitter.updateStatus(message);
			LOGGER.info("Tweet sent successfully [id={}]", status.getId());
		} catch (TwitterException e) {
			LOGGER.error("Exception thrown when sending a tweet", e);
		}
	}
}
