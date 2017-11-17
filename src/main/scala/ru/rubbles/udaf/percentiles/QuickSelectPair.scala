package ru.rubbles.udaf.percentiles

import scala.collection.mutable
import scala.util.Random

object QuickSelectPair {

  /**
    * Quick select algorithm variation which will select two elements:
    * at the given position and the next one
    */
  def selectPair(arr: mutable.WrappedArray[Double], pos1: Int): (Double, Double) = {
    val pos2 = pos1 + 1

    var left: Int = 0
    var right: Int = arr.length - 1
    val rand = Random
    while (right >= left) {
      val pivotIndex: Int = QuickSelect.partition(arr, left, right, rand.nextInt(right - left + 1) + left)
      if (pivotIndex != pos1 && pivotIndex != pos2) {
        if (pos1 > pivotIndex) {
          left = pivotIndex + 1
        } else {
          right = pivotIndex - 1
        }
      } else {
        if (pivotIndex == pos1) {
          return (arr(pivotIndex), QuickSelect.select(arr, pos2, pivotIndex + 1, right))
        } else {
          return (QuickSelect.select(arr, pos1, left, pivotIndex - 1), arr(pivotIndex))
        }
      }
    }
    (0,0)
  }

}
