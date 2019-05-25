// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jasmi/Downloads/TweetAnalytics Summer/conf/routes
// @DATE:Wed May 22 16:52:36 EDT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers.javascript {

  // @LINE:10
  class ReverseWebSocketTweetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebSocketTweetController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "responsive"})
        }
      """
    )
  
    // @LINE:11
    def WSsocket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebSocketTweetController.WSsocket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "responsive/WSsocket"})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseTweetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def userProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.userProfile",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userName", userName0))})
        }
      """
    )
  
    // @LINE:8
    def WordStat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.WordStat",
      """
        function(wordstat0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wordstat/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("wordstat", wordstat0))})
        }
      """
    )
  
    // @LINE:6
    def locationTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.locationTweets",
      """
        function(location0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "location/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("location", location0))})
        }
      """
    )
  
    // @LINE:4
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.search",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def HashTagTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.HashTagTweets",
      """
        function(hashtag0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hashtag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("hashtag", hashtag0))})
        }
      """
    )
  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TweetController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
