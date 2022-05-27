package org.apache.spark.sql.expressions

class WindowSpec { 
	def orderBy(cols: org.apache.spark.sql.ColumnName*): WindowSpec = {}
	def orderBy(colName: String, colNames: String*): WindowSpec = {}
	def orderBy(col1: org.apache.spark.sql.Column, col2: org.apache.spark.sql.ColumnName): WindowSpec = {}
}

class Window {
	def partitionBy(cols: org.apache.spark.sql.Column*): WindowSpec = {}
	def partitionBy(colName: String, colNames: String*): WindowSpec = {}
	// TO DO: Remove this overload when PBI# 487082 is done
	def partitionBy(colNames: String*): WindowSpec = {}
}