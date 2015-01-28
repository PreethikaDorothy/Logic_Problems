package Loop;

public class Tester {
	/**
	 * @param
	 */
	public static void main(String args[]) {
		LinkedListHelper<Integer> list1 = new LinkedListHelper<Integer>();
		LinkedListHelper<Integer> list2 = new LinkedListHelper<Integer>();
		Loop_check loop = new Loop_check();
		// list1 functions
		list1.addAtStart(3);
		list1.addAtEnd(4);
		list1.addAtEnd(5);
		list1.addAtStart(2);
		list1.addAtStart(1);
		list1.addAtEnd(6);
		//list1.addAloop(2);
		list1.display();
		
		IteratorCustomized<Integer> itr1=list1.iterator();
		IteratorCustomized<Integer> itr2=list1.iterator();
		IteratorCustomized<Integer> itr3=list1.iterator();
		IteratorCustomized<Integer> itr4=list1.iterator();
		//Check if loop exists
		int n=loop.loopExists(itr1, itr2,itr3);
	 if(n==-1)
		 System.out.println("Loop does not exists");
	 else 
		 System.out.println("Loop at "+n);
	
	 
	 
		

	}
}
