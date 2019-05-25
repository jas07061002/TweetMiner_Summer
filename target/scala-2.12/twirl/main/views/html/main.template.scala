
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>"""),_display_(/*7.13*/page),format.raw/*7.17*/(""" """),format.raw/*7.18*/("""- TweetAnalytics</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Security-Policy" content="font-src 'self' * data: ; img-src 'self' * *.twimg.com">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*10.50*/routes/*10.56*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*10.106*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*11.50*/routes/*11.56*/.Assets.versioned("stylesheets/bootstrap-grid.min.css")),format.raw/*11.111*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*12.50*/routes/*12.56*/.Assets.versioned("stylesheets/bootstrap-reboot.min.css")),format.raw/*12.113*/("""">

    <link rel="stylesheet" media="screen" href=""""),_display_(/*14.50*/routes/*14.56*/.Assets.versioned("stylesheets/salesforce-lightning-design-system.css")),format.raw/*14.127*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*15.50*/routes/*15.56*/.Assets.versioned("stylesheets/salesforce-lightning-design-system.min.css")),format.raw/*15.131*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*16.50*/routes/*16.56*/.Assets.versioned("stylesheets/salesforce-lightning-design-system-vf.min.css")),format.raw/*16.134*/("""">
    <!--  Load site-specific customizations after bootstrap. -->
    <link rel="stylesheet" media="screen" href=""""),_display_(/*18.50*/routes/*18.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*18.97*/("""">
</head>
<body>

<!-- Responsive navbar -->
<div class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">

</div>

"""),_display_(/*27.2*/content),format.raw/*27.9*/("""

"""),format.raw/*29.1*/("""<!-- JS files must be the last in body -->
<script src=""""),_display_(/*30.15*/routes/*30.21*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*30.73*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*31.16*/routes/*31.22*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*31.71*/("""" type="text/javascript"></script>
<script src=""""),_display_(/*32.15*/routes/*32.21*/.Assets.versioned("javascripts/bootstrap.bundle.min.js")),format.raw/*32.77*/("""" type="text/javascript"></script>
	<script src=""""),_display_(/*33.16*/routes/*33.22*/.Assets.versioned("javascripts/custom.js")),format.raw/*33.64*/("""" type="text/javascript"></script>
</body>
</html>"""))
      }
    }
  }

  def render(page:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(page)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (page) => (content) => apply(page)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed May 22 16:52:38 EDT 2019
                  SOURCE: C:/Users/jasmi/Downloads/TweetAnalytics Summer/app/views/main.scala.html
                  HASH: 068f71b94209a97fd936ad8a1a68fc2a1a61c354
                  MATRIX: 952->1|1075->31|1102->32|1171->75|1195->79|1223->80|1512->342|1527->348|1599->398|1678->450|1693->456|1770->511|1849->563|1864->569|1943->626|2023->679|2038->685|2131->756|2210->808|2225->814|2322->889|2401->941|2416->947|2516->1025|2660->1142|2675->1148|2737->1189|2888->1314|2915->1321|2944->1323|3028->1380|3043->1386|3116->1438|3193->1488|3208->1494|3278->1543|3354->1592|3369->1598|3446->1654|3523->1704|3538->1710|3601->1752
                  LINES: 28->1|33->2|34->3|38->7|38->7|38->7|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|45->14|45->14|45->14|46->15|46->15|46->15|47->16|47->16|47->16|49->18|49->18|49->18|58->27|58->27|60->29|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33
                  -- GENERATED --
              */
          