
# What's the flippening?

“The Flippening” refers to the possible future event when Ethereum overtakes Bitcoin to become the most valuable cryptocurrency in terms of market capitalization

# What does it do?

The application periodically tweets about the progress of ETH flippening. 

# Application stack

* Java 11
* slf4j/logback - logging
* [xchange](https://github.com/knowm/XChange) - fetching market caps
* [twitter4j](https://twitter4j.org/) - sending the tweets


# How to run it?

## Twitter configuration

The following environment variables must be provided:

`twitter4j.oauth.accessToken`
`twitter4j.oauth.accessTokenSecret`
`twitter4j.oauth.consumerKey`
`twitter4j.oauth.consumerSecret`

[Here](https://twitter4j.org/en/configuration.html) are other ways to configure twitter4j: 

## CoinMarketCap 

`src/main/resources/coinmarketcap-secret.keys` 