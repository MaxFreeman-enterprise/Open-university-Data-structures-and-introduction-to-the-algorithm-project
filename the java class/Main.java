/**
 * @file Main
 * @authors Max Freeman & Vadim Volkov
 * @date 2022-05-29
 *
 * @copyright Copyright (c) 2022
 *
 */

import java.util.Scanner;
public class Main
{
    public static void main(String[] arg)
    {
        Scanner scan = new Scanner(System.in);
        int choice , n , k , i;
        int[] userArr , userArrHeap , userArrRandSort , heapSortedMins;

        System.out.println("Please choose the array size you would like to fill");
        n = scan.nextInt();
        userArr = new int[n];
        userArrHeap = new int[n];
        userArrRandSort = new int[n];

        System.out.println("\nPlease enter the k-th smallest numbers you would like to see");
        k = scan.nextInt();
        heapSortedMins = new int[k];

        System.out.println("\nPlease select manual input or random input");
        System.out.println("Enter 1 for manual input");
        System.out.println("Enter 2 for random input");
        choice = scan.nextInt();

        if(choice == 1)
        {

            System.out.println("Now you can fill the array manually, please use spaces between the numbers you write");
            for(i = 0 ; i < n ; i++)
            {
                userArr[i] = scan.nextInt();
                userArrHeap[i] = userArr[i] ;
                userArrRandSort[i] = userArr[i];
            }
            System.out.println("You've finished filling the array");
        }
        else if(choice == 2)
        {
            System.out.println("Filling the array with random numbers.....");
            for(i = 0; i < n; i++)
            {
                userArr[i] = (int)(Math.random()*1000);
                userArrHeap[i] = userArr[i];
                userArrRandSort[i] = userArr[i];
            }
            System.out.println("Done");
        }


        System.out.println("\nThe originals user array is:");
        for(i = 0; i < userArrHeap.length ; i++)
            System.out.print(userArr[i] + " ");

        RandomizedSelect randSelect = new RandomizedSelect(userArrRandSort, 0,n-1,k);
        BuildMinHeap Heap = new BuildMinHeap(userArrHeap);

        System.out.println("\n\nPost Random Select array is: ");
        randSelect.PrintPostQuickSelect();

        randSelect.QuickSort(0, k-1);
        System.out.println("\nPost Random Select and Quick sort array is:");
        randSelect.PrintRandQuickKthNums(k);

        System.out.println("\n\nThe number of Random Select and Quick sort Comparisons is: ");
        randSelect.PrintQuickCount();

        System.out.println("\n\nPost building minimum Heap:");
        Heap.PrintHeap();

        for(i = 0; i <k; i++)
            heapSortedMins[i] = Heap.ExtractMin();

        System.out.println("\nThe Sorted Heap k smallest numbers are:");
        for(i = 0; i < k; i++)
            System.out.print(heapSortedMins[i]+ " ");

        System.out.println("\n\nThe number of MinHeapify and minHeapExtract Comparisons is: ");
        Heap.PrintCompCount();

    }
}