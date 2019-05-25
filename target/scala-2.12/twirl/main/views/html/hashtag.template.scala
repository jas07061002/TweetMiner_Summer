
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

object hashtag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, List[Tweet_Object]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweetsForWord: Map[String, List[Tweet_Object]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("location")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""


"""),format.raw/*6.1*/("""<div class="container">
	<ul class="list-unstyled">
		"""),_display_(/*8.4*/for( (word, tweets) <- tweetsForWord ) yield /*8.42*/{_display_(Seq[Any](format.raw/*8.43*/("""
		"""),format.raw/*9.3*/("""<div class="demo-only" style="height: 4rem;">
			<div class="slds-notify_container slds-is-relative">
				<div class="slds-notify slds-notify_toast slds-theme_success" role="alert">
					<div class="slds-notify__content">
						<h2 class="slds-text-heading_small ">Hashtag Result</h2>
					</div>

				</div>
			</div>
		</div>
		"""),_display_(/*19.4*/for(tweet <- tweets) yield /*19.24*/{_display_(Seq[Any](format.raw/*19.25*/("""
		"""),format.raw/*20.3*/("""<article class="slds-card">
			<div class="slds-card__header slds-grid">
				<header class="slds-media slds-media_center slds-has-flexi-truncate">

					<div class="slds-media__body">
						<h2 class="slds-card__header-title">
							<a
									href=""""),_display_(/*27.17*/routes/*27.23*/.TweetController.userProfile(tweet.user.screen_name)),format.raw/*27.75*/(""""
									class="btn btn-link" role="button" target="_blank">"""),_display_(/*28.62*/tweet/*28.67*/.user.name),format.raw/*28.77*/("""</a>

						</h2>



						"""),_display_(/*34.8*/if(tweet.geo != null && tweet.user.location != "")/*34.58*/{_display_(Seq[Any](format.raw/*34.59*/("""
						"""),format.raw/*35.7*/("""Location -  <a
							href=""""),_display_(/*36.15*/routes/*36.21*/.TweetController.locationTweets(tweet.geo.LatLong + tweet.geo.SearchTerm)),format.raw/*36.94*/(""""
							class="btn btn-link" role="button" target="_blank">"""),_display_(/*37.60*/tweet/*37.65*/.user.location),format.raw/*37.79*/("""</a>
						Lat Long - """),_display_(/*38.19*/tweet/*38.24*/.geo.LatLong),format.raw/*38.36*/("""
						""")))}),format.raw/*39.8*/("""

						"""),_display_(/*41.8*/tweet/*41.13*/.created_at),format.raw/*41.24*/("""
					"""),format.raw/*42.6*/("""</div>
				</header>
			</div>
			<div class="slds-card__body slds-card__body_inner">

				<div class="row p-2">
					<div class="col">
						"""),_display_(/*49.8*/tweet/*49.13*/.full_text),format.raw/*49.23*/("""

						"""),format.raw/*51.7*/("""<br/>

					</div>

				</div>

			</div>
			<footer class="slds-card__footer">

				HastTags -
				"""),_display_(/*61.6*/for( (Hash) <- tweet.entities.hashtags ) yield /*61.46*/{_display_(Seq[Any](format.raw/*61.47*/("""
				"""),format.raw/*62.5*/("""<a
						href=""""),_display_(/*63.14*/routes/*63.20*/.TweetController.HashTagTweets(Hash.text)),format.raw/*63.61*/(""""
						class="btn btn-link" role="button" target="_blank">"""),_display_(/*64.59*/Hash/*64.63*/.text),format.raw/*64.68*/("""</a>
				""")))}),format.raw/*65.6*/("""
			"""),format.raw/*66.4*/("""</footer>
		</article>


		""")))}),format.raw/*70.4*/("""
		""")))}),format.raw/*71.4*/("""
	"""),format.raw/*72.2*/("""</ul>
</div>
""")))}))
      }
    }
  }

  def render(tweetsForWord:Map[String, List[Tweet_Object]]): play.twirl.api.HtmlFormat.Appendable = apply(tweetsForWord)

  def f:((Map[String, List[Tweet_Object]]) => play.twirl.api.HtmlFormat.Appendable) = (tweetsForWord) => apply(tweetsForWord)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/hashtag.scala.html
                  HASH: a999e2b8e2eaf109321c042d8299162a5b913f18
                  MATRIX: 975->1|1117->50|1144->52|1168->68|1207->70|1236->73|1316->128|1369->166|1407->167|1436->170|1793->501|1829->521|1868->522|1898->525|2178->778|2193->784|2266->836|2356->899|2370->904|2401->914|2455->942|2514->992|2553->993|2587->1000|2643->1029|2658->1035|2752->1108|2840->1169|2854->1174|2889->1188|2939->1211|2953->1216|2986->1228|3024->1236|3059->1245|3073->1250|3105->1261|3138->1267|3307->1410|3321->1415|3352->1425|3387->1433|3514->1534|3570->1574|3609->1575|3641->1580|3684->1596|3699->1602|3761->1643|3848->1703|3861->1707|3887->1712|3927->1722|3958->1726|4016->1754|4050->1758|4079->1760
                  LINES: 28->1|33->2|34->3|34->3|34->3|37->6|39->8|39->8|39->8|40->9|50->19|50->19|50->19|51->20|58->27|58->27|58->27|59->28|59->28|59->28|65->34|65->34|65->34|66->35|67->36|67->36|67->36|68->37|68->37|68->37|69->38|69->38|69->38|70->39|72->41|72->41|72->41|73->42|80->49|80->49|80->49|82->51|92->61|92->61|92->61|93->62|94->63|94->63|94->63|95->64|95->64|95->64|96->65|97->66|101->70|102->71|103->72
                  -- GENERATED --
              */
          