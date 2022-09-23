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
 * RestController Annotation that is itself annotated
 * with Controller and ResponseBody
 * Controller controlls all Requests
 */
@org.springframework.stereotype.Controller
public class Controller {
    /**
     * PostTweet method for posting the tweet
     * When the controller hits a request of /tweet
     * It Maps with the PostTweet Endpoint and executes the Method
     * returns whether the call successfull or not
     */
    @MutationMapping("tweet")
    public String PostTweet(@Argument String msg){
        PostTweet object=new PostTweet();
        String result=object.postTweet(msg);
        return result;
    }

    /**
     *TimeLine Method for getting the details we posted
     * When the controller hits a request of /timeline
     * It Maps with the TimeLine Endpoint and executes the Method
     * returns the result in a list
     */
    @QueryMapping("timeline")
    public List<Status> TimeLine(){
        TwitterTimeLine object=new TwitterTimeLine();
        List<Status> result=object.returnTimeLine();
        return result;
    }


}
