package org.apache.spark.sql

final class functions {
   // Collection functions
   def collect_list(e: ColumnName): Column = {}
   def concat(p29213: Column*): Column = {}
   def concat_ws(p29261: String, p29262: Column*): Column = {}
   def concat_ws(p29261: String, p29262: ColumnName*): Column = {}
   def concat_ws(p29544: String, p29545: Seq[Column]): Column = {}
   def as(list: String*): Column = {}
   def sum(p29736: String): Column = {}
   def sum(p29737: Column): Column = {}

   // TO DO: Remove this overload when inheritance is fully supported
   def sum(p29736: ColumnName): Column = {}
   def max(p29750: String): Column = {}
   def max(p29751: Column): Column = {}
   def lit(literal: Any): Column = {}
   def lit(literal: Boolean) : Column = {}
   def abs(e: ColumnName) : Column = {}
   def when(condition: Column, value: Any): Column = {}
   def coalesce(e: Column*): Column = {}

   // TO DO: Remove this overload when inheritance is fully supported
   def coalesce(e: ColumnName*): Column = {}
   def size(e: Column): Column = {}
   def trim(e: Column): Column = {}
   def struct(p53845: scala.String, p10298: scala.String*): Column = {}
   def struct(p12445: Column*): Column = {}
   def desc(columnName: String): Column = {}
   def asc(columnName: String): Column = {}
   def dense_rank(): Column = {}
   def datediff(end: Column, start: Column): Column = {}

   // TO DO: Remove these two overloads when inheritance is fully supported
   def datediff(end: ColumnName, start: Column): Column = {}
   def datediff(end: ColumnName, start: ColumnName): Column = {}

   def months_between(end: Column, start: Column, roundOff: Boolean): Column = {}

   // TO DO: Remove this overload when inheritance is fully supported
   def months_between(end: ColumnName, start: Column, roundOff: Boolean): Column = {}

   def months_between(end: Column, start: Column): Column = {}

   // TO DO: Remove these two overloads when inheritance is fully supported
   def months_between(end: ColumnName, start: Column): Column = {}
   def months_between(end: ColumnName, start: ColumnName): Column = {}

   def add_months(start: ColumnName, quantity: Int): Column = {}
   def to_date(dateColumn: Column, format: String): Column = {}
   def col(colName: String): Column = {}
   def column(colName: String): Column = {}
   def explode(column: Column): Column = {}
   def split(str: Column, pattern: String): Column = {}
   def date_format(dateExpr: Column, format: String): Column = {}
   def greatest(exprs: Column*): Column = {}
   def greatest(columnName: String, columnNames: String*): Column = {}
   def least(exprs: Column*): Column = {}
   def least(columnName: String, columnNames: String*): Column = {}
}