package models;

import java.util.List;
import java.util.Objects;

/**
 * Represents User_object, from where we fetch user profile data like name, screenname, description etc
 * from the JSON response of Twitter API.
 *
 * @author Dhruv Bhalodi
 * @version 1.0.0
 */

public class User_Object {
        /**
         * name of the user in string format
         */
        public String name;
        /**
         * screev_name of the user in string format
         */
        public String screen_name;
        /**
         * description of the user in string format
         */
        public String description;
        /**
         * followers count  of the user in Long format
         */
        public Long followers_count;
        /**
         * Friends count of the user in Long format
         */
        public Long friends_count;
        /**
         * Favourites count of the user in Long format
         */
        public Long favourites_count;
        /**
         * Created at (Date) of the user tweets in String format
         */
        public String created_at;
        /**
         * Statuses count  in String format
         */
        public String statuses_count;
        /**
         * Tweet_Object  in list format that contains tweet information
         */
        public List<Tweet_Object> UserTweets;
        /**
         * Location of the user in String format
         */
        public String location;
        public String getScreenName() {
                return screen_name;
        }

}
