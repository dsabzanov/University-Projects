/**
 * David Sabzanov
 * February 28, 2017
 * Project #1
 * 
 * Sorts Class
 */

package sorts;

public class Sorts 
{
    private static long MSComparisons = 0L;
    private static long ISComparisons = 0L;    
    /**
     * @param args the command line arguments
     */
    
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
    
    public void setMSComparison(long c) 
    {
        MSComparisons = c;
    }
    
    public long getMSComparison() 
    {
        return MSComparisons;
    }
    
    public void setISComparison(long c) 
    {
        ISComparisons = c;
    }
    
    public long getISComparison() 
    {
        return ISComparisons;
    }
}