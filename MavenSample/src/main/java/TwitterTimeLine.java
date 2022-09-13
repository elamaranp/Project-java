import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * In this class we are getting the timeline of out twitter account
 * using getHomeTimeline method we get the timeline
 * printing the timeline we have got
 */
public class TwitterTimeLine {
    /**
     * using getUser().getName() and getText() we are printing our tweets
     * @param statuses
     */
    static  Logger logger = LoggerFactory.getLogger(PostTweet.class);
    public static void printingStatus(List<Status> statuses){
        logger.info("Home timeline");
        for (Status status : statuses) {
            logger.info(status.getUser().getName() + ":" + status.getText());
        }
    }

    /**
     * Initialising configBuilder and set the keys in it
     * creating twitterFactory object for our configuration and
     * List we are storing our tweets
     * @throws TwitterException
     */

    public static void getTimeLine(String apiKey,String apiSecretkey,String accessToken,String accessSecretToken) {
        ConfigurationBuilder configbuilder = new ConfigurationBuilder();
        configbuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretkey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterFactory = new TwitterFactory(configbuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        List<Status> statuses = null;
        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException e) {
            logger.error(String.valueOf(new RuntimeException(e)));
        }
        TwitterTimeLine printObj = new TwitterTimeLine();
        printObj.printingStatus(statuses);
    }
}
