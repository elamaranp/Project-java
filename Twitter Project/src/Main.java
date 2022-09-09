import twitter4j.TwitterException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Main function to tweet a post and get timeline
 * We have created a seperate property file to store keys of my twitter account
 * Through getProperty method we invoke the keys and store it in a bunch of strings
 * create a object of postTweet and GetTimeLine classes
 */
public class Main {
    public static void main(String[] args) throws TwitterException, IOException {
        FileReader twitterKeys=new FileReader("/Users/elamaran.p/Desktop/Twitter project/src/config.properties");
        Properties fileProperties=new Properties();
        fileProperties.load(twitterKeys);
        System.out.println(fileProperties.getProperty("apikey"));
        String apiKey=fileProperties.getProperty("apikey");
        String apiSecretKey=fileProperties.getProperty("apisecretkey");
        String accessKey=fileProperties.getProperty("accesstoken");
        String accessSecretKey=fileProperties.getProperty("accesssecrettoken");
        System.out.println("1 . Post a Tweet");
        System.out.println("2 . Get TimeLlne");
        System.out.println("3 . Exit");
        System.out.println("Enter a choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        PostTweet p = new PostTweet();
        GetTimeLine g = new GetTimeLine();

        switch(choice){
            case 1 :
                p.postTweet(apiKey,apiSecretKey,accessKey,accessSecretKey);
                break;
            case 2:
                g.getTimeLine(apiKey,apiSecretKey,accessKey,accessSecretKey);
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }

    }
}



