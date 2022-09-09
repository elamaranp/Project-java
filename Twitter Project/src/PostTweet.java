import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

/**
 * In this class we are posting a tweet in our twitter account
 * creating an object of ConfigurationBuilder
 *using updatestatus we are posting our tweet
 */
public class PostTweet {
    public static void postTweet(String apiKey,String apiSecretkey,String accessToken,String accessSecretToken) throws TwitterException {
        System.out.println("Enter tweet to get posted:");
        Scanner sc = new Scanner(System.in);
        String tweet = sc.nextLine();

        ConfigurationBuilder configbuilder = new ConfigurationBuilder();
        configbuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretkey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterfactory = new TwitterFactory(configbuilder.build());
        Twitter twitter = twitterfactory.getInstance();
        Twitter twit = TwitterFactory.getSingleton();
        twitter.updateStatus(tweet);
    }
}
