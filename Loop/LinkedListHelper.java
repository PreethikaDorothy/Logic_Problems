package Loop;



/**
 * @author Preethika
 * 
 * @param <T>
 */
public class LinkedListHelper<T> {

	private Node head;
	private Node end;
	private Node current;
	private int size;

	public class Node {

		private T data;
		private Node next;

		// Returns Value at a Node
		public T getData() {
			return data;
		}

		// Sets node Value
		public void setData(T data) {
			this.data = data;
		}

		// Returns the next node
		public Node getNext() {
			return next;
		}

		// Sets link to the next Element
		public void setNext(Node temp) {
			this.next = temp;
		}

		// Node constructor sets Node data
		public Node(T data) {

			this.data = data;
		}

		public Node() {

			this.next = null;
		}

	}

	// LinkedListHelper Constructor
	public LinkedListHelper() {

		head = null;
		current = head;
		end = null;
		size = 0;
	}

	// Returns the Head node
	public Node getHead() {
		return head;
	}

	// Sets node as Head
	public void setHead(Node head) {
		this.head = head;
	}

	// returns size of list
	public int getSize() {
		return size;
	}

	// Adds a node to the beginning of the list

	public void addAtStart(T data) {
		Node temp = new Node(data);
		size++;
		if (head == null) {
			setHead(temp);

			end = temp;

		} else {
			temp.setNext(head);
			setHead(temp);
		}

	}

	// To get the Node at a Position
	public Node getNodeAt(int position) {
		Node current = getHead();
		int count = 1;

		while (count < position) {
			current = current.getNext();
			count++;
		}

		return current;

	}

	// To display the elements of the list
	public void display() {
		
		Node current = getHead();

		while (current != null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
		System.out.print("NULL");
		
		System.out.print("\n");
		
	}

	// Checks if the list is Empty
	public Boolean IsEmpty() {
		if (this.head == null) {
			return true;
		}

		return false;
	}

	// Adds a node to the End of the List
	public void addAtEnd(T data) {
		if (IsEmpty()) {
			addAtStart(data);
		}

		else {
			Node temp = new Node(data);
			size++;

			end.setNext(temp);
			end = temp;

		}
	}

	// To add a loop
	public void addAloop(int position) {
		
		Node current = getNodeAt(position);
		end.setNext(current);

	}

	// To Add a node at a Specified position
	public void AddNodeAt(int position, T data) {
		if (position == 1) {
			addAtStart(data);
		}

		else if (position == size) {
			addAtEnd(data);
		}

		else {
			Node temp = new Node(data);
			size++;
			Node current = getNodeAt(position - 1);
			temp.setNext(current.getNext());
			current.setNext(temp);

		}
	}

	// Returns the last Node in the List

	public Node getEnd() {
		return end;
	}

	// Deletes the first Node in the List
	public void DelFirst() {
		if (IsEmpty())
			System.out.println("list is empty");

		else if (getSize() == 1) {
			DelAll();
		} else {
			setHead(head.getNext());
			size--;

		}
	}

	// Deletes the last element in the list

	public void DelLast() {
		if (IsEmpty())
			System.out.println("list is empty");
		else if (getSize() == 1) {
			DelAll();
		} else {
			Node current = getNodeAt(size - 1);

			current.setNext(null);
			end = current;
			size--;

		}

	}

	// Deletes Element at a Specified Position
	public void DelAtPos(int position) {

		if (IsEmpty())
			System.out.println("list is empty");
		else if (getSize() == 1) {
			DelAll();
		}

		else {
			Node current = getNodeAt(position - 1);
			current.setNext(current.getNext().getNext());
			size--;
		}
	}

	// Deletes all the elements in the list

	public void DelAll() {
		if (IsEmpty())
			System.out.println("list is empty");
		else {
			current = head;
			head = null;
			end = null;
			size = 0;
		}
	}

	// Implementing the Iterator interface
	private class LinkListHelperIterator<T> implements IteratorCustomized<T> {

		private Node current;

		public LinkListHelperIterator() {
			current = getHead();
		}

		@Override
		public boolean hasNext() {
			if (current == null)
				return false;
			if (current.getNext() != null)
				return true;
			else
				return false;
		}
       public LinkedListHelper<T>.Node getCurrent()
       {
    	   return (LinkedListHelper<T>.Node)current;
       }
		// To traverse till a given position
		public void traverse() {
			current = current.getNext();

		}
		public void setToHead()
		{
			current=head;
		}

		// To get the Value at a Node

		public T getValue() {

			T ob = (T) current.getData();
			return ob;
		}

		@Override
		public T next() {
			T ob = (T) current.getData();
			// current= current.getNext();

			return ob;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void pass(int p) {

			for (int i = 0; i < p; i++) {
				current = current.getNext();

			}
		}

	}

	public IteratorCustomized<T> iterator() {
		return new LinkListHelperIterator<T>();
	}

}
