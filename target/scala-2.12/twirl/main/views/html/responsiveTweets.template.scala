
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

object responsiveTweets extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[org.webjars.play.WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webJarsUtil: org.webjars.play.WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("ResponsiveTweetSearch")/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""
"""),format.raw/*4.1*/("""<div class="container">
    <div class="input-group mt-3 mb-3">

        <input id="searchword" type="text" class="slds-input" name="searchString" placeholder="enter search term"
        >
        <div class="input-group-append">
            <button id="submit" class="slds-button slds-button_brand" type="submit">submit</button>
        </div>
    </div>
</div>

<div class="container" id="body">
    <!-- This container would be filled by script below -->
</div>

"""),_display_(/*19.2*/Html(webJarsUtil.script("jquery.min.js"))),format.raw/*19.43*/("""

"""),format.raw/*21.1*/("""<script language="javascript">
                var Socketconnection = new WebSocket(""""),_display_(/*22.56*/routes/*22.62*/.WebSocketTweetController.WSsocket().webSocketURL()),format.raw/*22.113*/(""""),
                        userProfileUrl = """"),_display_(/*23.44*/routes/*23.50*/.TweetController.userProfile("").url),format.raw/*23.86*/("""";

                var submit = function () """),format.raw/*25.42*/("""{"""),format.raw/*25.43*/("""
                    """),format.raw/*26.21*/("""var word = $("#searchword").val();
                    var searchKey = """),format.raw/*27.37*/("""{"""),format.raw/*27.38*/("""
                        """),format.raw/*28.25*/("""keyword : ''
                    """),format.raw/*29.21*/("""}"""),format.raw/*29.22*/(""";
                    searchKey.keyword = word;
                    Socketconnection.send(JSON.stringify(searchKey));
                """),format.raw/*32.17*/("""}"""),format.raw/*32.18*/(""";

                Socketconnection.onopen = function () """),format.raw/*34.55*/("""{"""),format.raw/*34.56*/("""
                    """),format.raw/*35.21*/("""$("#submit").on('click', submit);
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/(""";

                Socketconnection.onmessage = function (event) """),format.raw/*38.63*/("""{"""),format.raw/*38.64*/("""
                    """),format.raw/*39.21*/("""var tweetsForWord = JSON.parse(event.data);

                    var show = "show";
                    if (Object.keys(tweetsForWord).length > 1) """),format.raw/*42.64*/("""{"""),format.raw/*42.65*/("""
                        """),format.raw/*43.25*/("""show = "";
                    """),format.raw/*44.21*/("""}"""),format.raw/*44.22*/("""
                    """),format.raw/*45.21*/("""for (var tweets in tweetsForWord) """),format.raw/*45.55*/("""{"""),format.raw/*45.56*/("""
						"""),format.raw/*46.7*/("""var keyPhraseId = tweets.split('--')
                        toAppend ='';
                        if (document.getElementById(keyPhraseId[0]) == null) """),format.raw/*48.78*/("""{"""),format.raw/*48.79*/("""
                            """),format.raw/*49.29*/("""var toAppend = '<hr>';
                            toAppend += '<div class="demo-only" style="height: 4rem;"> <div class="slds-notify_container slds-is-relative"> <div class="slds-notify slds-notify_toast slds-theme_success" role="alert">';
							toAppend +=  '<div class="slds-notify__content"> <h2 class="slds-text-heading_small ">Result of  <a href="http://localhost:9000/wordstat/' + keyPhraseId[0] + '" class="btn btn-link" role="button" target="_blank">' + tweets + '</a> </h2> ';
							toAppend += '</div> </div> </div> </div> <div id="' +keyPhraseId[0] + '" > </div>';

                        for (var el in tweetsForWord[tweets]) """),format.raw/*54.63*/("""{"""),format.raw/*54.64*/("""

							 """),format.raw/*56.9*/("""toAppend += '<article class="slds-card"> <div class="slds-card__header slds-grid"> <header class="slds-media slds-media_center slds-has-flexi-truncate"> <div class="slds-media__body"> <h2 class="slds-card__header-title"> <a href="http://localhost:9000/profile/' + tweetsForWord[tweets][el].user.screen_name + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].user.name + '</a> </h2>';
							 if(tweetsForWord[tweets][el].geo != null && tweetsForWord[tweets][el].user.location != "")"""),format.raw/*57.99*/("""{"""),format.raw/*57.100*/("""
							"""),format.raw/*58.8*/("""toAppend +=  'Location -  <a href="http://localhost:9000/location/' + tweetsForWord[tweets][el].geo.LatLong + tweetsForWord[tweets][el].geo.SearchTerm + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].user.location + '</a> Lat Long - ' + tweetsForWord[tweets][el].geo.LatLong;
							"""),format.raw/*59.8*/("""}"""),format.raw/*59.9*/("""
							"""),format.raw/*60.8*/("""toAppend += '<br/> <br/> ' + tweetsForWord[tweets][el].created_at;
							toAppend += '</div> </header> </div> <div class="slds-card__body slds-card__body_inner"> <div class="row p-2"> <div class="col">';
							toAppend += tweetsForWord[tweets][el].full_text;
							toAppend += '<br/> </div> </div> </div> <footer class="slds-card__footer">';
							toAppend += 'HastTags -';
							for( var has in tweetsForWord[tweets][el].entities.hashtags )"""),format.raw/*65.69*/("""{"""),format.raw/*65.70*/("""
							"""),format.raw/*66.8*/("""toAppend += '<a href="http://localhost:9000/hashtag/' + tweetsForWord[tweets][el].entities.hashtags[has].text + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].entities.hashtags[has].text + '</a>';
							"""),format.raw/*67.8*/("""}"""),format.raw/*67.9*/("""
							"""),format.raw/*68.8*/("""toAppend += '</footer> </article>';
                        """),format.raw/*69.25*/("""}"""),format.raw/*69.26*/("""



                            """),format.raw/*73.29*/("""$("#body").prepend($(toAppend));
                        """),format.raw/*74.25*/("""}"""),format.raw/*74.26*/(""" """),format.raw/*74.27*/("""else """),format.raw/*74.32*/("""{"""),format.raw/*74.33*/("""
                            """),format.raw/*75.29*/("""for (var el in tweetsForWord[tweets]) """),format.raw/*75.67*/("""{"""),format.raw/*75.68*/("""
                            """),format.raw/*76.29*/("""var toAppend = '';
							 toAppend += '<article class="slds-card"> <div class="slds-card__header slds-grid"> <header class="slds-media slds-media_center slds-has-flexi-truncate"> <div class="slds-media__body"> <h2 class="slds-card__header-title"> <a href="http://localhost:9000/profile/' + tweetsForWord[tweets][el].user.screen_name + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].user.name + '</a> </h2>';
							 if(tweetsForWord[tweets][el].geo != null && tweetsForWord[tweets][el].user.location != "")"""),format.raw/*78.99*/("""{"""),format.raw/*78.100*/("""
							"""),format.raw/*79.8*/("""toAppend +=  'Location -  <a href="http://localhost:9000/location/' + tweetsForWord[tweets][el].geo.LatLong + tweetsForWord[tweets][el].geo.SearchTerm + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].user.location + '</a> Lat Long - ' + tweetsForWord[tweets][el].geo.LatLong;
							"""),format.raw/*80.8*/("""}"""),format.raw/*80.9*/("""
							"""),format.raw/*81.8*/("""toAppend += '<br/> <br/> ' + tweetsForWord[tweets][el].created_at;
							toAppend += '</div> </header> </div> <div class="slds-card__body slds-card__body_inner"> <div class="row p-2"> <div class="col">';
							toAppend += tweetsForWord[tweets][el].full_text;
							toAppend += '<br/> </div> </div> </div> <footer class="slds-card__footer">';
							toAppend += 'HastTags -';
							for( var has in tweetsForWord[tweets][el].entities.hashtags )"""),format.raw/*86.69*/("""{"""),format.raw/*86.70*/("""
							"""),format.raw/*87.8*/("""toAppend += '<a href="http://localhost:9000/hashtag/' + tweetsForWord[tweets][el].entities.hashtags[has].text + '" class="btn btn-link" role="button" target="_blank">' + tweetsForWord[tweets][el].entities.hashtags[has].text + '</a>';
							"""),format.raw/*88.8*/("""}"""),format.raw/*88.9*/("""
							"""),format.raw/*89.8*/("""toAppend += '</footer> </article>';
                        """),format.raw/*90.25*/("""}"""),format.raw/*90.26*/("""
                            """),format.raw/*91.29*/("""document.getElementById(keyPhraseId[0]).innerHTML = toAppend;
                        """),format.raw/*92.25*/("""}"""),format.raw/*92.26*/("""
                    """),format.raw/*93.21*/("""}"""),format.raw/*93.22*/("""

                """),format.raw/*95.17*/("""}"""),format.raw/*95.18*/("""
        """),format.raw/*96.9*/("""</script>
""")))}),format.raw/*97.2*/("""
"""))
      }
    }
  }

  def render(webJarsUtil:org.webjars.play.WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(webJarsUtil)

  def f:((org.webjars.play.WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (webJarsUtil) => apply(webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/responsiveTweets.scala.html
                  HASH: 7659b948e395c98c6782d217f12086ccbd15476b
                  MATRIX: 981->1|1118->45|1145->47|1182->76|1221->78|1248->79|1741->546|1803->587|1832->589|1945->675|1960->681|2033->732|2107->779|2122->785|2179->821|2252->866|2281->867|2330->888|2429->959|2458->960|2511->985|2572->1018|2601->1019|2763->1153|2792->1154|2877->1211|2906->1212|2955->1233|3033->1283|3062->1284|3155->1349|3184->1350|3233->1371|3408->1518|3437->1519|3490->1544|3549->1575|3578->1576|3627->1597|3689->1631|3718->1632|3752->1639|3932->1791|3961->1792|4018->1821|4688->2463|4717->2464|4754->2474|5299->2991|5329->2992|5364->3000|5711->3320|5739->3321|5774->3329|6248->3775|6277->3776|6312->3784|6580->4025|6608->4026|6643->4034|6731->4094|6760->4095|6820->4127|6905->4184|6934->4185|6963->4186|6996->4191|7025->4192|7082->4221|7148->4259|7177->4260|7234->4289|7806->4833|7836->4834|7871->4842|8218->5162|8246->5163|8281->5171|8755->5617|8784->5618|8819->5626|9087->5867|9115->5868|9150->5876|9238->5936|9267->5937|9324->5966|9438->6052|9467->6053|9516->6074|9545->6075|9591->6093|9620->6094|9656->6103|9697->6114
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|50->19|50->19|52->21|53->22|53->22|53->22|54->23|54->23|54->23|56->25|56->25|57->26|58->27|58->27|59->28|60->29|60->29|63->32|63->32|65->34|65->34|66->35|67->36|67->36|69->38|69->38|70->39|73->42|73->42|74->43|75->44|75->44|76->45|76->45|76->45|77->46|79->48|79->48|80->49|85->54|85->54|87->56|88->57|88->57|89->58|90->59|90->59|91->60|96->65|96->65|97->66|98->67|98->67|99->68|100->69|100->69|104->73|105->74|105->74|105->74|105->74|105->74|106->75|106->75|106->75|107->76|109->78|109->78|110->79|111->80|111->80|112->81|117->86|117->86|118->87|119->88|119->88|120->89|121->90|121->90|122->91|123->92|123->92|124->93|124->93|126->95|126->95|127->96|128->97
                  -- GENERATED --
              */
          