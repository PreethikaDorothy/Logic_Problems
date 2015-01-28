package tokenBucketFilter;

/**
 * @author SESA366037
 * 
 */

public class Bucket {
	/**
	 * Bucket_Depth is the capacity of the bucket TokenBucket_queue is the queue
	 * in which tokens are stored
	 */
	private int Bucket_Depth;
	Queue<Token> TokenBucket_queue = new Queue<Token>();

	/**
	 * @param depth
	 *            - The capacity of the bucket
	 */
	public Bucket(int depth) {
		setBucket_depth(depth);
	}

	// Sets the capacity of the bucket to Bucket_depth
	public void setBucket_depth(int depth) {

		Bucket_Depth = depth;
	}

	// Returns the Bucket depth
	public int getBucket_depth() {

		return Bucket_Depth;
	}

	// Adds tokens to the token_bucket queue
	public void addToken() {

		Token token = new Token();
		TokenBucket_queue.enqueue(token);

	}

	// Removes tokens from the token_bucket queue
	public Token removeToken() {
		return TokenBucket_queue.dequeue();
	}

	// Returns the number of tokens in the Token_bucket
	public int bucket_count() {

		return TokenBucket_queue.getSize();
	}

}