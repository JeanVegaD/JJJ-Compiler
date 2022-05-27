package org.apache.spark.sql

class DataFrame{
  val columns: Seq[String];
  def drop(col: Column*): DataFrame = {};
  def withColumnRenamed(existingName: String, newName: String): DataFrame = {};
  def withColumn(colName: String, col: org.apache.spark.sql.Column) : DataFrame = {};

  // TODO: Move coalesce function to Dataset[T] when type alias is more stable
  def coalesce(numPartitions: Int): DataFrame = {}

  // TODO: Move cacheAsParquet function to com.nomura.cts.ftg.liquidity.tools.io.SaveData.scala when implicit functions are ready
  def cacheAsParquet(NAME: String, TABLE_NAME: String, compression: Boolean=true, logPartitionStats: Boolean=false): DataFrame = {}
  def select(cols: org.apache.spark.sql.Column*): DataFrame = {}

  // TODO: Remove this overload when inheritance is fully supported
  def select(cols: org.apache.spark.sql.ColumnName*): DataFrame = {}
  def select(cols: String*): DataFrame = {}
  def collect(): Array[String] = {}
  def filter(col: org.apache.spark.sql.Column): DataFrame = {}
  def groupBy(cols: org.apache.spark.sql.ColumnName*): DataFrame = {}
  def agg(expr: Column, exprs: org.apache.spark.sql.ColumnName*): DataFrame = {}
  def dropDuplicates(colNames: scala.String*): Dataset = {}
  def join(right: DataFrame, usingColumns: Seq[String], joinType: String): DataFrame = {}
}
