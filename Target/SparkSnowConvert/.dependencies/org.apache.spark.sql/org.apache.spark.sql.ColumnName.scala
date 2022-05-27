package org.apache.spark.sql

class ColumnName {
  def ===(value: Any): Column = {}
  def =!=(other: Any): Column = {}
  def >(other : Any) : Column = {}
  def <(other : Any) : Column = {}
  def -(other : Any) : Column = {}
  val isNull: Column
  val isNotNull: Column
  def asc(): Column = {}
  def desc(): Column = {}
  def *(other: Any): Column = {}
  def isNotNull(): Column = {}
  def isin(list: String*): Column = {}
  def as(list: String*): Column = {}
  def contains(other: String): Column = {}
  def getItem(key: Any): Column = {}
}
