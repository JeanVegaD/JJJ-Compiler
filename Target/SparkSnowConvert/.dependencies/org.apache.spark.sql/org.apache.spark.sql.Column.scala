package org.apache.spark.sql

class Column extends org.apache.spark.internal.Logging {
   def when(p604: Column, p605: Any) : Column = {}
   def over(p651: expressions.WindowSpec) : Column = {}
   def over() : Column = {}
   def startsWith(other: Column): Column = {}
   def startsWith(literal: String): Column = {}
   def isin(list: Any*): Column = {}
   //def <(other : Any) : Column = {}
   //def <=(other : Any) : Column = {}
   //def <=>(other : Any) : Column = {}
   //def =!=(other : Any) : Column = {}
   //def ===(other : Any) : Column = {}
   def >(other : Any) : Column = {}
   //def >=(other : Any) : Column = {}
   def otherwise(value: Any): Column = {}
   def ||(other: Any): Column = {}
   def &&(other: Any): Column = {}
   def /(other: Any): Column = {}
   def isNotNull(): Column = {}
   def as(list: String*): Column = {}
   def cast(dataType: DataType): Column = {}
   def contains(other: String): Column = {}
   def getItem(key: Any): Column = {}
}

