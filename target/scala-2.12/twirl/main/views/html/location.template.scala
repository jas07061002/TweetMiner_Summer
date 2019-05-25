
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

object location extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, List[Tweet_Object]],play.twirl.api.HtmlFormat.Appendable] {

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
						<h2 class="slds-text-heading_small ">Location Result</h2>
					</div>

				</div>
			</div>
		</div>
		"""),_display_(/*21.4*/for(tweet <- tweets) yield /*21.24*/{_display_(Seq[Any](format.raw/*21.25*/("""
		"""),_display_(/*22.4*/if(tweet.geo != null && tweet.user.location != "")/*22.54*/{_display_(Seq[Any](format.raw/*22.55*/("""

		"""),format.raw/*24.3*/("""<article class="slds-card">
			<div class="slds-card__header slds-grid">
				<header class="slds-media slds-media_center slds-has-flexi-truncate">

					<div class="slds-media__body">
						<h2 class="slds-card__header-title">
							<a
									href=""""),_display_(/*31.17*/routes/*31.23*/.TweetController.userProfile(tweet.user.screen_name)),format.raw/*31.75*/(""""
									class="btn btn-link" role="button" target="_blank">"""),_display_(/*32.62*/tweet/*32.67*/.user.name),format.raw/*32.77*/("""</a>
						</h2>




						Location -  <a
							href=""""),_display_(/*39.15*/routes/*39.21*/.TweetController.locationTweets(tweet.geo.LatLong + tweet.geo.SearchTerm)),format.raw/*39.94*/(""""
							class="btn btn-link" role="button" target="_blank">"""),_display_(/*40.60*/tweet/*40.65*/.user.location),format.raw/*40.79*/("""</a>
						Lat Long - """),_display_(/*41.19*/tweet/*41.24*/.geo.LatLong),format.raw/*41.36*/("""

						"""),_display_(/*43.8*/tweet/*43.13*/.created_at),format.raw/*43.24*/("""
					"""),format.raw/*44.6*/("""</div>
				</header>
			</div>
			<div class="slds-card__body slds-card__body_inner">

				<div class="row p-2">
					<div class="col">
						"""),_display_(/*51.8*/tweet/*51.13*/.full_text),format.raw/*51.23*/("""

						"""),format.raw/*53.7*/("""<br/>

					</div>

				</div>

			</div>
			<footer class="slds-card__footer">

				HastTags -
				"""),_display_(/*63.6*/for( (Hash) <- tweet.entities.hashtags ) yield /*63.46*/{_display_(Seq[Any](format.raw/*63.47*/("""
				"""),format.raw/*64.5*/("""<a
						href=""""),_display_(/*65.14*/routes/*65.20*/.TweetController.HashTagTweets(Hash.text)),format.raw/*65.61*/(""""
						class="btn btn-link" role="button" target="_blank">"""),_display_(/*66.59*/Hash/*66.63*/.text),format.raw/*66.68*/("""</a>
				""")))}),format.raw/*67.6*/("""
			"""),format.raw/*68.4*/("""</footer>
		</article>


		""")))}),format.raw/*72.4*/("""
		""")))}),format.raw/*73.4*/("""
		""")))}),format.raw/*74.4*/("""
	"""),format.raw/*75.2*/("""</ul>
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
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/location.scala.html
                  HASH: bea2f3ac3a4de851904f14ea9905e10764d0019a
                  MATRIX: 976->1|1118->50|1145->52|1169->68|1208->70|1237->73|1317->128|1370->166|1408->167|1437->170|1797->504|1833->524|1872->525|1902->529|1961->579|2000->580|2031->584|2311->837|2326->843|2399->895|2489->958|2503->963|2534->973|2617->1029|2632->1035|2726->1108|2814->1169|2828->1174|2863->1188|2913->1211|2927->1216|2960->1228|2995->1237|3009->1242|3041->1253|3074->1259|3243->1402|3257->1407|3288->1417|3323->1425|3450->1526|3506->1566|3545->1567|3577->1572|3620->1588|3635->1594|3697->1635|3784->1695|3797->1699|3823->1704|3863->1714|3894->1718|3952->1746|3986->1750|4020->1754|4049->1756
                  LINES: 28->1|33->2|34->3|34->3|34->3|37->6|39->8|39->8|39->8|40->9|52->21|52->21|52->21|53->22|53->22|53->22|55->24|62->31|62->31|62->31|63->32|63->32|63->32|70->39|70->39|70->39|71->40|71->40|71->40|72->41|72->41|72->41|74->43|74->43|74->43|75->44|82->51|82->51|82->51|84->53|94->63|94->63|94->63|95->64|96->65|96->65|96->65|97->66|97->66|97->66|98->67|99->68|103->72|104->73|105->74|106->75
                  -- GENERATED --
              */
          