/**
 * David Sabzanov
 * February 28, 2017
 * Project #1
 */

package sorts;

public class Sorts 
{
    
    private static int[] arraySize = {10,100,1000,10000,100000,200000,300000}; 
    
    private static long MSComparisons = 0L;
    private static long ISComparisons = 0L;    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        experiment1(); //mergesort
        experiment2(); //insertionsort
    }
    
    /*--------------Insertion Sort -----------------------*/
     public static long insertionsort( int[] a)
    {
        ISComparisons = 0;		
        int t = 0;
        int n;
        for(int i = 1 ; i < a.length; i++)
        {
            t = a[i];
            n = i;
            while((n >= 1) && (t < a[n - 1]))
            {
                a[n] = a[n - 1];
                n--;
                ISComparisons++;
            }
            a[n] = t;
        }
        return ISComparisons;
    }

    /* --------------------Merge Sort --------------------*/
    //merges sorted slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length

    public static long merge ( int[] a,  int i, int j , int k)
    {        
        int[] temp = new int[a.length];
        int lowerIndex = i, midIndexPlusOne = j+1, LI = i;
        
	while(lowerIndex <= j && midIndexPlusOne <= k)
        {
            if(a[lowerIndex] < a[midIndexPlusOne])
            {
                temp[LI] = a[lowerIndex];
                LI++;
                lowerIndex++;
                MSComparisons++;
            }
            else
            {
                temp[LI] = a[midIndexPlusOne];
                LI++;
                midIndexPlusOne++;
                MSComparisons++;
            }
	}
	if(lowerIndex > j) 
        {
            while(midIndexPlusOne <= k)
            {	//left sub array exhausted
                temp[LI] = a[midIndexPlusOne];
                LI++;
                midIndexPlusOne++;
            }
	}
        else
        {
            while(lowerIndex <= j) 
            {	//right sub array exhausted
                temp[LI] = a[lowerIndex];
                LI++;
                lowerIndex++;
            }
	}
	
	//write sorted element in array a
	for(LI = i; LI <= k; LI++)
        {
            a[LI] = temp[LI];
	}
        
        return MSComparisons;
    }


    //sorts  a[ i .. k]  for 0<=i <= k < a.length
    private static long mergesort(int[] a, int i , int k)
    {
        int mid = (i + k)/2;
        if (i < k) 
        { 
            mergesort(a, i, mid);
            mergesort(a, mid + 1, k);    
            merge(a,i, mid, k);
        }
        return MSComparisons;
    }

    //Sorts the array using mergesort 
    public static long mergesort(int[] a)
    {
        int i = 0;
        int k = a.length-1; 
        mergesort(a, i, k);
        return MSComparisons;
    }

    public static boolean isSorted(int[] a)
    {
        for (int i = 0; i < a.length-1; i++) 
        {
            if (a.length == 1) 
            {
                return true;
            }
            if (a[i] > a[i+1]) 
            {
                return false;
            }
        }
        return true;
    }  
    
    
    
    
    
    //Driver Methods
    
    public static void experiment1() 
    {
        System.out.println("Merge Sort:");
        System.out.printf("| %8s | %15s | %11s | %14s | %11s |", 
                "n", "C(n)", "C(n)/nlogn", "T(n)", "T(n)/nlogn");
        System.out.println();
        for (int i=0; i<arraySize.length; i++) 
        {
            long averageTime = 0L;
            long finalTime = 0L;
            long averageComparisons = 0L;
            long sumComparisons = 0L;
            for (int j=0; j<5; j++) 
            {
                int[] n = new int[arraySize[i]];
                for (int k = 0; k<n.length; k++) 
                {
                    n[k] = (int)(Math.random() * 1000000);
                }
                
                MSComparisons = 0L;
                
                
                long timeBefore = System.nanoTime();
                mergesort(n);
                long timeAfter = System.nanoTime();
                long endTime = timeAfter - timeBefore;
                finalTime = finalTime + endTime;
                
                sumComparisons = sumComparisons + MSComparisons;                
            }
            double nlogn = arraySize[i]*(Math.log(arraySize[i])/Math.log(2));
            averageComparisons = sumComparisons/5;
            averageTime = finalTime/5;
            double avgCompOverN2 = averageComparisons/nlogn;
            double avgTimeOverN2 = averageTime/nlogn;

            System.out.printf("| %8d | %15d | %11.4f | %14d | %11.4f |", 
                    arraySize[i], averageComparisons, avgCompOverN2, averageTime, avgTimeOverN2);
            System.out.println();
        }
    }
    
    
    
    
    
    
    public static void experiment2() 
    {
        System.out.println("Insertion Sort:");
        System.out.printf("| %8s | %15s | %11s | %14s | %11s |", 
                "n", "C(n)", "C(n)/n^2", "T(n)", "T(n)/n^2");
        System.out.println();
        for (int i=0; i<arraySize.length; i++) 
        {
            long averageTime = 0L;
            long finalTime = 0L;
            long averageComparisons = 0L;
            long sumComparisons = 0L;
            for (int j=0; j<5; j++) 
            {
                int[] n = new int[arraySize[i]];
                for (int k = 0; k<n.length; k++) 
                {
                    n[k] = (int)(Math.random() * 1000000);
                }
                
                ISComparisons = 0L;
                
                
                long timeBefore = System.nanoTime();
                insertionsort(n);
                long timeAfter = System.nanoTime();
                long endTime = timeAfter - timeBefore;
                finalTime = finalTime + endTime;
                
                sumComparisons = sumComparisons + ISComparisons;                
            }
            double nSquared = arraySize[i]*arraySize[i];
            averageComparisons = sumComparisons/5;
            averageTime = finalTime/5;
            double avgCompOverN2 = averageComparisons/nSquared;
            double avgTimeOverN2 = averageTime/nSquared;
            System.out.printf("| %8d | %15d | %11.4f | %14d | %11.4f |", 
                    arraySize[i], averageComparisons, avgCompOverN2, averageTime, avgTimeOverN2);
            System.out.println();
        }
    }
    
}