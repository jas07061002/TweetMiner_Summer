package models;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents an entity object which retrieves the hashtags detail from JSON response of Twitter API
 * @version 1.0
 * @see Entity_Object
 * @Author Dhruv Bhalodi
 * @since 2018-07-30
 */
public class Entity_Object {
    /**
     * hashtags is a List of  HashTags_Object
     */
    public List<HashTags_Object> hashtags = new ArrayList<>();
}
