package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.max

object MaxPrecipitation{
  def parseLine(line:String) = {
    val fields = line.split(",")
    val stationID = fields(0)
    val entryType = fields(2)
    val precipitation = fields(3).toInt
    (stationID,entryType,precipitation)
  }
  /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "MaxPrecipitation")
    val lines = sc.textFile("../1800.csv")
    val parsedlines = lines.map(parseLine)
    val maxPrcp = parsedlines.filter(x => x._2 == "PRCP")
    val stationPrcp = maxPrcp.map(x => (x._1,x._3.toInt))
    val maxPrcpbystation = stationPrcp.reduceByKey( (x,y) => max(x,y) )
    val results = maxPrcpbystation.collect()
    
    for (result <- results.sorted){
      val station = result._1
      val prcp = result._2
      println(s"$station Max Precipitation: $prcp") 
    }
  }
}
