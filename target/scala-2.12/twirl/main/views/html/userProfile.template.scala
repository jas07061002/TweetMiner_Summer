
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

object userProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[UserTweet_Object,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userProfileAndTweets: UserTweet_Object):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Profile")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
"""),format.raw/*4.1*/("""<div class="demo-only" style="height: 4rem;">
	<div class="slds-notify_container slds-is-relative">
		<div class="slds-notify slds-notify_toast slds-theme_success" role="alert">


			<div class="slds-notify__content">
				<h2 class="slds-text-heading_small ">User Profile Info for """),_display_(/*10.65*/userProfileAndTweets/*10.85*/.userProfile.name),format.raw/*10.102*/("""</h2>
			</div>

		</div>
	</div>
</div>

<div class="container mt-3">
	<div class="media bg-success-light  rounded">
		<div class="media-body">
			<div class="row">
				<div class="col">
					<div class="display-4">"""),_display_(/*22.30*/userProfileAndTweets/*22.50*/.userProfile.name),format.raw/*22.67*/("""</div>
				</div>
			</div>
			<div class="row p-2">
				<div class="col">
					<h5>@ """),_display_(/*27.14*/userProfileAndTweets/*27.34*/.userProfile.screen_name),format.raw/*27.58*/("""</h5>
				</div>
				<div class="col-auto">
					<h5>Created: &nbsp; &nbsp; """),_display_(/*30.34*/userProfileAndTweets/*30.54*/.userProfile.created_at),format.raw/*30.77*/("""</h5>
				</div>
			</div>
			<div class="row p-2">
				<div class="col">
					<h3>"""),_display_(/*35.11*/userProfileAndTweets/*35.31*/.userProfile.description),format.raw/*35.55*/("""</h3>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col text-center">
					<h5>Tweets</h5>
				</div>
				<div class="col text-center">
					<h5>Following</h5>
				</div>
				<div class="col text-center">
					<h5>Followers</h5>
				</div>
				<div class="col text-center">
					<h5>Likes</h5>
				</div>
			</div>
			<div class="row mb-1">
				<div class="col text-center">
					<h5>"""),_display_(/*54.11*/userProfileAndTweets/*54.31*/.userProfile.statuses_count),format.raw/*54.58*/("""</h5>
				</div>
				<div class="col text-center">
					<h5>"""),_display_(/*57.11*/userProfileAndTweets/*57.31*/.userProfile.friends_count),format.raw/*57.57*/("""</h5>
				</div>
				<div class="col text-center">
					<h5>"""),_display_(/*60.11*/userProfileAndTweets/*60.31*/.userProfile.followers_count),format.raw/*60.59*/("""</h5>
				</div>
				<div class="col text-center">
					<h5>"""),_display_(/*63.11*/userProfileAndTweets/*63.31*/.userProfile.favourites_count),format.raw/*63.60*/("""</h5>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<ul class="list-unstyled">
		"""),_display_(/*72.4*/for(tweet <- userProfileAndTweets.tweets) yield /*72.45*/{_display_(Seq[Any](format.raw/*72.46*/("""


		"""),format.raw/*75.3*/("""<article class="slds-card">
			<div class="slds-card__header slds-grid">
				<header class="slds-media slds-media_center slds-has-flexi-truncate">

					<div class="slds-media__body">
						<small class="text-muted"><h6>"""),_display_(/*80.38*/tweet/*80.43*/.created_at),format.raw/*80.54*/("""</h6></small>

					</div>
				</header>
			</div>
			<div class="slds-card__body slds-card__body_inner">

				<div class="row p-2">
					<div class="col">
						"""),_display_(/*89.8*/tweet/*89.13*/.full_text),format.raw/*89.23*/("""

						"""),format.raw/*91.7*/("""<br/>

					</div>

				</div>

			</div>
			<footer class="slds-card__footer">

				HastTags -
				"""),_display_(/*101.6*/for( (Hash) <- tweet.entities.hashtags ) yield /*101.46*/{_display_(Seq[Any](format.raw/*101.47*/("""
				"""),format.raw/*102.5*/("""<a
						href=""""),_display_(/*103.14*/routes/*103.20*/.TweetController.HashTagTweets(Hash.text)),format.raw/*103.61*/(""""
						class="btn btn-link" role="button" target="_blank">"""),_display_(/*104.59*/Hash/*104.63*/.text),format.raw/*104.68*/("""</a>
				""")))}),format.raw/*105.6*/("""
			"""),format.raw/*106.4*/("""</footer>
		</article>



		""")))}),format.raw/*111.4*/("""
	"""),format.raw/*112.2*/("""</ul>
</div>
""")))}))
      }
    }
  }

  def render(userProfileAndTweets:UserTweet_Object): play.twirl.api.HtmlFormat.Appendable = apply(userProfileAndTweets)

  def f:((UserTweet_Object) => play.twirl.api.HtmlFormat.Appendable) = (userProfileAndTweets) => apply(userProfileAndTweets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/userProfile.scala.html
                  HASH: d4357a9f0fbc875dc95d62ce6b5ceaaa0a4885d5
                  MATRIX: 964->1|1098->42|1125->44|1148->59|1187->61|1214->62|1523->344|1552->364|1591->381|1835->598|1864->618|1902->635|2016->723|2045->743|2090->767|2194->844|2223->864|2267->887|2378->971|2407->991|2452->1015|2881->1417|2910->1437|2958->1464|3046->1525|3075->1545|3122->1571|3210->1632|3239->1652|3288->1680|3376->1741|3405->1761|3455->1790|3588->1897|3645->1938|3684->1939|3716->1944|3964->2165|3978->2170|4010->2181|4199->2344|4213->2349|4244->2359|4279->2367|4407->2468|4464->2508|4504->2509|4537->2514|4581->2530|4597->2536|4660->2577|4748->2637|4762->2641|4789->2646|4830->2656|4862->2660|4922->2689|4952->2691
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|41->10|41->10|41->10|53->22|53->22|53->22|58->27|58->27|58->27|61->30|61->30|61->30|66->35|66->35|66->35|85->54|85->54|85->54|88->57|88->57|88->57|91->60|91->60|91->60|94->63|94->63|94->63|103->72|103->72|103->72|106->75|111->80|111->80|111->80|120->89|120->89|120->89|122->91|132->101|132->101|132->101|133->102|134->103|134->103|134->103|135->104|135->104|135->104|136->105|137->106|142->111|143->112
                  -- GENERATED --
              */
          