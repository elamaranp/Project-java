package com.example.twitterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication automatically contains Configuration,ComponentScan,EnableAutoConfiguration
 * Main SrpingBootappilaction for posting tweet
 * And Getting TimeLine
 */
@SpringBootApplication
public class TwitterApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterApiApplication.class, args);
    }
}
