                                                                     
                                                                     
                                                                     
                                             
package tokenBucketFilter;

import java.util.Date;

/**
 * @author SESA366037
 *
 */

public class Packet {
	/**
	 * Packet_requiredToken -  Number of tokens required for packet transmission from Q1 to Q2
	 *entry_timestamp -Time at which packet enters Q1
	 *exit_timestamp -Time at which packet exits Q1
	 *Packet_ID - Packet id
	 */
private int Packet_requiredToken=0;
private Date entry_timestamp;
private Date exit_timestamp;
private static int Packet_ID = 0;
public Packet()
{
	setEntry_timestamp();
	setPacketID();
	}
//Returns the time at which packet exists Q1
public Date getExit_timestamp() {
	return exit_timestamp;
}
//Set time at which packet exists Q1
public void setExit_timestamp() {
exit_timestamp = new Date();
}

	public Date getEntry_timestamp() {
	return entry_timestamp;
}
public void setEntry_timestamp() {
	entry_timestamp = new Date();
}

public void setPacketID()
	{
		Packet_ID=Packet_ID+1;
	}
	
	public void setRequiredToken(int requiredTokens){
		Packet_requiredToken=requiredTokens;
	}
	
	public int getRequiredToken(){
		return Packet_requiredToken;
	}
	
	public int getPacketID(){

		return Packet_ID ;
	}
	
	

	

}

