import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * In this class we are getting the timeline of out twitter account
 * using getHomeTimeline method we get the timeline
 * printing the timeline we have got
 */
public class GetTimeLine {
    public static void getTimeLine(String apiKey,String apiSecretkey,String accessToken,String accessSecretToken) throws TwitterException {
        ConfigurationBuilder configbuilder = new ConfigurationBuilder();
        configbuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretkey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecretToken);
        TwitterFactory twitterfactory = new TwitterFactory(configbuilder.build());
        Twitter twitter = twitterfactory.getInstance();
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Home timeline");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" + status.getText());
        }
    }
}
