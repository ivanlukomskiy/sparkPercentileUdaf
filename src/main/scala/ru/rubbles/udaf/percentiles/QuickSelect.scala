package ru.rubbles.udaf.percentiles

import scala.collection.mutable
import scala.util.Random

/**
  * Quick select algorithm implementation on Scala
  * Created by ivanl <ilukomskiy@sbdagroup.com> on 02.06.2017.
  */
object QuickSelect {

  def select(arr: mutable.WrappedArray[Double], pos: Int): Double =
    select(arr, pos, 0, arr.length - 1)

  def select(arr: mutable.WrappedArray[Double], n: Int, leftInit: Int, rightInit: Int): Double = {
    var left: Int = leftInit
    var right: Int = rightInit
    val rand = Random
    while (right >= left) {
      val pivotIndex: Int = partition(arr, left, right, rand.nextInt(right - left + 1) + left)
      if (pivotIndex == n) {
        return arr(pivotIndex)
      } else if (pivotIndex < n) {
        left = pivotIndex + 1
      } else {
        right = pivotIndex - 1
      }
    }
    0
  }

  def partition(
                 arr: mutable.WrappedArray[Double],
                 left: Int,
                 right: Int,
                 pivot: Int
               ): Int = {

    val pivotVal: Double = arr(pivot)
    swap(arr, pivot, right)
    var storeIndex = left
    (left to right).foreach(i => {
      if (arr(i).compareTo(pivotVal) < 0) {
        swap(arr, i, storeIndex)
        storeIndex = storeIndex + 1
      }
    })
    swap(arr, right, storeIndex)
    storeIndex
  }

  def swap(arr: mutable.WrappedArray[Double], i1: Int, i2: Int): Unit = {
    if (i1 != i2) {
      val temp: Double = arr(i1)
      arr.update(i1, arr(i2))
      arr.update(i2, temp)
    }
  }
}
