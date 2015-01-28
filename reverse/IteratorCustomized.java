package reverse;
import java.util.Iterator;
public interface IteratorCustomized<E> extends Iterator<E> {
	    
		void traverse();
	    void pass(int p); 
	    E getValue();
	    LinkedList<E>.Node getCurrent();
	 
	   void setToHead();
	    
	}



