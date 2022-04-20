import java.util.Arrays;
/**
   A class that implements the ADT maxheap by using an array.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private int swaps;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor
   
   public MaxHeap(int initialCapacity)
   {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   public MaxHeap(T[] entries)
   {
      this(entries.length);
      assert integrityOK = true;

      for (int i = 0; i < entries.length; i++)
         heap[i + 1] = entries[i];

      for (int rootI = lastIndex / 2; rootI > 0; rootI--)
         reheap(rootI);
   } // end "optimal" constructor

   public void add(T newEntry)
   {
   // See Segment 27.8.
      checkIntegrity();
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0){
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
         swaps++;
      }
      heap[newIndex] = newEntry;
      lastIndex++;
      ensureCapacity();
   } // end add

   public int getSwaps(){
      return swaps;
   }

   private void reheap(int rootIndex)
   {
      boolean done = false;
      T orphan = heap[rootIndex];
      int leftChildIndex = 2 * rootIndex;

      while (!done && (leftChildIndex <= lastIndex) )
      {
         int largerChildIndex = leftChildIndex; // Assume larger
         int rightChildIndex = leftChildIndex + 1;

         if ( (rightChildIndex <= lastIndex) &&
            heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
         {
         largerChildIndex = rightChildIndex;
         } // end if

         if (orphan.compareTo(heap[largerChildIndex]) < 0)
         {
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
            swaps++;
         }
         else
            done = true;
      } // end while

      heap[rootIndex] = orphan;
   } // end reheap

   public T removeMax()
   {
   // See Segment 27.12.
      checkIntegrity();             
      T root = null;
      
      if (!isEmpty()){
         root = heap[1];            
         heap[1] = heap[lastIndex]; 
         lastIndex--;               
         reheap(1);               
      } 

   return root;               
   } // end removeMax

   public T getMax()
   {
		checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty()
   {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize()
   {
      return lastIndex;
   } // end getSize

   public void clear()
   {
		checkIntegrity();
      while (lastIndex > -1)
      {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear
   
// Private methods
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("MaxHeap object is corrupt.");
   }

   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
         throw new IllegalStateException("Attempt to create a heap whose capacity " +
                                         "exeeds allowed maximum of " + MAX_CAPACITY);
   }

   private void ensureCapacity()
   {
      if (lastIndex >= heap.length - 1)
      {
         int newLength = 2 * heap.length;
         checkCapacity(newLength);
         heap = Arrays.copyOf(heap, newLength);
      }
   }

   public String toString(){
      String output = new String();
      for(int i = 1; i < getSize(); i++){
         output += heap[i] + "\n";
      }
      return output;
   }

// ...
} // end MaxHeap
