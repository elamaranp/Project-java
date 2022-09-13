import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * In this class we are posting a tweet in our twitter account
 * creating an object of ConfigurationBuilder
 * using updatestatus we are posting our tweet
 */
public class PostTweet {

    /**
     * getScanner method for returning a scanner object
     * @throws TwitterException
     */
    public static Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    /**
     * Initialising configBuilder and set the keys in it
     * creating twitterFactory object for our configuration
     * using updateStatus we are posting our tweet in our Twitter Account
     */

    public static void postTweet(String apiKey, String apiSecretkey, String accessToken, String accessSecretToken)  {
        final Logger logger = LoggerFactory.getLogger(PostTweet.class);
        logger.info("Enter tweet to get posted:");
        String tweet = getScanner().nextLine();

        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretkey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        try {
            twitter.updateStatus(tweet);
        } catch (TwitterException e) {
            logger.error(String.valueOf(new RuntimeException(e)));
        }
    }
}
