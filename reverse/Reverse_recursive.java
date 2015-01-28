package reverse;

public class Reverse_recursive <T>{

		public void reverse(LinkedList<T>.Node current,LinkedList<T> list)
		{
			
			if(current==null)
				return;
			if(current.next==null)
			{
				list.setHead(current);
				return;
				}
			reverse(current.next,list);
			current.next.next=current;
			current.next=null;
			
		}
	}

