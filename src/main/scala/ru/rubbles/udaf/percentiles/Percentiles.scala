package ru.rubbles.udaf.percentiles

import org.apache.spark.sql.Row
import ru.rubbles.udaf.UdafCollector

import scala.collection.mutable

/**
  * Spark's UDAF implementation of percentiles with linear interpolation
  * Created by ivanl <ilukomskiy@sbdagroup.com> on 02.06.2017.
  */
class Percentiles(percent: Double) extends UdafCollector {
  override def evaluate(buffer: Row): Any =
    Percentiles.percentile(buffer.getAs[mutable.WrappedArray[Double]](0), percent)
}

object Percentiles {
  def percentile(arr: mutable.WrappedArray[Double], perc: Double): Double = {

    if (arr.isEmpty) return 0
    if (perc >= 100) return arr.max
    if (perc <= 0) return arr.min

    val pos: Double = perc / 100 * (arr.length - 1)

    val floor: Int = Math.floor(pos).toInt

    if (floor == pos) {
      QuickSelect.select(arr, floor)
    } else {
      val pair = QuickSelectPair.selectPair(arr, floor)
      if (pair._1 == pair._2) {
        pair._1
      } else {
        // Do linear interpolation
        pair._1 + (pair._2 - pair._1) * (pos - floor)
      }
    }
  }
}
