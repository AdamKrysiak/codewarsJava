package com.ak.wars

import java.math.BigDecimal
import java.math.RoundingMode

// https://www.codewars.com/kata/56445c4755d0e45b8c00010a

fun fortune(f0:Int, p:Double, c0:Int, n:Int, i:Double):Boolean {
    var cash = BigDecimal(f0)
    var withdraw = BigDecimal(c0)
    val inflation = BigDecimal(i).divide(BigDecimal(100))
    val increase = BigDecimal(p).divide(BigDecimal(100))
    for(year in 1 until n){
        cash = cash.plus(cash.multiply(increase)).minus(withdraw).setScale(3, RoundingMode.HALF_EVEN)
        withdraw = withdraw.plus(withdraw.multiply(inflation)).setScale(3, RoundingMode.HALF_EVEN)
        println("$cash $withdraw")
    }
    return cash.signum()>=0
}

fun main() {
    assert(fortune(1896079, 9.0, 127281, 25, 5.0))
}