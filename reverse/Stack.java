package reverse;
import reverse.LinkedList;
import java.util.NoSuchElementException;

import LinkedList.LinkedListHelper;

/**
 * @author SESA366037
 * 
 * @param <T>
 *            Generic type
 */
public class Stack<T> {

	/**
	 * @param list
	 *            - List object to traverse the list
	 * @param data
	 *            value to be added in the stack
	 */
	LinkedList<T> list = new LinkedList<T>();

	// Add element to the stack
	public void push(T data) {
		{
			list.addAtEnd(data);
		}
	}

	// Remove top element from the stack
	public T pop() {

		T value = (T) list.getNodeAt(list.getSize()).getData();
		list.DelLast();

		return value;

	}

	// Get the top element of the stack
	public T stackTop() {
		T value = (T) list.getNodeAt(list.getSize()).getData();
		return value;
	}

	// Print the stack elements
	public void printStack() {
		list.display();
	}

	// check if stack is empty
	public boolean stackEmpty() {
		return list.IsEmpty();
	}

	// Get the stack size
	public int stackSize() {
		return list.getSize();
	}

}
