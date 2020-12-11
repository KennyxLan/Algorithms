package myMergeSort
//// mergeSort algorithm
fun mergeSort(unsortedArray: Array<Int>, start: Int, end: Int ){
    if( end > start ){
        // divide
        var mid = (start + end) / 2

        // conquer
        mergeSort(unsortedArray, start, mid)
        mergeSort(unsortedArray, mid+1, end)

        // combine
        val n1 = mid - start + 1
        val n2 = end - mid
        var leftArray = Array<Int>(n1+1, { k -> 0 })
        var rightArray = Array<Int>(n2+1, { k -> 0 })
        for( i in 0 until n1 ){
            leftArray[i] = unsortedArray[start + i]
        }
        for( j in 0 until n2 ){
            rightArray[j] = unsortedArray[mid + 1 + j]
        }
        leftArray[n1] = 2147483647
        rightArray[n2] = 2147483647
        var l = 0
        var r = 0
        for( k in start..end ){
            if(leftArray[l] <= rightArray[r]){
                unsortedArray[k] = leftArray[l]
                l = l + 1
            }else{
                unsortedArray[k] = rightArray[r]
                r = r + 1
            }
        }

    }

}