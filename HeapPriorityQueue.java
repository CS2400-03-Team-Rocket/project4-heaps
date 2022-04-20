/**
   A class that implements the ADT priority queue by using a maxheap.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class HeapPriorityQueue<T extends Comparable<? super T>>
                   implements HeapPriorityQueueInterface<T>
{
	private MaxHeapInterface<T> pq;	
	
	public HeapPriorityQueue()
	{
		pq = new MaxHeap<>();
	} // end default constructor
	
	public void add(T newEntry)
	{ 
		pq.add(newEntry);
	} // end add
	public T remove()
	{
		return null;
	}

	public T peek()
	{
		return null;
	}
 
	public boolean isEmpty()
	{
		return true;
	}
 
	public int getSize()
	{
		return 0;
	}
 
	public void clear()
	{
		
	}

/* < Implementations of remove, peek, isEmpty, getSize, and clear are here. >
   . . . */
} // end HeapPriorityQueue
