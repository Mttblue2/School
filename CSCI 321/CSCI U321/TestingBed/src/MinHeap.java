public class MinHeap<E extends Comparable<E>>
{
	private E[] heapArray;
	public final int DEFAULT_CAP = 100;
	public int size = 0;

	public MinHeap()
	{
		heapArray = new E<>[DEFAULT_CAP];
	}

	public void add(E value)
	{
		//if there is room in the array to place the next item
		if (size < heapArray.length)
		{
			//put the item in the next available spot
			heapArray[size] = value;

			//if it is not the only item, check to make sure 
			//the heap is still a minheap
			if (size > 0)
				upheap();

			size++;
		}
	}

	private void upheap()
	{
		int index = size;
		int parentIndex = (index - 1) / 2;

		while (index > 0 && heapArray[index].compareTo(heapArray[parentIndex]) < 0)
		{
			swap(index, parentIndex);

			index = parentIndex;
			parentIndex = (index - 1) / 2;

		}
	}

	public int remove()
	{
		int result = heapArray[0];

		heapArray[0] = heapArray[size - 1];
		size--;

		downheap();
		
		return result;
	}

	private void downheap()
	{
		int index = 0;
		int LC = 2 * index + 1;
		int RC = 2 * index + 2;

		while (LC < size && (heapArray[LC] < heapArray[index] ||
							 heapArray[RC] < heapArray[index]))
		{

			// index of where the smallest value is
			//assume it's the left child to start, then check if RC is smaller
			int smallest = LC;
			
			//if there is a RC and RC is smaller
			if (RC < size && heapArray[RC] < heapArray[LC])
				smallest = RC;
			
			//check if the smallest child is less than the parent
			if (heapArray[smallest] < heapArray[index])
				swap(smallest, index);
			
			//update references to repeat process
			index = smallest;
			LC = 2 * index + 1;
			RC = 2 * index + 2;
		}
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}

	private void swap(int index1, int index2)
	{
		int tmp = heapArray[index1];
		heapArray[index1] = heapArray[index2];
		heapArray[index2] = tmp;
	}
}