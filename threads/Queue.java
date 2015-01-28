package threads;

/**
 * @author SESA366037
 * 
 * @param <T>
 *            Generic type
 */
public class Queue<T> {

	/**
	 * @param l
	 *            List object to traverse the list
	 * @param data
	 *            value to be added in the stack
	 */
	
	LinkedListHelper_thread<T> list = new LinkedListHelper_thread<T>();
	// Add element to the end of queue
	public void enqueue(T data) 
		{
			list.addAtEnd(data);
		}
	
	//Check if Queue is empty
	public boolean queueEmpty() {
		return list.IsEmpty();
	}

	// Remove element from the end of queue
	public T dequeue() {

		T value = (T) list.getNodeAt(1).getData();
		list.DelFirst();

		return value;
	}
	

	// Print the queue
	public void printQueue() {
		list.display();
	}
	// Get the queue size
	public int queueSize() {
		return list.getSize();
	}

}
