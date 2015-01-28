package tokenBucketFilter;

/**
 * @author SESA366037
 * 
 */
public class TokenBucket implements Runnable {
	// r- Token arrival rate in the Token bucket 
	private int r;
	private Bucket TokenBucket;
	private Token token;

	/**
	 * @param bucket
	 *            - Reference to the TokenBucket
	 * @param token_arrivalRate
	 *            -Rate at which the tokens arrive at the bucket
	 */
	public TokenBucket(Bucket bucket, int token_arrivalRate) {

		r = token_arrivalRate;
		TokenBucket = bucket;
	}

	public void run() {
		try {
			int i = 0;
			while (true) {
				// If the TokenBucket is not full, add tokens to the bucket
				if (TokenBucket.bucket_count() <= TokenBucket.getBucket_depth()) {
					TokenBucket.addToken();
					System.out.println(++i+". Token  added to Token Bucket");
					Thread.sleep(r);
				}
			}
		} catch (InterruptedException e) {
			System.err.println("Token Bucket is Interrupted");
		}
	}
}
