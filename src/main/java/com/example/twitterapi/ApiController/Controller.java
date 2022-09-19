package com.example.twitterapi.ApiController;
import com.example.twitterapi.ApiPostTweet.PostTweet;
import com.example.twitterapi.ApiGetTimeLine.TwitterTimeLine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twitter4j.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @PostMapping("/api/1.0/twitter/tweet")
    public String PostTweet(@RequestBody String msg){
        PostTweet object=new PostTweet();
        String result=object.postTweet(msg);
        return result;
    }

    @GetMapping("/api/1.0/twitter/timeline")
    public List<Status> TimeLine(){
        TwitterTimeLine object=new TwitterTimeLine();
        List<Status> result=object.returnTimeLine();
        return result;
    }


}
