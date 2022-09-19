package com.example.twitterapi.ApiController;
import com.example.twitterapi.ApiPostTweet.PostTweet;
import com.example.twitterapi.ApiGetTimeLine.TwitterTimeLine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RestController Annotation that is itself annotated
 * with Controller and ResponseBody
 * Controller controlls all Requests
 */
@RestController
public class Controller {
    /**
     * PostTweet method for posting the tweet
     * When the controller hits a request of /tweet
     * It Maps with the PostTweet Endpoint and executes the Method
     * returns whether the call successfull or not
     */
    @PostMapping("/api/1.0/twitter/tweet")
    public String PostTweet(@RequestBody String msg){
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
    @GetMapping("/api/1.0/twitter/timeline")
    public List<Status> TimeLine(){
        TwitterTimeLine object=new TwitterTimeLine();
        List<Status> result=object.returnTimeLine();
        return result;
    }


}
