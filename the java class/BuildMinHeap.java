/**
 * @file BuildMinHeap
 * @authors Max Freeman & Vadim Volkov
 * @date 2022-05-29
 *
 * @copyright Copyright (c) 2022
 *
 */



/**
 * This class represents all algorithms and functions for BUILD-MIN-HEAP algorithm
 * All algorithms used and functions in this class are taken from the course book & book of answers
 * from heap, we need to use a suitable data structure such as heapArray (mostly used in the first algorithm)
 */
class BuildMinHeap {
    private int[] heapArray; // global variable of this array class
    private int heapSize; // global variable of the array size
    private int heapCompCount; // global variable for counter the amount of the comparisons


    /**
     * The Constructor implements the build minimum heap algorithm.
     * The Constructor first copies the given array pointer to the objects array variable for convenience and then implements the algorithm.
     * @param arr - the given array to be copied
     */
    public BuildMinHeap(int[] arr)
    {
        int i;
        this.heapSize = arr.length;
        this.heapArray = arr;

        for(i = (this.heapSize/2) - 1; i >=0; i--) // implementation taken from the book course page 111.
            MinHeapify(heapArray,i);
    }

    /**
     * A private function that returns the left child of the current node.
     * @param pos - the current node
     * @return returns the current nodes left child
     */
    private int LeftChild(int pos)
    {
        return (2 * pos) + 1; // The algorithm from the book doesn't account for 0 indexing,
        // so we need an offset of 1 for it to work properly taken from the course book page 106-107
    }

    /**
     * A private function that returns the Right child of the current node.
     * @param pos - the current node
     * @return returns the current nodes Right child
     */
    private int RightChild(int pos)
    {
        return (2 * pos) + 2; // The algorithm from the book doesn't account for 0 indexing,
        // so we need an offset of 1 for it to work properly taken from the course book page 106-107
    }

    /**
     * A private function that exchanges two integers
     * @param x - the current index of the integer in the objects array
     * @param y - the current index of the integer in the objects array
     */
    private void Exchange(int x, int y)
    {
        int tmp; // local temp variable
        tmp = heapArray[x];
        heapArray[x] = heapArray[y];
        heapArray[y] = tmp;
    }

    /**
     * Min-Heapify is an important subroutine for manipulating min-heaps. Its inputs are an
     * array A and an index i into the array. When Min-Heapify is called, it is assumed that the
     * binary trees rooted at LEFT(i) and RIGHT(i) are min-heaps, but that A[i] may be bigger than
     * its children, thus violating the min-heap property. The function of Min-Heapify is to let
     * the value at A[i] "float down" in the min-heap so that the subtree rooted at index 'i' becomes a
     * min-heap.
     * @param heapArray - The objects copied array of the original array in the constructor
     * @param i - The first index of the desired subarray to be heapified
     */
    private void MinHeapify(int heapArray[] , int i)
    {
        int leftC , rightC , smallest;
        leftC = LeftChild(i);
        rightC = RightChild(i);

        heapCompCount++;
        if((leftC <= this.heapSize - 1) && (heapArray[leftC] < heapArray[i])) // this 'if' is implementing question 6.2-2 in the course book
        {
            smallest = leftC;

        }else{
            smallest = i;
        }

        heapCompCount++;
        if((rightC <= this.heapSize - 1) && (heapArray[rightC] < heapArray[smallest])) // this 'if' is implementing question 6.2-2 in the course book
        {
            smallest = rightC;
        }

        if (smallest != i)
        {
            Exchange(i,smallest);
            MinHeapify(heapArray,smallest);
        }
    }

    /**
     * The procedure ExtractMin implements the ExtractMin operation. It is
     * similar to the for loop body (lines 3-5) of the HEAPSORT procedure.
     * similar to the pseudocode learned in the book course page 116
     * @return The root at which the minimum in the Min-Heap resides
     */
    public int ExtractMin()
    {
        if(this.heapSize < 1)
        {
            System.out.print("Heap Underflow");
            return -1;
        }
        int min = heapArray[0];
        heapArray[0] = heapArray[this.heapSize-1];
        this.heapSize--;
        this.MinHeapify(heapArray, 0);
        return min;
    }

    /**
     * Prints the number of comparisons that have been made by this algorithm
     */
    public void PrintCompCount()
    {
        System.out.println(this.heapCompCount);
    }

    /**
     * Returns the number of comparisons that have been made by this algorithm as an integer
     * @return number of comparisons in the heapCompCount variable
     */
    public int RetCompCount()
    {
        return this.heapCompCount;
    }

    /**
     * Prints the current heap array.
     */
    public void PrintHeap()
    {
        for(int i = 0; i < this.heapSize;i++)
            System.out.print(heapArray[i] + " " );
        System.out.println();
    }
}
   