                                                                     
                                                                     
                                                                     
                                             
package tokenBucketFilter;


/**
 * @author SESA366037
 *
 */
public class Token {
	private static int token_id=0;   
	public Token(){
  setTokenID();
	}
	//Sets the TokenID
	public void setTokenID(){
		token_id=token_id+1;
	}
	//Returns the TokenID
	public int getTokenID(){
		return token_id;
	}
}
