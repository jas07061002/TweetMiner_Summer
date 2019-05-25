// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/jasmi/Downloads/TweetAnalytics Summer/conf/routes
// @DATE:Wed May 22 16:52:36 EDT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
