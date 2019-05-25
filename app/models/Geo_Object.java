package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents Geo object, which retrieves the latitude and longitude coordinates from JSON response of Twitter API.
 *
 * @author Jasmine Kalra
 * @version 1.0.0
 */
public class Geo_Object {
    /**
     * Coordinates is a list in Double format.
     */
    public List<Double> coordinates = new ArrayList<>();
    /**
     * Latlong in  string format.
     */
    public String LatLong;
    /**
     * Searchterm  is in  string format.
     */
    public String SearchTerm;
}
