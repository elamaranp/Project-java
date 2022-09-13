import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Creating FileReader for getting keys from config.properties
 * loading the keys and passing keys as arguments for methods postTweet ,getTimeLine
 */
public class Task {
    /**
     * getScanner method for returning a scanner object
     * @return scanner
     */
    public static Scanner getScanner(){
        Scanner scanner;
         scanner = new Scanner(System.in);
        return scanner;
    }

    /**
     * getting twitter secret keys from config.properties file
     * storing it in seperate variables - apiKey, apiSecretKey ,accessKey, accessSecretKey
     * creating teo objects for PostTweet and another one for GetTimeLine
     * based on our needs methods are called
     */

    public static void performingTask(){
        FileReader twitterKeys;
        try {
            twitterKeys = new FileReader("/Users/elamaran.p/Desktop/MavenProject/Project-java/src/main/java/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties fileProperties=new Properties();
        try {
            fileProperties.load(twitterKeys);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String apiKey=fileProperties.getProperty("apikey");
        String apiSecretKey=fileProperties.getProperty("apisecretkey");
        String accessKey=fileProperties.getProperty("accesstoken");
        String accessSecretKey=fileProperties.getProperty("accesssecrettoken");
        System.out.println("1 . Post a Tweet");
        System.out.println("2 . Get TimeLlne");
        System.out.println("3 . Exit");
        System.out.println("Enter a choice : ");

        int choice = getScanner().nextInt();

        PostTweet postTweet = new PostTweet();
        TwitterTimeLine getTimeline = new TwitterTimeLine();

        switch(choice){
            case 1 :
                postTweet.postTweet(apiKey, apiSecretKey, accessKey, accessSecretKey);
                break;
            case 2:
                getTimeline.getTimeLine(apiKey, apiSecretKey, accessKey, accessSecretKey);
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }
    }

    /**
     * Creating object taskObj
     * calling the method performingtask to postTweet and getTimeLine
     */
    public static void perFormTask() {
       Task taskObj = new Task();
       taskObj.performingTask();
    }
}
