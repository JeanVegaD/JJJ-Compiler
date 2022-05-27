package com.mobilize.spark

import org.apache.spark.sql.SparkSession

object SessionDriver {

  lazy val session = SparkSession.builder()
    .master("local")
    .appName("Test Snowpark_Extensions")
    .getOrCreate()


}
