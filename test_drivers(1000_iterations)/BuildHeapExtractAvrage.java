/**
 * @file BuildMinHeapExtractAverage
 * @authors Max Freeman & Vadim Volkov
 * @date 2022-05-29
 *
 * @copyright Copyright (c) 2022
 *
 */

public class BuildHeapExtractAvrage {
    public static void main(String[] arg) {
        int[] heapArr100 = new int[100], heapArr200 = new int[200], heapArr500 = new int[500], heapArr1000 = new int[1000],heapArr10000 = new int[10000];
        int i, j,total=10000,k=100, k_10000= 5000;
        int heapArr100_k_count = 0,heapArr200_k_count = 0,heapArr500_k_count = 0,heapArr1000_k_count = 0,heapArr10000_k_count = 0;

        for(i= 0;i<total;i++)
        {
            //Initialising relevant arrays for comparison
            for(j= 0 ; j<100 ; j++)
            {
                heapArr100[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<200 ; j++)
            {
                heapArr200[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<500 ; j++)
            {
                heapArr500[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<1000 ; j++)
            {
                heapArr1000[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<10000 ; j++)
            {
                heapArr10000[j] = (int)(Math.random()*1000);
            }
            //end of Init


            //Start of Heapifiying and exctracting k smallest integers
            BuildMinHeap heap100 = new BuildMinHeap(heapArr100);
            for(j = 0; j <k; j++)
            {
                heap100.ExtractMin();
            }

            BuildMinHeap heap200 = new BuildMinHeap(heapArr200);
            for(j = 0; j <k; j++)
            {
                heap200.ExtractMin();
            }

            BuildMinHeap heap500 = new BuildMinHeap(heapArr500);
            for(j = 0; j <k; j++)
            {
                heap500.ExtractMin();
            }

            BuildMinHeap heap1000 = new BuildMinHeap(heapArr1000);
            for(j = 0; j <k; j++)
            {
                heap1000.ExtractMin();
            }

            BuildMinHeap heap10000 = new BuildMinHeap(heapArr10000);
            for(j = 0; j <k_10000; j++)
            {
                heap10000.ExtractMin();
            }
            //end of Heapifiying and exctracting k smallest integers


            //Start for summation of the comparsion number
            heapArr100_k_count += heap100.RetCompCount();
            heapArr200_k_count +=  heap200.RetCompCount();
            heapArr500_k_count +=  heap500.RetCompCount();
            heapArr1000_k_count += heap1000.RetCompCount();
            heapArr10000_k_count += heap10000.RetCompCount();
            //end of summation
        }

        System.out.println("The BuildMinHeap and ExtractMin average comparison count for a 100 array and " + k + " smallest integers is: " + heapArr100_k_count/total);
        System.out.println("The BuildMinHeap and ExtractMin average comparison count for a 200 array and " + k + " smallest integers is: " + heapArr200_k_count/total);
        System.out.println("The BuildMinHeap and ExtractMin average comparison count for a 500 array and " + k + " smallest integers is: " + heapArr500_k_count/total);
        System.out.println("The BuildMinHeap and ExtractMin average comparison count for a 1000 array and " + k + " smallest integers is: " + heapArr1000_k_count/total);
        System.out.println("The BuildMinHeap and ExtractMin average comparison count for a 10000 array and " + k_10000 + " smallest integers is: " + heapArr10000_k_count/total);
    }
}
