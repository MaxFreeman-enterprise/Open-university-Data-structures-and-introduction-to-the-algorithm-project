/**
 * @file RandomizedSelect
 * @authors Max Freeman & Vadim Volkov
 * @date 2022-05-29
 *
 * @copyright Copyright (c) 2022
 *
 */

/**
 * This class represents all algorithms and functions for RANDOMIZED-SELECT algorithm
 * All algorithms used and functions in this class are taken from the course book & book of answers
 * from heap, we need to use a suitable data structure such as randSelectArr (mostly used in the second algorithm)
 * RANDOMIZED-SELECT uses the procedure RANDOMIZED-PARTITION introduced in
 * Section 7.3. Thus, like RANDOMIZED-QUICKSORT, it is a randomized algorithm, since its
 * behavior is determined in part by the output of a random-number generator. The following
 * code for RANDOMIZED-SELECT returns the ith smallest element of the array A[p .. r].
 */
public class RandomizedSelect {
    private int randSelectArr[]; // global variable of this array class
    int partitionCount; // global variable for counter the amount of the comparisons


    /**
     * The Constructor implements the RandomizedSelect algorithm.
     * The Constructor first copies the given array pointer to the objects array variable for convenience and then implements the algorithm.
     * @param arr - the given array to be copied
     * @param p - The first index of the index(it may also a subarray)
     * @param r - The last index of the index(it may also a subarray)
     * @param i - the smallest i-th number to be returned
     */
    public RandomizedSelect(int arr[],int p,int r,int i)
    {
        this.randSelectArr = arr;
        this.RandomizedSelect(p,r,i);
    }

    /**
     *
     * this function are implementation from book course page 154
     * @param p - The first index of the index(it may also a subarray)
     * @param r - The last index of the index(it may also a subarray)
     * @param i - the smallest i-th number to be returned
     * @return returns the smallest i-th number in the array A[p...r]
     * */
    public int RandomizedSelect(int p,int r,int i)
    {
        int q,k; // q is the random pivot point in the array, and k computes the number k of elements in the subarray A[p..q].
        if(p == r)
            return this.randSelectArr[p];
        q = RandomizedPartition(p,r);
        k = q - p + 1;
        if(i == k) // the pivot value is the answer
            return this.randSelectArr[q];
        else if(i < k)
            return RandomizedSelect(p,q-1,i);
        else
            return RandomizedSelect(q+1,r,i-k);
    }

    /**
     * this function are implementation from book course page 129
     * @param p - The first index of the index(it may also a subarray)
     * @param r - The last index of the index(it may also a subarray)
     * @return calls to Partition function with p & r as values.
     */
    public int RandomizedPartition(int p,int r)
    {
        int i = (int)(Math.random()*(r-p)+p); // Get a random index in the range of p...r
        Exchange(r,i);
        return Partition(p,r);
    }

    /**
     * this function are implementation from book course page 129
     * @param p - The first index of the index(it may also a subarray)
     * @param r - The last index of the index(it may also a subarray)
     * @return returns the next index.
     */
    public int Partition(int p,int r)
    {
        int x , j , i;
        x = randSelectArr[r];
        i = p - 1;
        for(j = p ; j < r ; j++)
        {
            partitionCount ++;
            if(randSelectArr[j] <= x)
            {
                i = i + 1;
                Exchange(i,j);
            }
        }
        Exchange(i+1,r);
        return i+1;
    }


    /**
     * this function are implementation from book course page 129
     * @param p - The first index of the index(it may also a subarray)
     * @param r - The last index of the index(it may also a subarray)
     */
    public void QuickSort(int p, int r)
    {
        if (p < r)
        {
            int q = Partition(p, r);
            QuickSort(p, q - 1);
            QuickSort(q + 1, r);
        }
    }

    /**
     * A private function that exchanges two integers
     * @param x - the current index of the integer in the objects array
     * @param y - the current index of the integer in the objects array
     */
    private void Exchange(int x, int y)
    {
        int tmp;
        tmp = randSelectArr[x];
        randSelectArr[x] = randSelectArr[y];
        randSelectArr[y] = tmp;
    }

    /**
     *  PrintPostQuickSelect Method - Prints the current array in the objects array variable
     */
    public void PrintPostQuickSelect()
    {
        for(int i = 0; i < this.randSelectArr.length; i++)
            System.out.print(randSelectArr[i] + " ");
        System.out.println();
    }
    /**
     *  PrintQuickCount Method - Prints the number of comparisons that have been made by this algorithm
     */
    public void PrintQuickCount()
    {
        System.out.print(this.partitionCount);
    }
    /**
     *  returnQuickCount Method - Returns the number of comparisons that have been made by this algorithm
     * @return number of comparisons that are stored in teh objects variable
     */
    public int returnQuickCount()
    {
        return this.partitionCount;
    }
    /**
     * PrintRandQuickKthNums Method - Prints the current k numbers in the objects array
     */
    public void PrintRandQuickKthNums(int k)
    {
        for(int i = 0; i < k ; i++)
            System.out.print(randSelectArr[i] + " ");
    }
}