package ru.rubbles.udaf.percentiles

import org.scalatest.Matchers

import scala.collection.mutable

class PercentilesTest extends Matchers {

  def wa(arr: Array[Double]): mutable.WrappedArray[Double] = mutable.WrappedArray.make(arr)

  // Test regular array
  private val input = wa(Array(3.0, 2.0, 1.0, 4.0, 0.0, 5.0))

  Percentiles.percentile(input, 0) shouldBe 0.0
  Percentiles.percentile(input, 100) shouldBe 5.0
  Percentiles.percentile(input, 50) shouldBe 2.5
  Percentiles.percentile(input, 5) shouldBe 0.25
  Percentiles.percentile(input, -1) shouldBe 0.0
  Percentiles.percentile(input, 120) shouldBe 5.0

  // Test singleton array
  private val input2 = wa(Array(1.0))

  Percentiles.percentile(input2, 0) shouldBe 1.0
  Percentiles.percentile(input2, 100) shouldBe 1.0
  Percentiles.percentile(input2, 30) shouldBe 1.0
  Percentiles.percentile(input2, -1) shouldBe 1.0
  Percentiles.percentile(input2, 120) shouldBe 1.0

  // Test empty array
  private val input3 = wa(Array())

  Percentiles.percentile(input3, 0) shouldBe 0.0
  Percentiles.percentile(input3, 100) shouldBe 0.0
  Percentiles.percentile(input3, 30) shouldBe 0.0
  Percentiles.percentile(input3, -1) shouldBe 0.0
  Percentiles.percentile(input3, 120) shouldBe 0.0

  // Test array with duplicates
  private val input4 = wa(Array(3.33, -2.55, -2.55, -2.55, 3.33, 3.33))

  Percentiles.percentile(input4, 10) shouldBe -2.55
  Percentiles.percentile(input4, 90) shouldBe 3.33

}
