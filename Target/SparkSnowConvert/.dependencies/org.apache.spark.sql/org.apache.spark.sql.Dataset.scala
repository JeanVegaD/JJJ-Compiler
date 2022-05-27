package org.apache.spark.sql

class Dataset {
	def filter(condition: Column): Dataset = {}
	def select(columns: Column*): Dataset = {}
	def as(value: String): Dataset = {}
	def collect(): Array[Row] = {}
	def head(): Row = {}
	def dropDuplicates(col1: String, cols: String*): Dataset = {}
	def dropDuplicates(colNames: Array[String]): Dataset = {}
	def dropDuplicates(colNames: Seq[String]): Dataset = {}
	def dropDuplicates(): Dataset = {}
}
