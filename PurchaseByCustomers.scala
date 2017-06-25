package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object PurchaseByCustomers {
  def parsedLines(lines:String)= {
    val fields = lines.split(",")
    val customerID = fields(0).toInt
    val amountSpent = fields(2).toFloat
    (customerID,amountSpent)
  }
   /** Our main function where the action happens */
  def main(args: Array[String]) {
   
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
        
    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "PurchaseByCustomers")
    // Load each line of the source data into an RDD
    val lines = sc.textFile("../customer-orders.csv")
    val rdd = lines.map(parsedLines)
    val amountSpent = rdd.reduceByKey( (x,y) => (x+y))
    val results = amountSpent.collect()
    for (result <- results.sorted){
      val customer = result._1
      val total = result._2
      val formattedTotal = f"$total%.2f"
      println(s"CustomerID:$customer  Total Amount Spent:$formattedTotal")
    }
  }
  
  
}