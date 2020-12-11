package myHeapSort

fun heapSort(unsortedArray: Array<Int>){
    // build max-heap
    for(i in ( (unsortedArray.size / 2)-1 ) downTo 0){
        heapify(unsortedArray, unsortedArray.size - 1, i)
    }

    // output the elements from the heap
    for(lastHeapIndex in (unsortedArray.size-1) downTo 1){
        var swap = unsortedArray[0]
        unsortedArray[0] = unsortedArray[lastHeapIndex]
        unsortedArray[lastHeapIndex] = swap
        heapify(unsortedArray, lastHeapIndex-1, 0)
    }
}

fun heapify(arr: Array<Int>, endIndex: Int, i: Int){
    var largest = i
    var l = 2 * i + 1
    var r = 2 * i + 2

    if( l <= endIndex && arr[l] > arr[largest] ){
        largest = l
    }
    if( r <= endIndex && arr[r] > arr[largest] ){
        largest = r
    }

    if(largest != i){
        var temp = arr[i]
        arr[i] = arr[largest]
        arr[largest] = temp
        heapify(arr, endIndex, largest)
    }else{
        return
    }

}

/*
fun parent(i: Int): Int{
    return ( (i - 1) / 2 )
}

fun left(i: Int): Int{
    return (i * 2 + 1)
}

fun right(i: Int): Int{
    return (i * 2 + 2)
}

*/