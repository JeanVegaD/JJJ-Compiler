package org.apache.spark.sql

import org.apache.spark.SparkContext

 class SparkSession {
	val sparkContext: SparkContext

    def read(): org.apache.spark.sql.DataFrameReader = {}
	def parquet(paths: String*): org.apache.spark.sql.Dataset = {}
}