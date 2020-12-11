package myQuickSort
// This file contains QuickSort algorithm and Randomized QuickSort algorithm.

// QuickSort algorithm
fun quickSort(arr: Array<Int>, startIndex: Int, endIndex: Int){
    if(startIndex < endIndex){
        var x = arr[endIndex]
        var i = startIndex - 1
        var j = startIndex
        for( j in startIndex..(endIndex - 1)){
            if(arr[j] <= x){
                var swap = arr[i + 1]
                arr[i + 1] = arr[j]
                arr[j] = swap
                i++
            }
        }
        var temp = arr[i + 1]
        arr[i + 1] = x // arr[endIndex]
        arr[endIndex] = temp

        quickSort(arr, startIndex, i)
        quickSort(arr, i + 2, endIndex)
    }
}



// Randomized QuickSort algorithm
fun randomizedQuickSort(arr: Array<Int>, startIndex: Int, endIndex: Int){
    if(startIndex < endIndex){
        // choose a random pivot, and put it at arr[endIndex]
        var randomIndex = (startIndex..endIndex).random()
        var temp = arr[endIndex]
        arr[endIndex] = arr[randomIndex]
        arr[randomIndex] = temp

        // start partitioning
        var x = arr[endIndex]
        var i = startIndex - 1
        for( j in startIndex..(endIndex - 1)){
            if(arr[j] <= x){
                i++
                var swap = arr[i]
                arr[i] = arr[j]
                arr[j] = swap
            }
        }
        var pivotIndex = i + 1
        temp = arr[pivotIndex]
        arr[pivotIndex] = arr[endIndex]
        arr[endIndex] = temp

        randomizedQuickSort(arr, startIndex, pivotIndex - 1)
        randomizedQuickSort(arr, pivotIndex + 1, endIndex)

    }


}