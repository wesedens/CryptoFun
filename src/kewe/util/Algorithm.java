package kewe.util;

public class Algorithm
{
   /**
    * This function finds the max of any class that implements a compareTo method
    * @param a array to search
    * @return largest element
    */
   public static <AnyType extends Comparable<? super AnyType>>
   AnyType findMax(AnyType [] a)
   {
      int maxIndex = 0;
      
      for(int i=1; i<a.length; ++i)
      {
         if (a[i].compareTo(a[maxIndex]) > 0)
         {
            maxIndex = i;
         }
      }
      return a[maxIndex];
   }
   
   /**
    * This function finds the max of any class that implements a compareTo method
    * @param a array to search
    * @return index of largest element
    */
   public static <AnyType extends Comparable<? super AnyType>>
   int findMaxIndex(AnyType[]a )
   {
      int maxIndex = 0;
      
      for(int i=1; i<a.length; ++i)
      {
         if (a[i].compareTo(a[maxIndex]) > 0)
         {
            maxIndex = i;
         }
      }
      return maxIndex;
   }
   
   
   public static <AnyType extends Comparable<? super AnyType>> 
   void SortInd(AnyType[] arr, int[] index)
   {
      quicksort(arr, index, 0, index.length - 1);
   }

   private static <AnyType extends Comparable<? super AnyType>> 
   void quicksort(AnyType[] a, int[] index, int left, int right)
   {
      if (right <= left)
         return;
      int i = partition(a, index, left, right);
      quicksort(a, index, left, i - 1);
      quicksort(a, index, i + 1, right);
   }

   private static <AnyType extends Comparable<? super AnyType>>
   int partition(AnyType[] a, int[] index, int left, int right)
   {
      int i = left - 1;
      int j = right;
      while (true)
      {
         while (a[++i].compareTo(a[right]) == -1); // find item on left to swap
                                                   // a[right] acts as sentinel
         while (a[right].compareTo(a[--j]) == -1)  // find item on right to swap
         {
            if (j == left)
            {
               break;                              // don't go out-of-bounds  
            }
         }
         if (i >= j)
         {
            break;                                 // check if pointers cross  
         }
         exch(a, index, i, j);                     // swap two elements into place
      }
      exch(a, index, i, right);                    // swap with partition element
      return i;
   }

   // exchange a[i] and a[j]
   private static <AnyType extends Comparable<? super AnyType>> void exch(
         AnyType[] a, int[] index, int i, int j)
   {
      AnyType swap = a[i];
      a[i] = a[j];
      a[j] = swap;
      int b = index[i];
      index[i] = index[j];
      index[j] = b;
   }
}
