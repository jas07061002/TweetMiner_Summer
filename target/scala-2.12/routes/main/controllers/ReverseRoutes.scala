// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jasmi/Downloads/TweetAnalytics Summer/conf/routes
// @DATE:Wed May 22 16:52:36 EDT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers {

  // @LINE:10
  class ReverseWebSocketTweetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "responsive")
    }
  
    // @LINE:11
    def WSsocket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "responsive/WSsocket")
    }
  
  }

  // @LINE:2
  class ReverseTweetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def userProfile(userName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userName", userName)))
    }
  
    // @LINE:8
    def WordStat(wordstat:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "wordstat/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("wordstat", wordstat)))
    }
  
    // @LINE:6
    def locationTweets(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "location/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:4
    def search(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:7
    def HashTagTweets(hashtag:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hashtag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("hashtag", hashtag)))
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
