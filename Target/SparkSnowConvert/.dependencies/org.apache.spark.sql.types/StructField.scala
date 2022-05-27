package org.apache.spark.sql.types

class StructField {
	val name: String
	val dataType: DataType
	val nullable: Boolean
}