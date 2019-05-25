// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jasmi/Downloads/TweetAnalytics Summer/conf/routes
// @DATE:Wed May 22 16:52:36 EDT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseWebSocketTweetController WebSocketTweetController = new controllers.ReverseWebSocketTweetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTweetController TweetController = new controllers.ReverseTweetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseWebSocketTweetController WebSocketTweetController = new controllers.javascript.ReverseWebSocketTweetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTweetController TweetController = new controllers.javascript.ReverseTweetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
