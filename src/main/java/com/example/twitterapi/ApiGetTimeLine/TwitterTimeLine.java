package com.example.twitterapi.ApiGetTimeLine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * Creating logger objecyt
 *
 * This class used for returning timeline of our tweets posted
 */

@Component
public class TwitterTimeLine {

    /**
     * Using printStatus method
     * We are printing the Timeline obtained
     */
    public void TimeLinePrint(List<Status> info)
    {
        logger.info("Timeline");
        for (Status status : info)
        {
            logger.info("Username",status.getUser().getName());
            logger.info(status.getText());
        }
        logger.info("Successfully Gained Timeline");
    }

    static  Logger logger = LoggerFactory.getLogger(TwitterTimeLine.class);

    /**
     * Extracting keys from our config.properties file
     * Passing them to our getTimeLine method
     * And returning our status of our progress
     */

    public List<Status> returnTimeLine(){

        FileReader twitterKeys= null;
        try {
            twitterKeys = new FileReader("/Users/elamaran.p/Desktop/TwitterApi/Project-java/src/main/java/com/example/twitterapi/ApiConfig/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties fileProperties = new Properties();
        try {
            fileProperties.load(twitterKeys);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String apiKey = fileProperties.getProperty("apikey");
        String apiSecretKey = fileProperties.getProperty("apisecretkey");
        String accessKey = fileProperties.getProperty("accesstoken");
        String accessSecretKey = fileProperties.getProperty("accesssecrettoken");
        List<Status> status=ObtainTimeline(apiKey,apiSecretKey,accessKey,accessSecretKey);
        return status;
    }



    /**
     * Initialising configBuilder and set the keys in it
     * creating twitterFactory object for our configuration
     *using getTieline function we are getting the statuses of our tweets we posted
     * @return
     */
    public static List<Status> ObtainTimeline(String apiKey, String apiSecretKey, String accessToken, String accessSecretToken)
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();

        try
        {
            List<Status> statuses = twitter.getHomeTimeline();
            TwitterTimeLine timelineObject = new TwitterTimeLine();
            timelineObject.TimeLinePrint(statuses);
            return statuses;
        }
        catch(TwitterException e)
        {
            logger.error(e.getMessage(),e);
            return null;
        }

    }
}