
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[String],Map[String, List[Tweet_Object]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(searchForm: Form[String])(tweetsForWord: Map[String, List[Tweet_Object]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("TweetSearch")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
"""),format.raw/*4.1*/("""<div class="container">
    <form action=""""),_display_(/*5.20*/routes/*5.26*/.TweetController.index()),format.raw/*5.50*/("""" method="POST">
            <br/>
            <input type="text" class="slds-input" name="searchString" placeholder="enter search term"
                  >
        <br/> <br/>
                <input class="slds-button slds-button_brand" style="margin-left:50%" type="submit" value="Submit">
    </form>
</div>

"""),_display_(/*14.2*/if(tweetsForWord != null)/*14.27*/{_display_(Seq[Any](format.raw/*14.28*/("""
"""),format.raw/*15.1*/("""<div class="container">
    """),_display_(/*16.6*/for( (word, tweets) <- tweetsForWord ) yield /*16.44*/{_display_(Seq[Any](format.raw/*16.45*/("""
    """),format.raw/*17.5*/("""<hr>
    <div class="demo-only" style="height: 4rem;">
        <div class="slds-notify_container slds-is-relative">
            <div class="slds-notify slds-notify_toast slds-theme_success" role="alert">


                <div class="slds-notify__content">
                    <h2 class="slds-text-heading_small ">Result of  <a
                            href=""""),_display_(/*25.36*/routes/*25.42*/.TweetController.WordStat(word)),format.raw/*25.73*/(""""
                            class="btn btn-link" role="button" target="_blank">"""),_display_(/*26.81*/word),format.raw/*26.85*/("""</a></h2>
                </div>

            </div>
        </div>
    </div>
    """),_display_(/*32.6*/for(tweet <- tweets) yield /*32.26*/{_display_(Seq[Any](format.raw/*32.27*/("""
    """),format.raw/*33.5*/("""<article class="slds-card">
        <div class="slds-card__header slds-grid">
            <header class="slds-media slds-media_center slds-has-flexi-truncate">

                <div class="slds-media__body">
                    <h2 class="slds-card__header-title">
                        <a
                                href=""""),_display_(/*40.40*/routes/*40.46*/.TweetController.userProfile(tweet.user.screen_name)),format.raw/*40.98*/(""""
                                class="btn btn-link" role="button" target="_blank">"""),_display_(/*41.85*/tweet/*41.90*/.user.name),format.raw/*41.100*/("""</a>
                    </h2>



                    """),_display_(/*46.22*/if(tweet.geo != null && tweet.user.location != "")/*46.72*/{_display_(Seq[Any](format.raw/*46.73*/("""

                    """),format.raw/*48.21*/("""Location -  <a
                        href=""""),_display_(/*49.32*/routes/*49.38*/.TweetController.locationTweets(tweet.geo.LatLong + tweet.geo.SearchTerm)),format.raw/*49.111*/(""""
                        class="btn btn-link" role="button" target="_blank">"""),_display_(/*50.77*/tweet/*50.82*/.user.location),format.raw/*50.96*/("""</a>
                    Lat Long - """),_display_(/*51.33*/tweet/*51.38*/.geo.LatLong),format.raw/*51.50*/("""
                    """)))}),format.raw/*52.22*/("""

                    """),_display_(/*54.22*/tweet/*54.27*/.created_at),format.raw/*54.38*/("""
                """),format.raw/*55.17*/("""</div>
            </header>
        </div>
        <div class="slds-card__body slds-card__body_inner">

            <div class="row p-2">
                <div class="col">
                    """),_display_(/*62.22*/tweet/*62.27*/.full_text),format.raw/*62.37*/("""

                    """),format.raw/*64.21*/("""<br/>

                </div>

            </div>

        </div>
        <footer class="slds-card__footer">

            HastTags -
            """),_display_(/*74.14*/for( (Hash) <- tweet.entities.hashtags ) yield /*74.54*/{_display_(Seq[Any](format.raw/*74.55*/("""
            """),format.raw/*75.13*/("""<a
                    href=""""),_display_(/*76.28*/routes/*76.34*/.TweetController.HashTagTweets(Hash.text)),format.raw/*76.75*/(""""
                    class="btn btn-link" role="button" target="_blank">"""),_display_(/*77.73*/Hash/*77.77*/.text),format.raw/*77.82*/("""</a>

            """)))}),format.raw/*79.14*/("""
        """),format.raw/*80.9*/("""</footer>
    </article>
    """)))}),format.raw/*82.6*/("""

    """)))}),format.raw/*84.6*/("""
"""),format.raw/*85.1*/("""</div>
""")))}),format.raw/*86.2*/(""" """)))}))
      }
    }
  }

  def render(searchForm:Form[String],tweetsForWord:Map[String, List[Tweet_Object]]): play.twirl.api.HtmlFormat.Appendable = apply(searchForm)(tweetsForWord)

  def f:((Form[String]) => (Map[String, List[Tweet_Object]]) => play.twirl.api.HtmlFormat.Appendable) = (searchForm) => (tweetsForWord) => apply(searchForm)(tweetsForWord)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/index.scala.html
                  HASH: 516de5d30e9f6e30475911c2f9539982cb03699d
                  MATRIX: 986->1|1154->76|1181->78|1208->97|1247->99|1274->100|1343->143|1357->149|1401->173|1740->486|1774->511|1813->512|1841->513|1896->542|1950->580|1989->581|2021->586|2411->949|2426->955|2478->986|2587->1068|2612->1072|2722->1156|2758->1176|2797->1177|2829->1182|3187->1513|3202->1519|3275->1571|3388->1657|3402->1662|3434->1672|3516->1727|3575->1777|3614->1778|3664->1800|3737->1846|3752->1852|3847->1925|3952->2003|3966->2008|4001->2022|4065->2059|4079->2064|4112->2076|4165->2098|4215->2121|4229->2126|4261->2137|4306->2154|4527->2348|4541->2353|4572->2363|4622->2385|4795->2531|4851->2571|4890->2572|4931->2585|4988->2615|5003->2621|5065->2662|5166->2736|5179->2740|5205->2745|5255->2764|5291->2773|5351->2803|5388->2810|5416->2811|5454->2819
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|36->5|36->5|36->5|45->14|45->14|45->14|46->15|47->16|47->16|47->16|48->17|56->25|56->25|56->25|57->26|57->26|63->32|63->32|63->32|64->33|71->40|71->40|71->40|72->41|72->41|72->41|77->46|77->46|77->46|79->48|80->49|80->49|80->49|81->50|81->50|81->50|82->51|82->51|82->51|83->52|85->54|85->54|85->54|86->55|93->62|93->62|93->62|95->64|105->74|105->74|105->74|106->75|107->76|107->76|107->76|108->77|108->77|108->77|110->79|111->80|113->82|115->84|116->85|117->86
                  -- GENERATED --
              */
          