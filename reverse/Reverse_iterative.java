package reverse;

import reverse.LinkedList.Node;

public class Reverse_iterative <T>{
	public void reverse(LinkedList<T>.Node head,LinkedList<T> list)
	{ 
		
		
		Node current=head;
		Node prev=null;
		Node nextptr;
		if(!list.IsEmpty())
		{
		while(current!=null)
		{
		
			nextptr=current.next;
			current.next=prev;
			prev=current;
			current=nextptr;
		}
		
		list.setHead(prev);
		//list.display();
	}
		else
			System.out.println("List is empty");
	}
}
		