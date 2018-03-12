/**
 * David Sabzanov
 * February 28, 2017
 * Project #1
 * 
 * Driver Class
 */
package sorts;

/**
 *
 * @author davidsabzanov
 */
public class Driver 
{
    
    private static int[] arraySize = {10,100,1000,10000,100000,200000,300000};
    private static Sorts sort = new Sorts();
    
    public static void main(String[] args) 
    {
        int[] a = {5, 2, 1, 9, 7};
        int[] b = {6, 4, 1, 98, 7, 10, 11,};
        // TODO code application logic here
        //Sorts sort = new Sorts();
        //experiment1(); //mergesort
        //experiment2(); //insertionsort
        Sorts.mergesort(a);
        Sorts.mergesort(b);
        System.out.println(sort.getMSComparison());
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
                sort.setMSComparison(0L);
                //MSComparisons = 0L;
                
                
                long timeBefore = System.nanoTime();
                Sorts.mergesort(n);
                long timeAfter = System.nanoTime();
                long endTime = timeAfter - timeBefore;
                finalTime = finalTime + endTime;
                
                sumComparisons = sumComparisons + sort.getMSComparison();                
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
                sort.setISComparison(0L);
                //ISComparisons = 0L;
                
                
                long timeBefore = System.nanoTime();
                Sorts.insertionsort(n);
                long timeAfter = System.nanoTime();
                long endTime = timeAfter - timeBefore;
                finalTime = finalTime + endTime;
                
                sumComparisons = sumComparisons + sort.getISComparison();                
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