package models;

/**
 * Retrieves a  tweet_object, which fetches tweet details like created date,
 * full text , tweet id, User details from JSON response of Twitter API.
 *
 * @author Debanjana Bhattacharya
 * @version 1.0.0
 */


public class Tweet_Object {
    /**
     * Tweet created date in string format.
     */
    public String created_at;
    /**
     * Full text in string format.
     */
    public String full_text;
    /**
     * User information in user object
     */
    public User_Object user;
    /**
     * Entity information like hashtags in entities object .
     */
    public Entity_Object entities;
    /**
     * Twitter id in string format.
     */
    public String id;
    /**
     * Geo code information like latitude and longitude in geo object .
     */
    public Geo_Object geo;
    /**
     * Word count in long format.
     */
    public Long WordStat;
}
