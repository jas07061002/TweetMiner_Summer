
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

object wordstatistic extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Map[String, List[Tweet_Object]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(wordstat: Map[String, List[Tweet_Object]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<h1 class="slds-text-align_center" style="color: green; font-weight:bold; font-size:50">Word Count Statistics</h1>
"""),_display_(/*3.2*/main("wordstat")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<table class="slds-table slds-table_bordered slds-table_cell-buffer" align="center" style="width: 45%;">
	<thead>
	<tr class="slds-text-title_caps">
		<th scope="col" class="slds-cell-shrink">
			<div class="slds-truncate" title="Words" align="center"><a href="javascript:void(0);">WORDS</a></div>
		</th>
		<th scope="col" class="slds-cell-shrink">
			<div class="slds-truncate" title="Count" align="center"><a href="javascript:void(0);">TOTAL COUNT</a></div>
		</th>
	</tr>
	</thead>
	"""),_display_(/*15.3*/for( (word, tweets) <- wordstat ) yield /*15.36*/{_display_(Seq[Any](format.raw/*15.37*/("""
	"""),_display_(/*16.3*/for(tweet <- tweets) yield /*16.23*/{_display_(Seq[Any](format.raw/*16.24*/("""
	"""),format.raw/*17.2*/("""<tbody>
	<tr>
		<td data-label="Words">
			<div class="slds-truncate" align="center">"""),_display_(/*20.47*/word),format.raw/*20.51*/("""</div>
		</td>
		<td data-label="Count">
			<div class="slds-truncate" align="center">"""),_display_(/*23.47*/tweet/*23.52*/.WordStat),format.raw/*23.61*/("""</div>
		</td>
	</tr>
	</tbody>
	""")))}),format.raw/*27.3*/("""
	""")))}),format.raw/*28.3*/("""
"""),format.raw/*29.1*/("""</table>
""")))}))
      }
    }
  }

  def render(wordstat:Map[String, List[Tweet_Object]]): play.twirl.api.HtmlFormat.Appendable = apply(wordstat)

  def f:((Map[String, List[Tweet_Object]]) => play.twirl.api.HtmlFormat.Appendable) = (wordstat) => apply(wordstat)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/wordstatistic.scala.html
                  HASH: 484d904314e1c6659aa9fe6e65191fa4599012fe
                  MATRIX: 981->1|1118->45|1259->161|1283->177|1322->179|1349->180|1863->668|1912->701|1951->702|1980->705|2016->725|2055->726|2084->728|2197->814|2222->818|2336->905|2350->910|2380->919|2444->953|2477->956|2505->957
                  LINES: 28->1|33->2|34->3|34->3|34->3|35->4|46->15|46->15|46->15|47->16|47->16|47->16|48->17|51->20|51->20|54->23|54->23|54->23|58->27|59->28|60->29
                  -- GENERATED --
              */
          