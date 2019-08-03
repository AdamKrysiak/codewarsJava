package com.ak.wars

//https://www.codewars.com/kata/next-bigger-number-with-the-same-digits/train/kotlinNext bigger number with the same digits

fun nextBiggerNumber(n: Long): Long {
    val listOfNumbers = n.toString()
            .split("")
            .filter { !it.isBlank() }
            .map { it.toLong() }
    for (subsetSize in listOfNumbers.size - 2 downTo 0) {
        val potentialSubset = listOfNumbers.subList(subsetSize, listOfNumbers.size)
        if (!isOrderedDescending(potentialSubset)) {
            val firstSmallElement = potentialSubset[0]
            val sortedSubset = potentialSubset.sorted().toMutableList()
            val firstBiggerElement = sortedSubset[sortedSubset.lastIndexOf(firstSmallElement) + 1]
            sortedSubset.remove(firstBiggerElement)
            sortedSubset.add(0, firstBiggerElement)
            return (listOfNumbers.subList(0, subsetSize) + sortedSubset)
                    .joinToString(separator = "") { it.toString() }
                    .toLong()
        }
    }
    return n
}

fun isOrderedDescending(numbers: List<Long>): Boolean {
    return numbers.sortedDescending() == numbers
}


fun main() {
    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true)
    assert(21L == nextBiggerNumber(12))
    assert(531L == nextBiggerNumber(513))
    assert(2071L == nextBiggerNumber(2017))
    assert(441L == nextBiggerNumber(414))
    assert(414L == nextBiggerNumber(144))
    assert(469630968L == nextBiggerNumber(469630896))
    assert(59884848483559 == nextBiggerNumber(59884848459853))
}

