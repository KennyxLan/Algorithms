package myInsertionSort

//// insertionSort algorithm
fun insertionSort(unsortedArray: Array<Int>, numberOfElements: Int){

    for( j in 1..(numberOfElements-1) ){
        var i = j - 1
        val key = unsortedArray[j]
        while( i >= 0 && unsortedArray[i] > key ){
            unsortedArray[i+1] = unsortedArray[i]
            i = i - 1
        }
        unsortedArray[i+1] = key
    }

}