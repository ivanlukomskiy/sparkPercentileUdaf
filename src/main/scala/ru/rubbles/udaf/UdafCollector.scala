package ru.rubbles.udaf

import org.apache.spark.sql.Row
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._

import scala.collection.mutable

/**
  * Abstract class that implement UserDefinedAggregateFunction.
  * Will collect input doubles into the WrappedArray.
  * Evaluation method implementation is left to the subclasses.
  * Array can be extracted from the buffer with `buffer.getAs[mutable.WrappedArray[Double]](0)`
  */
abstract class UdafCollector extends UserDefinedAggregateFunction {

  override def inputSchema: StructType = StructType(StructField("values", DoubleType) :: Nil)

  override def bufferSchema: StructType =
    StructType(StructField("values", DataTypes.createArrayType(DataTypes.DoubleType))
      :: StructField("currentSize", DataTypes.IntegerType)
      :: Nil)

  override def dataType: DataType = DataTypes.DoubleType

  override def deterministic: Boolean = true

  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = new Array[Double](10)
    buffer(1) = 0
  }

  def getArray(buffer: Row): mutable.WrappedArray[Double]
  = buffer.getAs[mutable.WrappedArray[Double]](0)

  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    var array = getArray(buffer)
    val currentSize = buffer.getInt(1)

    // Increase array size if needed
    if (currentSize + 1 > array.length) {
      val newArray = new Array[Double]((currentSize * 3) / 2 + 1)
      array.copyToArray(newArray)
      array = newArray
    }

    if (!input.isNullAt(0)) {
      array.update(currentSize, input.getDouble(0))
      buffer(0) = array
      buffer(1) = currentSize + 1
    }
  }

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    val result = new Array[Double](buffer1.getInt(1) + buffer2.getInt(1))
    getArray(buffer1).copyToArray(result, 0, buffer1.getInt(1))
    getArray(buffer2).copyToArray(result, buffer1.getInt(1), buffer2.getInt(1))
    buffer1(0) = result
  }
}