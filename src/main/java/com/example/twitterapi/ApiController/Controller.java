package com.example.twitterapi.ApiController;
import com.example.twitterapi.ApiPostTweet.PostTweet;
import com.example.twitterapi.ApiGetTimeLine.TwitterTimeLine;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.Status;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller Annotation maps the tweet and timeline
 * And get back the results 
 */
@org.springframework.stereotype.Controller
public class Controller {
    /**
     * PostTweet method for posting the tweet
     * When the controller hits a mutation of tweet
     * Method will post a tweet in our Twitter account
     * And return the output whether its done successfully or failed to post
     */
    @MutationMapping("tweet")
    public String PostTweet(@Argument String msg){
        PostTweet object=new PostTweet();
        String result=object.postTweet(msg);
        return result;
    }

    /**
     *TimeLine Method for getting the details we posted
     * When the controller hits a query of timeline
     * Method will return the timeline of our post
     * And return the output of our statuses
     */
    @QueryMapping("timeline")
    public List<Status> TimeLine(){
        TwitterTimeLine object=new TwitterTimeLine();
        List<Status> result=object.returnTimeLine();
        return result;
    }


}
