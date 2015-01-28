package tokenBucketFilter;

/**
 * @author SESA366037
 *
 * @param <T>
 */
public class LinkedList<T> {

	public Node head;
	public Node end;
	public Node current;
	public int size;

	public class Node {

		public T data;
		public Node next;
      
		// Returns Value at a Node 
		public T getData() {
			return data;
		}
		//Sets node Value
		public void setData(T data) {
			this.data = data;
		}
		 
		public Node getNext() {
			return next;
		}

		public void setNext(Node temp) {
			this.next = temp;
		}

		public Node(T data) {

			this.data = data;
		}

		public Node() {

			this.next= null;
		}

	}

	public LinkedList(){

		head = null;
		current=head;
		end = null;
		size = 0;
	}
   //Returns the Head node 
	public Node getHead() {
		return head;
	}
   // Sets node as Head
	public void setHead(Node head) {
		this.head = head;
	}
	
    //returns size of list 
	public int getSize() {
		return size;
	}
	
	// To add a loop
	 public void addAloop(int position)
	 {
		 Node current = getNodeAt(position);
		 end.setNext(current);
		 
	 }

	//Adds a node to the beginning of the list
	
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

		while ( count<position) {
			current= current.getNext();
			count++;
		}

		return current;

	}

	//To display the elements of the list 
	public void display() {
		Node current = getHead();

		while (current!= null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
		System.out.print("NULL");
	}
	//Checks if the list is Empty 
	public Boolean IsEmpty() {
		if (this.head == null) {
			return true;
		}

		return false;
	}

	//Adds a node to the End of the List 
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

	//To Add a node at a Specified position
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
			Node current = getNodeAt(position-1);
			temp.setNext(current.getNext());
			current.setNext(temp);
		}
	}

	//Returns the last Node in the List 

	public Node getEnd() {
		return end;
	}
	
	//Deletes the first Node in the List 
	public void DelFirst() {
		if (IsEmpty())
			System.out.println("list is empty");
		
		else if(getSize()==1)
		{
			DelAll();
		}
		else
		{
			setHead(head.getNext());
		size--;

	}
		}

	// Deletes the last element in the list 

	public void DelLast() {
		if (IsEmpty())
			System.out.println("list is empty");
		else if(getSize()==1)
		{
			DelAll();
		}
		else {
			Node current = getNodeAt(size - 1);

			current.setNext(null);
			end = current;
			size--;
			
		}

	}

	//Deletes Element at a Specified Position
	public void DelAtPos(int position) {

		if (IsEmpty())
			System.out.println("list is empty");
		else if(getSize()==1)
		{
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
            current=head;
			head = null;
			end = null;
			size=0;
		}
	}



	
	
	}

