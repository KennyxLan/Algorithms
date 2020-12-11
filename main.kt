import java.io.File                     // for file I/O
import kotlin.system.measureNanoTime    // for measurement of running time(ns)
import kotlin.system.measureTimeMillis  // for measurement of running time(ms)

// include my implementations of algorithms
import myInsertionSort.insertionSort
import myMergeSort.mergeSort
import myHeapSort.heapSort
import myQuickSort.quickSort
import myQuickSort.randomizedQuickSort


fun main(){

    val problemSize = 100000
    //loop for each file
    for(i in (0..5)){
        var inputString = File("src/l${i}").readText(Charsets.UTF_8)
        var inputArray = Array(problemSize, {0} )
        var charIndex = 0

        //turn the string into an array of integers
        for( j in 0..(inputArray.size-1)){
            while(inputString[charIndex].toInt() < '0'.toInt() || inputString[charIndex].toInt() > '9'.toInt()){
                charIndex++
                if(charIndex >= inputString.length){
                    println(" >>>>>> charIndex out of bounds <<<<<< ")
                    return
                }
            }
            var num = 0
            do{
                num = num * 10 + inputString[charIndex].toString().toInt()
                charIndex++
            }while(inputString[charIndex].toInt() >= '0'.toInt() && inputString[charIndex].toInt() <= '9'.toInt())

            inputArray[j] = num
        }// finished: turn the string into an array of integers

        var toBeSorted = Array(problemSize, {0})

        // measure runtime of algorithms
        copyArray(inputArray, toBeSorted) // Insertion Sort
        var runtimeInsertionSort = measureTimeMillis{
            insertionSort(toBeSorted, toBeSorted.size)
        }


        copyArray(inputArray, toBeSorted)
        var runtimeMergeSort = measureTimeMillis{  // Merge Sort
            mergeSort(toBeSorted, 0, toBeSorted.size - 1)
        }

        copyArray(inputArray, toBeSorted)  // Heap Sort
        var runtimeHeapSort = measureTimeMillis{
            heapSort(toBeSorted)
        }


        copyArray(inputArray, toBeSorted)
        var runtimeRandomizedQuickSort = measureTimeMillis{  // Quick Sort WITH random partitioning
            randomizedQuickSort(toBeSorted, 0, toBeSorted.size - 1)
        }


    //    copyArray(inputArray, toBeSorted)
    //    var runtimeQuickSort = measureTimeMillis{
    //        quickSort(toBeSorted, 0, toBeSorted.size - 1)
    //    }
        var runtimeQuickSort = 0L  // using this to ignore stack overflow errors


        println("$problemSize,l$i,$runtimeInsertionSort,$runtimeMergeSort,$runtimeHeapSort,$runtimeRandomizedQuickSort,$runtimeQuickSort")

    } // finished: loop for each file
}

fun copyArray(fromArray: Array<Int>, toArray: Array<Int>){
    if(fromArray.size != toArray.size){ // debug
        println(" >>>>>> fromArray.size != toArray.size <<<<<< ")
        println(2/0) // to make program stop
        return
    }else{
        for( i in 0..(fromArray.size-1)){
            toArray[i] = fromArray[i]
        }
    }

}