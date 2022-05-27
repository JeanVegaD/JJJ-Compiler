package com.mobilize.spark

import com.snowflake.snowpark.Session
import com.snowflake.snowpark.Extensions
 object SessionDriver {
   lazy val session = SparkSession.builder().master("local").appName("Test Snowpark_Extensions").getOrCreate()
}