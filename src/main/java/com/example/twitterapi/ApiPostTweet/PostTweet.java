package com.example.twitterapi.ApiPostTweet;

import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * In this class we are posting a tweet in our twitter account
 * creating an object of ConfigurationBuilder
 * using updatestatus we are posting our tweet
 */

@Component
public class PostTweet {

    /**
     * Initialising configBuilder and set the keys in it
     * creating twitterFactory object for our configuration
     * using updateStatus we are posting our tweet in our Twitter Account
     *
     * @return
     */

    public static String postTweet(String tweetMsg)  {
        FileReader twitterKey;
        try {
            twitterKey = new FileReader("/Users/elamaran.p/Desktop/TwitterApi/src/main/java/com/example/twitterapi/ApiConfig/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties Properties = new Properties();
        try {
            Properties.load(twitterKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String apiKey = Properties.getProperty("apikey");
        String apiSecretKey = Properties.getProperty("apisecretkey");
        String accessKey = Properties.getProperty("accesstoken");
        String accessSecretKey = Properties.getProperty("accesssecrettoken");

        final Logger logger = LoggerFactory.getLogger(PostTweet.class);

        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessKey)
                .setOAuthAccessTokenSecret(accessSecretKey);
        TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        try {
            twitter.updateStatus(tweetMsg);
            logger.info("Tweet Posted");
            return "Done Successfully";
        } catch (TwitterException e) {
            logger.info("Error");
            return "Failed";
        }
    }
}
