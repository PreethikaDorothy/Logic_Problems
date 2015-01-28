                                                                     
                                                                     
                                                                     
                                             
package tokenBucketFilter;

import java.util.NoSuchElementException;


/**
 * @author SESA366037
 *
 * @param <T> Generic type
 */
public class Queue<T>{
	LinkedList<T> list;
	public Queue ()
	{
 list=new LinkedList<T>();
	}
	
	/**
	 * @param list List T to traverse the list
	 * @param data value to be added in the stack
	 */
	public void enqueue(T data)
	{
		
			list.addAtEnd(data);
		
	}
		public T dequeue()
		{
			if(list.IsEmpty())
				return null;
			else
			{
			 T value=(T) list.getNodeAt(1).getData();
			 list.DelFirst();
			
			 return value;
			}
		
			 
	}
		public boolean queueEmpty()
		{
			return list.IsEmpty();
		}
	public void printQueue()
	{
		list.display();
	}
	public int getSize()
	{
		return list.getSize();
	}
}


