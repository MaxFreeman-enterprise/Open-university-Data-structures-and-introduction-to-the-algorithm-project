/**
 * @file RandomizedSelectSortAverage
 * @authors Max Freeman & Vadim Volkov
 * @date 2022-05-29
 *
 * @copyright Copyright (c) 2022
 *
 */


public class RandomizedSelectSortAverage {

    public static void main(String[] arg) {


        int[] randArr100 = new int[100], randArr200 = new int[200], randArr500 = new int[500], randArr1000 = new int[1000],randArr10000 = new int[10000];
        int i, j,total=1000,k=100, k_10000 = 5000;
        int rand100_k_count = 0,rand200_k_count = 0, rand500_k_count = 0, rand1000_k_count = 0,rand10000_k_count= 0 ;

        for(i= 0;i<total;i++)
        {
            for(j= 0 ; j<100 ; j++)
            {
                randArr100[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<200 ; j++)
            {
                randArr200[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<500 ; j++)
            {
                randArr500[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<1000 ; j++)
            {
                randArr1000[j] = (int)(Math.random()*1000);
            }

            for(j= 0 ; j<10000 ; j++)
            {
                randArr10000[j] = (int)(Math.random()*1000);
            }

            RandomizedSelect randSelect100_8 = new RandomizedSelect(randArr100, 0,100-1,k);
            randSelect100_8.QuickSort(0, k-1);

            RandomizedSelect randSelect200_8 = new RandomizedSelect(randArr200, 0,200-1,k);
            randSelect200_8.QuickSort(0, k-1);

            RandomizedSelect randSelect500_8 = new RandomizedSelect(randArr500, 0,500-1,k);
            randSelect500_8.QuickSort(0, k-1);

            RandomizedSelect randSelect1000_8 = new RandomizedSelect(randArr1000, 0,1000-1,k);
            randSelect1000_8.QuickSort(0, k-1);

            RandomizedSelect randSelect10000_8 = new RandomizedSelect(randArr10000, 0,10000-1,k_10000);
            randSelect10000_8.QuickSort(0, k_10000-1);

            rand100_k_count += randSelect100_8.returnQuickCount();
            rand200_k_count +=  randSelect200_8.returnQuickCount();
            rand500_k_count +=  randSelect500_8.returnQuickCount();
            rand1000_k_count += randSelect1000_8.returnQuickCount();
            rand10000_k_count += randSelect10000_8.returnQuickCount();
        }

        System.out.println("The Random Select and QuickSort avarage comparison count for a 100 array and " + k + " smallest integers is: " + rand100_k_count/total);
        System.out.println("The Random Select and QuickSort avarage comparison count for a 200 array and " + k + " smallest integers is: " + rand200_k_count/total);
        System.out.println("The Random Select and QuickSort avarage comparison count for a 500 array and " + k + " smallest integers is: " + rand500_k_count /total);
        System.out.println("The Random Select and QuickSort avarage comparison count for a 1000 array and " + k + " smallest integers is: " + rand1000_k_count /total);
        System.out.println("The Random Select and QuickSort avarage comparison count for a 10000 array and " + k_10000 + " smallest integers is: " + rand10000_k_count /total);
    }







}
