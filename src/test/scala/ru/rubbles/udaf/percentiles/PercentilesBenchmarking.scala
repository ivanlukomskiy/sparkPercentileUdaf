package ru.rubbles.udaf.percentiles

import org.scalameter._

import scala.collection.mutable
import scala.util.Random

/**
  * Performs benchmarking on percentiles searching algorithm
  * Created by ivanl <ilukomskiy@sbdagroup.com> on 01.06.2017.
  */
object PercentilesBenchmarking extends Bench.LocalTime {

  /**
    * Sequence of benchmarking input array sizes to measure
    */
  private val range: Seq[Int] = 2000 to 82000 by 2500

  /**
    * Number of measurements on each input array size
    */
  private val loops: Int = 40

  /**
    * Returns array of a given size with random values
    */
  def getTestWrappedArray(size: Int): mutable.WrappedArray[Double] = {
    val fill = Array.fill(size)(new java.lang.Double(Random.nextDouble() * 1000))
    mutable.WrappedArray.make(fill)
  }

  def getRandomPercent: Double = Random.nextDouble() * 100

  override def main(args: Array[String]): Unit = {

    var benchmarkingResults = List.empty[(Int, Double, String)]

    range.foreach(size => {
      println
      println("------------------------------------------------")
      println("Generating the test arrays with size " + size)
      val inputs = (1 to loops).map(i => getTestWrappedArray(size)).toArray
      println("Dataframe reading finished")

      val time = config(
        Key.exec.benchRuns -> loops,
        Key.verbose -> true
      ) withWarmer {
        new Warmer.Default
      } withMeasurer {
        new Measurer.IgnoringGC
      } measure {
        val input = inputs(Random.nextInt(inputs.length))
        val percent = getRandomPercent
        //println("Percentile of " + percent + ": " + Percentiles.percentile(input, percent))
        //println("Element " + QuickSelect.select(input,Math.floor(percent * (size - 1) / 100).toInt))
        println("Element "+quickSortPercentile(input, Math.floor(percent * (size - 1) / 100).toInt))
      }

      benchmarkingResults = (size, time.value, time.units) :: benchmarkingResults
    })

    println
    println("BENCHMARKING RESULTS:")
    benchmarkingResults.foreach(test => {
      println("Size " + test._1 + ", time: " + test._2 + " " + test._3)
    })
  }


  def quickSortPercentile(df: Seq[Double], element: Int): Double = {
    val sorted = df.sorted
    sorted(element)
  }
}
