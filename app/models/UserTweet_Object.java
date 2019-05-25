package models;

import java.util.List;

/**
 * Combines the user profile and tweet information related to that user.
 *
 * @author Dhruv Bhalodi
 * @version 1.0.0
 */

public class UserTweet_Object {

    /**
     * User object
     */
    public User_Object userProfile;
    /**
     * Tweet object
     */
    public List<Tweet_Object> tweets;

    /**
     * Creates new object which maps the user profiles to their list of tweets
     * @param userProfile User Profile
     * @param tweets      List of tweets
     */
    public UserTweet_Object(User_Object userProfile, List<Tweet_Object> tweets) {
        this.userProfile = userProfile;
        this.tweets = tweets;
    }

    public User_Object getUserProfile() {
        return userProfile;
    }
    public List<Tweet_Object> getTweets() {
        return tweets;
    }
}
