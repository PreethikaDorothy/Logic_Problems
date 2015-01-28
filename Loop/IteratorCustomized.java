



package Loop;

import java.util.Iterator;
public interface IteratorCustomized<E> extends Iterator<E> {
	    
		void traverse();
	    void pass(int p); 
	    E getValue();
	    LinkedListHelper<E>.Node getCurrent();
	 
	   void setToHead();
	    
	}



