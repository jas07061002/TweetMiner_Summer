// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jasmi/Downloads/TweetAnalytics Summer/conf/routes
// @DATE:Wed May 22 16:52:36 EDT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  TweetController_2: controllers.TweetController,
  // @LINE:10
  WebSocketTweetController_1: controllers.WebSocketTweetController,
  // @LINE:14
  Assets_0: controllers.Assets,
  // @LINE:15
  webjars_Routes_0: webjars.Routes,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    TweetController_2: controllers.TweetController,
    // @LINE:10
    WebSocketTweetController_1: controllers.WebSocketTweetController,
    // @LINE:14
    Assets_0: controllers.Assets,
    // @LINE:15
    webjars_Routes_0: webjars.Routes
  ) = this(errorHandler, TweetController_2, WebSocketTweetController_1, Assets_0, webjars_Routes_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TweetController_2, WebSocketTweetController_1, Assets_0, webjars_Routes_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.TweetController.index()"""),
    ("""POST""", this.prefix, """controllers.TweetController.search()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/""" + "$" + """userName<[^/]+>""", """controllers.TweetController.userProfile(userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """location/""" + "$" + """location<[^/]+>""", """controllers.TweetController.locationTweets(location:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hashtag/""" + "$" + """hashtag<[^/]+>""", """controllers.TweetController.HashTagTweets(hashtag:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """wordstat/""" + "$" + """wordstat<[^/]+>""", """controllers.TweetController.WordStat(wordstat:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """responsive""", """controllers.WebSocketTweetController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """responsive/WSsocket""", """controllers.WebSocketTweetController.WSsocket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    prefixed_webjars_Routes_0_9.router.documentation,
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_TweetController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TweetController_index0_invoker = createInvoker(
    TweetController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_TweetController_search1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TweetController_search1_invoker = createInvoker(
    TweetController_2.search(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "search",
      Nil,
      "POST",
      this.prefix + """""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:5
  private[this] lazy val controllers_TweetController_userProfile2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TweetController_userProfile2_invoker = createInvoker(
    TweetController_2.userProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "userProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """profile/""" + "$" + """userName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_TweetController_locationTweets3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("location/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TweetController_locationTweets3_invoker = createInvoker(
    TweetController_2.locationTweets(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "locationTweets",
      Seq(classOf[String]),
      "GET",
      this.prefix + """location/""" + "$" + """location<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_TweetController_HashTagTweets4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hashtag/"), DynamicPart("hashtag", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TweetController_HashTagTweets4_invoker = createInvoker(
    TweetController_2.HashTagTweets(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "HashTagTweets",
      Seq(classOf[String]),
      "GET",
      this.prefix + """hashtag/""" + "$" + """hashtag<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_TweetController_WordStat5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("wordstat/"), DynamicPart("wordstat", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TweetController_WordStat5_invoker = createInvoker(
    TweetController_2.WordStat(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TweetController",
      "WordStat",
      Seq(classOf[String]),
      "GET",
      this.prefix + """wordstat/""" + "$" + """wordstat<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_WebSocketTweetController_index6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("responsive")))
  )
  private[this] lazy val controllers_WebSocketTweetController_index6_invoker = createInvoker(
    WebSocketTweetController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocketTweetController",
      "index",
      Nil,
      "GET",
      this.prefix + """responsive""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_WebSocketTweetController_WSsocket7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("responsive/WSsocket")))
  )
  private[this] lazy val controllers_WebSocketTweetController_WSsocket7_invoker = createInvoker(
    WebSocketTweetController_1.WSsocket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocketTweetController",
      "WSsocket",
      Nil,
      "GET",
      this.prefix + """responsive/WSsocket""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:15
  private[this] val prefixed_webjars_Routes_0_9 = Include(webjars_Routes_0.withPrefix(this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + "webjars"))


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_TweetController_index0_route(params@_) =>
      call { 
        controllers_TweetController_index0_invoker.call(TweetController_2.index())
      }
  
    // @LINE:4
    case controllers_TweetController_search1_route(params@_) =>
      call { 
        controllers_TweetController_search1_invoker.call(TweetController_2.search())
      }
  
    // @LINE:5
    case controllers_TweetController_userProfile2_route(params@_) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_TweetController_userProfile2_invoker.call(TweetController_2.userProfile(userName))
      }
  
    // @LINE:6
    case controllers_TweetController_locationTweets3_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_TweetController_locationTweets3_invoker.call(TweetController_2.locationTweets(location))
      }
  
    // @LINE:7
    case controllers_TweetController_HashTagTweets4_route(params@_) =>
      call(params.fromPath[String]("hashtag", None)) { (hashtag) =>
        controllers_TweetController_HashTagTweets4_invoker.call(TweetController_2.HashTagTweets(hashtag))
      }
  
    // @LINE:8
    case controllers_TweetController_WordStat5_route(params@_) =>
      call(params.fromPath[String]("wordstat", None)) { (wordstat) =>
        controllers_TweetController_WordStat5_invoker.call(TweetController_2.WordStat(wordstat))
      }
  
    // @LINE:10
    case controllers_WebSocketTweetController_index6_route(params@_) =>
      call { 
        controllers_WebSocketTweetController_index6_invoker.call(WebSocketTweetController_1.index)
      }
  
    // @LINE:11
    case controllers_WebSocketTweetController_WSsocket7_route(params@_) =>
      call { 
        controllers_WebSocketTweetController_WSsocket7_invoker.call(WebSocketTweetController_1.WSsocket)
      }
  
    // @LINE:14
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  
    // @LINE:15
    case prefixed_webjars_Routes_0_9(handler) => handler
  }
}
