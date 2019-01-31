/**
  * Returns the GDP per capita for a country in a given year.
  *
  * Example:
  * Give me a country code (iso3):> fra
  * Give me a year:> 2016
  * The GDP per capita of France in 2016 was 36870.2191344563 USD.
  *
  * NB: as of Scala 2.11, scala-xml needs to be installed for each project (in IntelliJ)
  * see this issue: https://intellij-support.jetbrains.com/hc/en-us/community/posts/206632745-Can-t-import-scala-xml-
*/


import scala.io.StdIn
import scala.xml.XML

object gdp_app extends App { // easier than having to define a class with main()

  // Get user input
  val inputCountry = StdIn.readLine("Give me a country code (iso3):> ")

  print("Give me a year:> ")
  val inputYear = StdIn.readInt()

  // def getGDP function

  def getGDP(country_id: String, year: Int) = {

    val yearString = year.toString

    // create API call
    val url = "http://api.worldbank.org/v2/countries/" + country_id + "/indicators/NY.GDP.PCAP.CD?date=" + yearString + "&format=xml"

    // get XML
    val response = scala.io.Source.fromURL(url).mkString.substring(1)

    // Load XML (it's a type in Scala)
    val xmlResponse = XML.loadString(response)

    val country = (xmlResponse \\ "country").text // extract country
    val gdpvalue = (xmlResponse \\ "value").text // extract value

    printf("The GDP per capita of %s in %s was %s USD.", country, yearString, gdpvalue)

  }

  getGDP(inputCountry, inputYear)

}
